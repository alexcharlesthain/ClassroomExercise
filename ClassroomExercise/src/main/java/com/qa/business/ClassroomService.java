package com.qa.business;

public interface ClassroomService {
	
	String getAllRooms();

	String addClassroom(String classroom);

	String deleteClassroom(Long id);
	
	String updateClassroom(Long id, String classroom);

}
