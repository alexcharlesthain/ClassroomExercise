package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

public class ClassroomImp implements ClassroomService {

	@Inject
	private AccountRepository repo;
	
	@Inject
	private JSONUtil util;

	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String addClassroom(String account) {
		Classroom accountObject = util.getObjectForJSON(account, Classroom.class);
		if (accountObject.getClassroomNumber().equals("9")) {
			return "{\"message\": \"This classroom is blocked!\"}";
		}	
		return repo.createAccount(account);
	}

	@Override
	public String deleteClassroom(String classroomNumber) {
		return repo.deleteClassroom(classroomNumber);
	}
	
	@Override
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}
}
