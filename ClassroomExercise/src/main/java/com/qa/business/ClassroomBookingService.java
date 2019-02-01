package com.qa.business;

public interface ClassroomBookingService {
	
	String getAllRooms();

	String createClassroomRequest(String classroom);

	String deleteClassroomRequest(Integer id);

	String updateClassroomRequest(Integer id, String classroom);

}
