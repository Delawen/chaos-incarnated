package com.example;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("/hello")
public class HelloService {

	//@ConfigProperty(name = "who.am.i")
	String whoAmI;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello from MicroProfile!";
	}

//	@GET
//	@Path("/whoami")
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getWhoAmI() {
//		return "I am " + whoAmI;
//	}

}
