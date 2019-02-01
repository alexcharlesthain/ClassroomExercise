package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.ClassroomBookingService;

@Path("/Classroom")
public class ClassroomEndpoint {
	
	@Inject
	private ClassroomBookingService service;

	@Path("/getAllRooms")
	@GET
	@Produces({ "application/json" })
	public String getAllRooms() {
		return service.getAllRooms();
	}

	@Path("/createClassroomRequest")
	@POST
	@Produces({ "application/json" })
	public String createClassroomRequest(String classroom) {
		return service.createClassroomRequest(classroom);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Integer id, String classroom) {
		return service.updateClassroomRequest(id, classroom);
	}

	@Path("/deleteClassroomRequest/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteClassroomRequest(@PathParam("id") Integer id) {
		return service.deleteClassroomRequest(id);
	}

	public void setService(ClassroomBookingService service) {
		this.service = service;
	}

}
