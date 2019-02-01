package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository{
	
	Map<Long, Classroom> classroom = new HashMap<>();
	
	@Inject
	private JSONUtil util;
	
	public String getAllAccounts() {
		return util.getJSONForObject(classroom);
	}
	
	public int returnSize() {
		return classroom.size();
	}

	public String createAccount(String accountData) {
		Classroom newAccount = util.getObjectForJSON(accountData, Classroom.class);
		classroom.put(Long.parseLong(newAccount.getAccountNumber()), newAccount);
		return "Created new classroom with the First Name: " + newAccount.getFirstName() + ". Last Name: " + newAccount.getSecondName()+ ". Classroom Number: " + newAccount.getAccountNumber();
	}

	public String deleteAccount(Long id) {
		classroom.remove(id);
		return "Removed classroom with the ID: "+id+".";
	}

	public String updateAccount(Long id, String accountData) {
		Classroom updAccount = util.getObjectForJSON(accountData, Classroom.class);
		classroom.replace(id, classroom.get(id), updAccount);
		return "Updated Classroom: " +id+ " with data: First Name: " + updAccount.getFirstName() + ". Last Name: " + updAccount.getSecondName()+ ". Classroom Number: " + updAccount.getAccountNumber();
	}
	
	public String findAccount(Long id) {
		return util.getJSONForObject(classroom.get(id));
	}	
	
	public int getAccountByName(String name) {
		int count = 0;
		for(Classroom classroom: classroom.values()) {
			if(classroom.getFirstName().equals(name)) {
			count++;	
			}
		}			
		return count;
	}
}

