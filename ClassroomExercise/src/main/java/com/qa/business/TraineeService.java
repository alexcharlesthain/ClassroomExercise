package com.qa.business;

public interface TraineeService {
		
		String getAllTrainees();
		String deleteTrainee(Integer id);	
		String createTrainee(String name);
		String updateTrainee(Integer id, String trainee);
}

