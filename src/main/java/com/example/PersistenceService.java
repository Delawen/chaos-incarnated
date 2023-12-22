package com.example;

import com.example.model.Cat;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/db")
public class PersistenceService {

	@Inject
	DatabaseResource databaseResource;

	@POST
	@Path("/cat/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	@Transactional
	public String addCat(@PathParam("name") String name) {
		databaseResource.addCat(name);
		return "Cat added with name " + name;
	}

	@GET
	@Path("/cats")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cat> getCats() {
		return databaseResource.getAllCats();
	}
}
