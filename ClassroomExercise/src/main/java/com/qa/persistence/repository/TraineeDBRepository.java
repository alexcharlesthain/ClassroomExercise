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
import com.qa.persistence.domain.Trainee;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeDBRepository implements TraineeRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;

	@Inject
	private JSONUtil util;

	@Override
	@SuppressWarnings("unchecked")
	public String getAllTrainees() {
		Query query = em.createQuery("SELECT a FROM Trainee a");
		List<Trainee> trainees = query.getResultList();
		return trainees.toString();
	}
	
	@Override
	public String findTrainee(Integer id) {
		Query query = em.createQuery("Select a FROM Trainee a WHERE id = "+id+"");
		Collection<Trainee> trainees = (Collection<Trainee>) query.getResultList();
		return util.getJSONForObject(trainees);
	}
	
	@Override
	@Transactional(REQUIRED)
	public String updateTrainee(Integer id, String classroom) {
		String traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			em.remove(traineeInDB);
			Trainee anAccount = util.getObjectForJSON(updateTrainee(id, traineeInDB), Trainee.class);
			em.persist(anAccount);
			return "{\"message\": \"Trainee sucessfully updated\"}";
		}
		return "{\"message\": \"Trainee request not found\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String createTrainee(String trainee) {
		Trainee anAccount = util.getObjectForJSON(trainee, Trainee.class);
		em.persist(anAccount);
		return "{\"message\": \"Trainee has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteTrainee(Integer id) {
		String traineeInDB = findTrainee(id);
		if (traineeInDB != null) {
			em.remove(traineeInDB);
		}
		return "{\"message\": \"Trainee sucessfully deleted\"}";
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}
}