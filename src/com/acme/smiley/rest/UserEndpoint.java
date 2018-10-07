package com.acme.smiley.rest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public class UserEndpoint {

	private static final String USER = "user";

	@Inject
	private HttpServletRequest request;

	@GET
	public String read() {
		Object name = this.request.getSession().getAttribute(USER);
		return name instanceof String ? (String) name : null;
	}

	@POST
	public String connect(String name) {
		this.request.getSession().setAttribute(USER, name);
		return name;
	}

	@DELETE
	public void disconnect() {
		this.request.getSession().setAttribute(USER, null);
	}

}
