package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomRepository;
import com.qa.util.JSONUtil;

public class ClassroomImp implements ClassroomBookingService {

	@Inject
	private ClassroomRepository repo;
	
	@Inject
	private JSONUtil util;

	public String getAllRooms() {
		return repo.getAllRooms();
	}

	public String addClassroom(String classroom) {
		Classroom accountObject = util.getObjectForJSON(classroom, Classroom.class);
		if (accountObject.getClassroomNumber().equals("9")) {
			return "{\"message\": \"This classroom is blocked!\"}";
		}	
		return repo.addClassroom(classroom);
	}

	@Override
	public String deleteClassroomRequest(Long id, String classroom) {
		return repo.deleteClassroomRequest(id);
	}
	
	@Override
	public String updateClassroomRequest(Long id, String classroom) {
		return repo.updateClassroomRequest(id, classroom);
	}

	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}

}
