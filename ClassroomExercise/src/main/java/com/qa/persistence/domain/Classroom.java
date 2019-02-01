package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Classroom {
	
	@Id
	private Long traineeId;
	private Long trainerId;
	private String firstName;
	private String lastName;
	private String classroomNumber;

	public Classroom() {

	}

	public Classroom(String firstName, String secondName, String classroomNumber, Long traineeId, Long trainerId) {
		this.firstName = firstName;
		this.lastName = secondName;
		this.classroomNumber = classroomNumber;
		this.traineeId = traineeId;
		this.trainerId = trainerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return lastName;
	}

	public void setSecondName(String secondName) {
		this.lastName = secondName;
	}

	public String getClassroomNumber() {
		return classroomNumber;
	}

	public void setAccountNumber(String classroomNumber) {
		this.classroomNumber = classroomNumber;
	}

	public Long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Long traineeId) {
		this.traineeId = traineeId;
	}
	
	public Long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Long trainerId) {
		this.trainerId = trainerId;
	}

}