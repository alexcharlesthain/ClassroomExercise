package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	@SuppressWarnings("unchecked")
	public String getAllRooms() {
		Query query = em.createQuery("SELECT a FROM Classroom a");
		List<Classroom> classrooms = query.getResultList();
		return classrooms.toString();
	}
	
	@Override
	public String getAllAccounts() {
		Query query = em.createQuery("SELECT a FROM Classroom a");
		Collection<Classroom> allAccounts = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(allAccounts);
	}
	
//	@Override
//	public String findAccount(Long id) {
//		Query query = em.createQuery("Select a FROM Classroom a WHERE id = "+id+"");
//		Collection<Classroom> accounts = (Collection<Classroom>) query.getResultList();
//		return util.getJSONForObject(accounts);
//	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		String accountInDB = findAccount(id);
		if (accountInDB != null) {
			em.remove(accountInDB);
			Classroom anAccount = util.getObjectForJSON(account, Classroom.class);
			em.persist(anAccount);
			return "{\"message\": \"classroom sucessfully updated\"}";
		}
		return "{\"message\": \"classroom not found\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Classroom anAccount = util.getObjectForJSON(account, Classroom.class);
		em.persist(anAccount);
		return "{\"message\": \"classroom has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		String accountInDB = findAccount(id);
		if (accountInDB != null) {
			em.remove(accountInDB);
		}
		return "{\"message\": \"classroom sucessfully deleted\"}";
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	@Override
	public String findAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}



