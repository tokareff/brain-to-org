package com.translatable.thebrain;

public class Relationship {
	private String id = null;
	private String caption = null;
	
	public Relationship(String id, String caption) {
		this.id = id;
		this.caption = caption;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
}
