package com.acme.smiley.service;

/**
 * Smiley substitution service. 
 */
public class SubstitutionService {
	
	/**
	 * Substitute all smiley combinations in a string with their corresponding UTF-8 characters.
	 * 
	 * @param message		the original message
	 * @return				same original message with smiley shorthands substituted
	 */
	public String substitute(String message) {
		return message.replace(":)", "☺");
	}

}
