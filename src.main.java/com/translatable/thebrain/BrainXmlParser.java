package com.translatable.thebrain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import com.translatable.thebrain.jaxb.Attachment;
import com.translatable.thebrain.jaxb.Attribute;
import com.translatable.thebrain.jaxb.AttributeData;
import com.translatable.thebrain.jaxb.BrainData;
import com.translatable.thebrain.jaxb.Entry;
import com.translatable.thebrain.jaxb.EntryObject;
import com.translatable.thebrain.jaxb.EntryObjects;
import com.translatable.thebrain.jaxb.Link;
import com.translatable.thebrain.jaxb.Thought;

/*
 * Based on sample unmarshall-read project from jaxb-ri-2.2.7 reference (in workspace)
 */
public class BrainXmlParser {
	
	private HashMap<String, Node> nodes = new HashMap<String, Node>();
	private HashMap<String, Node> tags = new HashMap<String, Node>();
	private HashMap<String, HashSet<Node>> nodeParents = new HashMap<String, HashSet<Node>>();
	private StratifiedNodeMap tieredNodes = new StratifiedNodeMap();
	private PrintWriter writer = null;
	
	 public enum ThoughtType {
	        THOUGHT("0"), TAG("3");
	        private String value;

	        private ThoughtType(String value) {
	                this.value = value;
	        }
	};
	
