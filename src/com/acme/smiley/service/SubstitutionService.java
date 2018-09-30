package com.acme.smiley.service;

import com.acme.smiley.model.Smiley;
import com.acme.smiley.model.SmileyDao;

/**
 * Smiley substitution service. 
 */
public class SubstitutionService {
	
	private SmileyDao dao = SmileyDao.getInstance();

	/**
	 * Substitute all smiley combinations in a string with their corresponding UTF-8 characters.
	 * 
	 * @param message		the original message
	 * @return				same original message with smiley shorthands substituted
	 */
	public String substitute(String message) {
		for (Smiley smiley : dao.read()) {
			message = message.replace(smiley.getShortcut(), smiley.getFace());
		}
		return message;
	}

}
