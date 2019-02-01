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
public class ClassroomDBRepository implements ClassroomRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	@SuppressWarnings("unchecked")
	public String getAllRooms() {
		Query query = em.createQuery("SELECT a FROM Classroom a");
		List<Classroom> classrooms = query.getResultList();
		return util.getJSONForObject(classrooms); 
	}
	
	@Override
	public String findClassroom(Integer classroomId) {
		Query query = em.createQuery("SELECT a FROM Classroom a WHERE id = "+classroomId+"");
		Collection<Classroom> classrooms = (Collection<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateClassroomRequest(Integer classroomId, String classroom) {
		String accountInDB = findClassroom(classroomId);
		if (accountInDB != null) {
			em.remove(accountInDB);
			Classroom anAccount = util.getObjectForJSON(classroom, Classroom.class);
			em.persist(anAccount);
			return "{\"message\": \"classroom request sucessfully updated\"}";
		}
		return "{\"message\": \"classroom request not found\"}";
	}
	

	@Override
	@Transactional(REQUIRED)
	public String createClassroomRequest(String account) {
		Classroom anAccount = util.getObjectForJSON(account, Classroom.class);
		em.persist(anAccount);
		return "{\"message\": \"classroom request has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteClassroomRequest(Integer classroomId) {
		String accountInDB = findClassroom(classroomId);
		if (accountInDB != null) {
			em.remove(accountInDB);
		}
		return "{\"message\": \"classroom request sucessfully deleted\"}";
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	
}



