package com.translatable.thebrain.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.translatable.thebrain.BrainXmlParser;
import com.translatable.thebrain.Node;
import com.translatable.thebrain.jaxb.Attachment;
import com.translatable.thebrain.jaxb.Attribute;
import com.translatable.thebrain.jaxb.AttributeData;
import com.translatable.thebrain.jaxb.Attributes;
import com.translatable.thebrain.jaxb.BrainData;
import com.translatable.thebrain.jaxb.Entry;
import com.translatable.thebrain.jaxb.Link;
import com.translatable.thebrain.jaxb.Thought;

public class BrainXmlParserTest {

	//@Test
//	public void testNodeLevel() {
//		// Build test Nodes with parents
//		
//		BrainXmlParser parser = new BrainXmlParser();
//		
//		try {
//			
//			// Level 1 node
//			Node n1 = new Node("017ADEB7-F66B-8D0A-8087-B11840152C33", "Java");
//			n1.addChild("9DBDE3A2-19F6-2528-263B-491D3C722F7C", "");
//			
//			// Level 2 node
//			Node n2 = new Node("9DBDE3A2-19F6-2528-263B-491D3C722F7C", "Exceptions");
//			n2.addParent("017ADEB7-F66B-8D0A-8087-B11840152C33", "");
//			n2.addChild("0207A0EF-195D-BF01-9E21-C62639255162", "");
//	
//			// Level 3 node
//			Node n3 = new Node("0207A0EF-195D-BF01-9E21-C62639255162", "PersistenceExceptions");
//			n3.addParent("9DBDE3A2-19F6-2528-263B-491D3C722F7C", "");
//			
//			// Level 3 and 4 node
//			Node n4 = new Node("8E66FDD8-3D6D-B033-F434-3B4B006348E6", "DataAccessException");
//			n4.addParent("9DBDE3A2-19F6-2528-263B-491D3C722F7C", ""); // Exceptions
//			n4.addParent("0207A0EF-195D-BF01-9E21-C62639255162", ""); // PersistenceExceptions
//			
//			parser.addNode(n1);
//			parser.addNode(n2);
//			parser.addNode(n3);
//			parser.addNode(n4);
//			
//			assertEquals("Level 1 node must return level 1", 1, parser.nodeLevel(n1));
//			assertEquals("Level 2 node must return level 2", 2, parser.nodeLevel(n2));
//			assertEquals("Level 3 node must return level 3", 3, parser.nodeLevel(n3));
//			assertEquals("Node on multiple levels must return topmost level", 3, parser.nodeLevel(n4));
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void testBuildOrgFile() {
		System.out.println("Starting test: testBuildOrgFile");
		BrainXmlParser parser = new BrainXmlParser();
		parser.buildOrgFile("xml/Java.xml", "Java.org");
	}
	
	//@Test
	public void testParse() {
		BrainXmlParser parser = new BrainXmlParser();
		BrainData brainData = parser.unmarshall("xml/Java.xml");
		
		System.out.println("Source.guid: " + brainData.getSource().getGuid());
		
		// Print out all the main types
		
		List<Attribute> attributes = brainData.getAttributes().getAttribute();
		for (Attribute a : attributes) {
			System.out.println("attribute.name: " + a.getName() + "   attribute.guid: " + a.getGuid());
		}
		
		List<Thought> thoughts = brainData.getThoughts().getThought();
		for (Thought t : thoughts) {
			System.out.println("thought.name: " + t.getName() + "   thought.guid: " + t.getGuid());
		}
		
		List<Link> links = brainData.getLinks().getLink();
		for (Link l : links) {
			System.out.println("link.name: " + l.getName() + "   link.guid: " + l.getGuid());
		}
		
		List<AttributeData> attributeDatas = brainData.getAttributeDatas().getAttributeData();
		for (AttributeData ad : attributeDatas) {
			System.out.println("attributeData.attributeGuid: " + ad.getAttributeGuid() + "  attributeData.data: " + ad.getData() +  "   attributeData.guid: " + ad.getGuid());
		}
		
		List<Entry> entries = brainData.getEntries().getEntry();
		for (Entry e : entries) {
			System.out.println("entry.body: ");
			System.out.println(e.getBody());
		}
		
		List<Attachment> attachments = brainData.getAttachments().getAttachment();
		for (Attachment a : attachments) {
			System.out.println("attachment.name: " + a.getName() + "   attachment.location: " + a.getLocation());
		}
	}

}