	public void buildOrgFile(String file, String output) {
		BrainData brainData = unmarshall(file);
		
		try {
			writer = new PrintWriter(output, "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		List<Attribute> attributes = brainData.getAttributes().getAttribute();
		for (Attribute a : attributes) {
			////System.out.println("attribute.name: " + a.getName() + "   attribute.guid: " + a.getGuid());
		}
		
		// Brain XML represents Tags as Thoughts, so we will have some Nodes which are tags
		List<Thought> thoughts = brainData.getThoughts().getThought();
		for (Thought t : thoughts) {
			////System.out.println("thought.name: " + t.getName() + "   thought.guid: " + t.getGuid());
			// Update nodes - pass 1
			if (t.getIsType().equals(ThoughtType.THOUGHT.value))
				nodes.put(t.getGuid(), new Node(t.getGuid(), t.getName()));
			else if (t.getIsType().equals(ThoughtType.TAG.value))
				tags.put(t.getGuid(), new Node(t.getGuid(), t.getName()));
		}
		
		List<Link> links = brainData.getLinks().getLink();
		for (Link l : links) {
			////System.out.println("link.name: " + l.getName() + "   link.guid: " + l.getGuid());
			// Update nodes - pass 2
			Node n = null;
			
			// Link might be for a tag
//			if (nodes.containsKey(l.getIdA()))
//				n = nodes.get(l.getIdA());
//			else
//				continue;
			
			// Determine if this is a tag
			if (l.getIsBackward().equals("1") && l.getMeaning().equals("4")) {
				Node tag = tags.get(l.getIdA());
				Node thought = nodes.get(l.getIdB());
				System.out.println("Add tag: " + tag.getName() + " to node: " + thought.getName());
				thought.addTag(tag.getName());
				continue;
			} else {
				n = nodes.get(l.getIdA());
			}
			
			// Determine if parent, child or peer link
			// The A node is original node, the B is the one that was linked to
			// Parent-child links can travel either way, it depends on if the link was created from the parent or from the child
			try {
				if (l.getDir().equals("1")) {
					// child
					n.addChild(l.getIdB(), l.getName());
					Node child = nodes.get(l.getIdB());
					if (nodeParents.get(l.getIdB()) == null)
						nodeParents.put(l.getIdB(), new HashSet<Node>());
					nodeParents.get(l.getIdB()).add(n);
					////System.out.println("added child: " + child.getName() + "  to node: " + n.getName());
					child.addParent(l.getIdA(), l.getName());
					if (!child.hasParent(l.getIdA())) {
						////System.out.println("adding parent: " + n.getName() + "  to node: " + child.getName());
						child.addParent(l.getIdA(), l.getName());
					}
				} else if (l.getDir().equals("2")) {
					// parent
					n.addParent(l.getIdB(), l.getName());				
					Node parent = nodes.get(l.getIdB());
					if (nodeParents.get(l.getIdA()) == null)
						nodeParents.put(l.getIdA(), new HashSet<Node>());
					nodeParents.get(l.getIdA()).add(parent);
					////System.out.println("added parent: " + parent.getName() + "  to node: " + n.getName());
					if (!parent.hasChild(l.getIdA())) {
						////System.out.println("adding child: " + n.getName() + "  to node: " + parent.getName());
						parent.addChild(l.getIdA(), l.getName());
					}
				} else if (l.getDir().equals("3")) {
					// peer
					n.addPeer(l.getIdB(), l.getName());
					Node peer = nodes.get(l.getIdB());
					////System.out.println("added peer: " + peer.getName() + "  to node: " + n.getName());
					if (!peer.hasPeer(l.getIdA())) {
						////System.out.println("adding peer: " + n.getName() + "  to node: " + peer.getName());
						peer.addPeer(l.getIdA(), l.getName());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		List<Entry> entries = brainData.getEntries().getEntry();
		for (Entry e : entries) {
			////System.out.println("entry.body: ");
			////System.out.println(e.getBody());
			// Update nodes - pass 4
			EntryObjects eo = e.getEntryObjects();
			List<EntryObject> objects = eo.getEntryObject();
			String thoughtId = objects.get(0).getObjectID();
			System.out.println("thoughtId: " + thoughtId);
			Node n = nodes.get(thoughtId);
			n.setNote(e.getBody());
		}
		
		// Process nodes and set levels
		for (Node n : nodes.values()) {
			// TODO process all nodes with no parents first to ensure we get top-down processing
			if (n.getParents().size() == 0) {
				processNodeTopDown(n, null, nodeParents);
			}
			//printNodeAndChildren(n);
		}
		
		// Stratify the nodes into tiers
		System.out.println("STRATIFY NODES");
		for (Node n : nodes.values()) {
			System.out.println("stratify: " + n.getName());
			if (n.getParents().size() == 0)
				tieredNodes.put(1, n);
			for (Relationship p : n.getParents()) {
				tieredNodes.put(n.getLevel(p.getId()), n);
			}
		}
		
		List<Node> topNodes = tieredNodes.get(1);
		for (Node n : topNodes) {
			////System.out.println("topNode: " + n.getName());
			// TODO pass parent context here
			writeNodeToText(n, null);
		}
		
		writer.close();
	}
	
	private void processNodeTopDown(Node node, Node parent, HashMap<String, HashSet<Node>> pNodes) {
		//Set<Node> children = nodes.get(node.getGuid());
		List<Relationship> children = node.getChildren();
		System.out.println("process node: " + node.getName());
		if (parent != null) {
			node.setParentInPath(parent.getGuid());
			node.setGrandparentInPath(parent.getParentInPath());
		}
		
		if (parent != null) {
			node.setLevel(parent.getGuid(), parent.getLevel(node.getGrandparentInPath()) + 1);
		} else {
			node.setLevel(null, 1);
		}
		
		if (children != null) {
			for (Relationship c : children) {
				Node child = nodes.get(c.getId());
				System.out.println("child: " + child.getName());
				//if (!child.isProcessed()) {
					processNodeTopDown(child, node, pNodes);
				//}
			}
		}
		
		//node.setProcessed(true);
		
		System.out.println("done processing: " + node.getName());
	}
	
	private void writeNodeToText(Node node, String parent) {
		//System.out.println("writeNodeToText node: " + node.getName() + " level: " + node.getLevel());
		StringBuilder line = new StringBuilder();
		for (int i = 0; i < node.getLevel(parent); i++) {
			line.append("*");
		}
		line.append(" "); // space after stars, before heading text
		line.append(node.getName());
		
		// append tags
		if (node.getParents().size() > 1)
			line.append("     :has_multiple_parents:");
		for (String t : node.getTags()) {
			// org mode does not allow tag names containing spaces
			t = t.replaceAll(" ", "_");
			
			// add extra space if a tag already doesn't exist on the line
			int count = line.toString().length() - line.toString().replace(":", "").length();
			if (count < 2) {
				line.append(" ");
				line.append(":" + t + ":");
			} else {
				line.append(t + ":");
			}
		}
		writer.println(line);
		
		// output note entry
		if (node.getNote() != null && !node.getNote().equals("")) {
			writer.print(node.getNote());
			writer.println();
		}
		
		// output children
		List<Relationship> children = node.getChildren();
		for (Relationship c : children) {
			Node n2 = nodes.get(c.getId());
			writeNodeToText(n2, node.getGuid());
		}
		
		// output peer links
		List<Relationship> peers = node.getPeers();
		for (Relationship p : peers) {
			Node peer = nodes.get(p.getId());
			
			StringBuilder line2 = new StringBuilder();
			for (int i = 0; i < node.getLevel(parent) + 1; i++) {
				line2.append("*");
			}
			line2.append(" "); // space after stars, before heading text

			if (p.getCaption() != null && !p.getCaption().equals("")) {
				line2.append(p.getCaption());
				line2.append(" ");
			} else {
				line2.append("Related to ");
			}
			line2.append("[[*" + peer.getName() + "]]");
			writer.println(line2);
		}
	}
	
	public BrainData unmarshall(String file) {
		BrainData bd = null;
		try {
            // create a JAXBContext capable of handling classes generated into
            // the primer.po package
            JAXBContext jc = JAXBContext.newInstance( "com.translatable.thebrain.jaxb" );
            
            // create an Unmarshaller
            Unmarshaller u = jc.createUnmarshaller();
            
            // unmarshal a BrainData instance document into a tree of Java content
            // objects composed of classes from the primer.po package.
            Source source = new StreamSource(new FileInputStream(file));
            JAXBElement<BrainData> root = u.unmarshal(source, BrainData.class);
            bd = (BrainData) root.getValue();
            
            // examine some of the content in the PurchaseOrder
//            //System.out.println( "Ship the following items to: " );
//            
//            // display the shipping address
//            USAddress address = po.getShipTo();
//            displayAddress( address );
//            
//            // display the items
//            Items items = po.getItems();
//            displayItems( items );
		} catch (JAXBException je) {
			je.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return bd;
	}
	
	public void addNode(Node node) {
		nodes.put(node.getGuid(), node);
	}
	
//    public static void displayAddress( USAddress address ) {
//        // display the address
//        //System.out.println( "\t" + address.getName() );
//        //System.out.println( "\t" + address.getStreet() ); 
//        //System.out.println( "\t" + address.getCity() +
//                            ", " + address.getState() + 
//                            " "  + address.getZip() ); 
//        //System.out.println( "\t" + address.getCountry() + "\n"); 
//    }
//    
//    public static void displayItems( Items items ) {
//        // the items object contains a List of primer.po.ItemType objects
//        List itemTypeList = items.getItem();
//
//                
//        // iterate over List
//        for( Iterator iter = itemTypeList.iterator(); iter.hasNext(); ) {
//            Items.Item item = (Items.Item)iter.next(); 
//            //System.out.println( "\t" + item.getQuantity() +
//                                " copies of \"" + item.getProductName() +
//                                "\"" ); 
//        }
//    }
	
	private void printNodeAndChildren(Node n) {
		StringBuilder sb = new StringBuilder();
		List<Relationship> children = n.getChildren();
		for (Relationship r : children) {
			sb.append(nodes.get(r.getId()).getName() + ", ");
		}
		System.out.println("node: " + n.getName() + " children: " + sb.toString());
	}

}
 