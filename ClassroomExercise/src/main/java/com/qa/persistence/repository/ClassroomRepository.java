package com.qa.persistence.repository;

public interface ClassroomRepository {

	String getAllRooms();
	String createClassroomRequest(String classroom);
	String deleteClassroomRequest(Integer id);
	String findClassroom(Integer id);
	String updateClassroomRequest(Integer id, String classroom);

}
