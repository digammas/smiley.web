package com.acme.smiley.rest;

import com.acme.smiley.model.Smiley;
import com.acme.smiley.model.SmileyDao;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Path("smiley")
public class SmileyEndpoint {

	private SmileyDao dao = SmileyDao.getInstance(); 

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Smiley> read() {
		return dao.read()
				.stream()
				.sorted(Comparator.comparing(Smiley::getId))
				.collect(Collectors.toList());
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Smiley read(@PathParam("id") int id) {
		return dao.read(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Smiley create(Smiley smiley) {
		return dao.create(smiley);
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Smiley update(@PathParam("id") int id, Smiley smiley) {
		smiley.setId(id);
		return dao.update(smiley);
	}

	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") int id) {
		dao.delete(id);
	}
}
