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

	/**
	 * Read a specific smiley defined by its ID.
	 *
	 * @param id	smiley's ID
	 * @return		the requested smiley object
	 */
	public Smiley read(int id) {
		return objects.stream().filter(x -> id == x.getId()).findAny().orElse(null);
	}
	
	/**
	 * Update an existing smiley identified by its ID.
	 *
	 * @param edited	the updating smiley, it has the same ID as the smiley to be updated
	 * @return			the newly updated smiley if a smiley with the same ID is found, null otherwise
	 */
	public Smiley update(Smiley edited) {
		if (!objects.removeIf(x -> x.getId() == edited.getId())) {
			return null;
		}
		objects.add(edited);
		return edited;
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
