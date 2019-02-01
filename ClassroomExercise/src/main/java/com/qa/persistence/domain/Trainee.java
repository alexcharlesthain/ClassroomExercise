package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
public class Trainee {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private Integer traineeId;

	public Trainee() {

	}

	public Trainee(String traineeName, Integer traineeId, Integer classroomId) {
		this.classroomId = classroomId;
		this.traineeName = traineeName;
		this.traineeId = traineeId;	
	}
	
	@NotNull
	private String traineeName;
	
	@NotNull
	private Integer classroomId;

	public Integer getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Integer id) {
		this.traineeId = traineeId;
	}

	public String traineeName() {
		return traineeName;
	}

	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}

	public Integer getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}
	
}