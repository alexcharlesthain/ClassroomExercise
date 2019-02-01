package com.qa.persistence.repository;

public interface ClassroomRepository {

	String getAllRooms();
	String createClassroomRequest(Long classroom);
	String deleteClassroomRequest(Long id);
	String updateClassroomRequest(Long id, String classroom);
	String findClassroom(Long id);
	String addClassroom(String classroom);

}
