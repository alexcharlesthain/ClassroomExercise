package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;
import com.qa.persistence.repository.ClassroomRepository;

@Alternative
public class ClassroomMapRepository implements ClassroomRepository{
	
	Map<Long, Classroom> classroom = new HashMap<>();
	
	@Inject
	private JSONUtil util;
	
	public String getAllRooms() {
		return util.getJSONForObject(classroom);
	}
	
	public int returnSize() {
		return classroom.size();
	}

	/*public String createClassroomRequest(Integer classroomId, String classroom) {
		Classroom newRoomRequest = util.getObjectForJSON(classroom, Classroom.class);
		classroom.put(Integer.parseInt(newRoomRequest.getClassroomId()), newRoomRequest);
		return "Created new classroom request with trainer: " + newRoomRequest.getTrainerName()+ ". Classroom Number: " + newRoomRequest.getClassroomId();
	}*/

	public String deleteClassroomRequest(Integer classroomId) {
		classroom.remove(classroomId);
		return "Removed classroom with the ID: "+classroomId+".";
	}

	/*public String updateClassroomRequest(Integer classroomId, String classroom) {
		Classroom updRequest = util.getObjectForJSON(classroom, Classroom.class);
		classroom.replace(classroomId, classroom.get(classroomId), updRequest);
		return "Updated Classroom: " +classroomId+ " with Trainer Name: " + updRequest.getTrainerName()+ ". Classroom Number: " + updRequest.getClassroomId();
	}*/
	
	public String findClassroom(Integer id) {
		return util.getJSONForObject(classroom.get(id));
	}	
	
	public int getClassroomByName(String name) {
		int count = 0;
		for(Classroom classroom: classroom.values()) {
			if(classroom.getTrainerName().equals(name)) {
			count++;	
			}
		}			
		return count;
	}

	@Override
	public String createClassroomRequest(String classroom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateClassroomRequest(Integer id, String classroom) {
		// TODO Auto-generated method stub
		return null;
	}
}

