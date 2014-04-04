package com.translatable.thebrain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Node {
	private HashMap<String, Relationship> children = new HashMap<String, Relationship>();
	private HashMap<String, Relationship> parents = new HashMap<String, Relationship>();
	private HashMap<String, Relationship> peers = new HashMap<String, Relationship>();
	private String parentInPath = null;
	private String grandparentInPath = null;
	private String guid = null;
	private String name = null;
	private String note = null;
	private HashMap<String, Integer> levels = new HashMap<String, Integer>();
	private boolean isProcessed = false;
	private ArrayList<String> tags = new ArrayList<String>();
	
	public ArrayList<String> getTags() {
		return tags;
	}

	public void addTag(String tag) {
		if (!this.tags.contains(tag))
			this.tags.add(tag);
	}

	public String getParentInPath() {
		return parentInPath;
	}

	public void setParentInPath(String parentInPath) {
		this.parentInPath = parentInPath;
	}

	public String getGrandparentInPath() {
		return grandparentInPath;
	}

	public void setGrandparentInPath(String grandparentInPath) {
		this.grandparentInPath = grandparentInPath;
	}
	
	public boolean isProcessed() {
		return isProcessed;
	}

	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	public int getLevel(String parent) {
		return levels.get(parent);
	}

	public void setLevel(String parent, int level) {
		this.levels.put(parent, level);
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Node(String guid, String name) {
		this.guid = guid;
		this.name = name;
	}
	
	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean hasChild(String id) {
		if (children.get(id) != null)
			return true;
		return false;
	}

	public void addChild(String id, String label) throws Exception {
		//System.out.println("addChild id: " + id + "  label: " + label);
		if (id.equals(guid))
			throw new Exception("Cannot add child to itself");
		if (children.containsKey(id))
			throw new Exception("Node already has child: " + id);
		children.put(id, new Relationship(id, label));
	}
	
	public boolean hasParent(String id) {
		if (parents.get(id) != null)
			return true;
		return false;
	}
	
	public void addParent(String id, String label) throws Exception {
		//System.out.println("addParent id: " + id + "  label: " + label);
		if (id.equals(guid))
			throw new Exception("Cannot add parent to itself");
		if (parents.containsKey(id))
			throw new Exception("Node already has parent: " + id);
		parents.put(id, new Relationship(id, label));
	}
	
	public boolean hasPeer(String id) {
		if (peers.get(id) != null)
			return true;
		return false;
	}
	
	public void addPeer(String id, String label) throws Exception {
		// The best we can do here for Org Mode is to create search-based links. We cannot generate GUID links in Org Mode here.
		// Or, print a report of all peers for now and manually fix up the links in Org Mode later.
		//System.out.println("addPeer id: " + id + "  label: " + label);
		if (id.equals(guid))
			throw new Exception("Cannot add peer to itself");
		if (peers.containsKey(id))
			throw new Exception("Node already has peer: " + id);
		peers.put(id, new Relationship(id, label));
	}

	public List<Relationship> getChildren() {
		return new ArrayList<Relationship>(children.values());
	}

	public List<Relationship> getParents() {
		return new ArrayList<Relationship>(parents.values());
	}

	public List<Relationship> getPeers() {
		return new ArrayList<Relationship>(peers.values());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guid == null) ? 0 : guid.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (guid == null) {
			if (other.guid != null)
				return false;
		} else if (!guid.equals(other.guid))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
