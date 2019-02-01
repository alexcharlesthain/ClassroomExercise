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

	public String createClassroomRequest(String classroom) {
		return repo.createClassroomRequest(classroom);
	}

	@Override
	public String deleteClassroomRequest(Integer id) {
		return repo.deleteClassroomRequest(id);
	}
	
	@Override
	public String updateClassroomRequest(Integer id, String classroom) {
		return repo.updateClassroomRequest(id, classroom);
	}

	public void setRepo(ClassroomRepository repo) {
		this.repo = repo;
	}

}
