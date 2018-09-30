package com.acme.smiley.model;

/**
 * Smiley icon that has a corresponding UTF-8 code.
 */
public class Smiley {

	private int id;
	private String face;
	private String shortcut;
	private String description;

	public Smiley() {
	}

	public Smiley(int id, String face, String shortcut, String description) {
		this.id = id;
		this.face = face;
		this.shortcut = shortcut;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
