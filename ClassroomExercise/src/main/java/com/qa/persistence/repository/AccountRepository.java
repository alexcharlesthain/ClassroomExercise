package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllRooms();
	String createClassroom(String account);
	String deleteClassroom(Long id);
	String updateClassroom(Long id, String classroom);
	String findClassroom(Long id);

}
