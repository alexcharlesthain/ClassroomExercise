package com.qa.business;

public interface ClassroomBookingService {
	
	String getAllRooms();

	String createClassroomRequest(String classroom);

	String deleteClassroomRequest(Long id, String classroom);
	
	String updateClassroomRequest(Long id, String classroom);

}
