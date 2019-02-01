package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

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

	public String createClassroomRequest(String classroomData) {
		Classroom newRoomRequest = util.getObjectForJSON(classroomData, Classroom.class);
		classroom.put(Long.parseLong(newRoomRequest.getClassroomNumber()), newRoomRequest);
		return "Created new classroom with the First Name: " + newRoomRequest.getFirstName() + ". Last Name: " + newRoomRequest.getSecondName()+ ". Classroom Number: " + newRoomRequest.getClassroomNumber();
	}

	public String deleteClassroomRequest(Long id) {
		classroom.remove(id);
		return "Removed classroom with the ID: "+id+".";
	}

	public String updateClassroomRequest(Long id, String classroomData) {
		Classroom updRequest = util.getObjectForJSON(classroomData, Classroom.class);
		classroom.replace(id, classroom.get(id), updRequest);
		return "Updated Classroom: " +id+ " with data: First Name: " + updRequest.getFirstName() + ". Last Name: " + updRequest.getSecondName()+ ". Classroom Number: " + updRequest.getClassroomNumber();
	}
	
	public String findClassroom(Long id) {
		return util.getJSONForObject(classroom.get(id));
	}	
	
	public int getClassroomByName(String name) {
		int count = 0;
		for(Classroom classroom: classroom.values()) {
			if(classroom.getFirstName().equals(name)) {
			count++;	
			}
		}			
		return count;
	}
}

