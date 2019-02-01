package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.persistence.repository.TraineeDBRepository;

@Path("/trainee")
public class TraineeEndpoint {
	
	@Inject
	private TraineeDBRepository service;

	@Path("/getAllTrainees")
	@GET
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return service.getAllTrainees();
	}

	@Path("/createTrainee")
	@POST
	@Produces({ "application/json" })
	public String createTrainee(String name) {
		return service.createTrainee(name);
	}
	
	@Path("/findTraineeById/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateTrainee(@PathParam("id") Integer id, String traineeName) {
		return service.updateTrainee(id, traineeName);
	}

	@Path("/deleteTrainee/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteTrainee(@PathParam("id") Integer id) {
		return service.deleteTrainee(id);
	}
}