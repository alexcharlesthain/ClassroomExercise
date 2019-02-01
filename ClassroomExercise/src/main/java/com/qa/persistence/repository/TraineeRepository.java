package com.qa.persistence.repository;

public interface TraineeRepository {
	
	String deleteTrainee(Integer id);
	String createTrainee(String lastName);
	String getAllTrainees();
	String findTrainee(Integer id);
	String updateTrainee(Integer id, String classroom);

}
