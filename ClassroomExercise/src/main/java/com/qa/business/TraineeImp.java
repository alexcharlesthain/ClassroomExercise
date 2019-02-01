package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.TraineeRepository;
import com.qa.util.JSONUtil;

public class TraineeImp implements TraineeService {

	@Inject
	private TraineeRepository repo;
	
	@Inject
	private JSONUtil util;

	public String getAllTrainees() {
		return repo.getAllTrainees();
	}

	public String createTrainee(String lastName) {
		Classroom traineeObject = util.getObjectForJSON(lastName, Classroom.class);
		if (traineeObject.getClassroomId().equals("2")) {
			return "{\"message\": \"This trainee is blocked!\"}";
		}	
		return repo.createTrainee(lastName);
	}

	@Override
	public String deleteTrainee(Integer id) {
		return repo.deleteTrainee(id);
	}
	
	@Override
	public String updateTrainee(Integer id, String trainee) {
		return repo.updateTrainee(id, trainee);
	}

	public void setRepo(TraineeRepository repo) {
		this.repo = repo;
	}

}