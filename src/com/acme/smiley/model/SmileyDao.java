package com.acme.smiley.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Smileys data access object.
 */
public class SmileyDao {

	private List<Smiley> objects = new ArrayList<>();
	private int lastId = 0;
	
	private static SmileyDao instance = new SmileyDao();

	/**
	 * Private constructor. To acquire an instance of this class, use <code>getInstance()</code> method.
	 */
	private SmileyDao() {
		this.objects.add(new Smiley(nextId(), "☺", ":)", "Smiling face"));
		this.objects.add(new Smiley(nextId(), "☹", ":(", "Sad face"));
	}
	
	/**
	 * List all smileys.
	 *
	 * @return	a list of all smileys
	 */
	public List<Smiley> read() {
		return objects;
	}
	
	private int nextId() {
		return this.lastId++;
	}
	
	/**
	 * Return the smiley access object singleton.
	 * 
	 * @return	a smiley access object instance
	 */
	public static SmileyDao getInstance() {
		return instance;
	}

}
