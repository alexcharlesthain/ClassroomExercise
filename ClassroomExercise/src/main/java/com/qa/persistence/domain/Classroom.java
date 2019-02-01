package com.qa.persistence.domain;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
public class Classroom {
	
	/*@OneToMany(mappedBy = "Classroom",
	        cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.EAGER)
	private Collection<Trainee> trainees = new LinkedHashSet<Trainee>();
	*/
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)	
	
	private Integer classroomId;
	private String trainerName;
	public Classroom() {

	}

	public Classroom(String trainerName, Integer classroomId) {
		super();
		this.trainerName = trainerName;
		this.classroomId = classroomId;
		
	}

	public String getTrainerName() {
		return trainerName;
	}
	
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	

	public void setClassroomId(Integer classroomId) {
		this.classroomId = classroomId;
	}
	
	public Integer getClassroomId() {
		return classroomId;
	}

}