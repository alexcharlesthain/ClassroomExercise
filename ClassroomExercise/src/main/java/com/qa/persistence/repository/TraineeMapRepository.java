package com.qa.persistence.repository;
	
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

	@Alternative
	public class TraineeMapRepository implements TraineeRepository{
		
		Map<Integer, Trainee> trainee = new HashMap<>();
		
		@Inject
		private JSONUtil util;
		
		public String getAllTrainees() {
			return util.getJSONForObject(trainee);
		}
		
		public int returnSize() {
			return trainee.size();
		}

		public String createTrainee(String traineeName) {
			Trainee newTrainee = util.getObjectForJSON(traineeName, Trainee.class);
			trainee.put(Integer.parseInt(newTrainee.traineeName()), newTrainee);
			return "Created new Trainee with the Name: " + newTrainee.traineeName() + ". ID Number: " + newTrainee.getTraineeId();
		}

		public String deleteTrainee(Integer id) {
			trainee.remove(id);
			return "Removed trainee with the ID: "+id+".";
		}

		public String updateTrainee(Integer id, String classroom) {
			Trainee updTrainee = util.getObjectForJSON(classroom, Trainee.class);
			trainee.replace(id, trainee.get(id), updTrainee);
			return "Updated Trainee: " +id+ " with Name: " + updTrainee.traineeName()+ ". ID Number: " + updTrainee.getTraineeId();
		}
		
		public String findTrainee(Integer id) {
			return util.getJSONForObject(trainee.get(id));
		}	
		
		public int getTraineeByName(String name) {
			int count = 0;
			for(Trainee trainee: trainee.values()) {
				if(trainee.traineeName().equals(name)) {
				count++;	
				}
			}			
			return count;
		}

}
