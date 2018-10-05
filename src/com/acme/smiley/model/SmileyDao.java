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
		return delete(edited.getId()) ? add(edited) : null;
	}

	/**
	 * Add new smiley to the list, assigning it a new ID.
	 *
	 * @param smiley	the new smiley object to be added
	 * @return			the newly added smiley
	 */
	public Smiley create(Smiley smiley) {
		smiley.setId(nextId());
		return add(smiley);
	}

	/**
	 * Delete a smiley identified by its ID.
	 *
	 * @param id	the smiley identifier
	 * @return		true if smiley found and deleted, false otherwise
	 */
	public boolean delete(int id) {
		return objects.removeIf(x -> x.getId() == id);
	}

	private Smiley add(Smiley smiley) {
		objects.add(smiley);
		return smiley;
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
