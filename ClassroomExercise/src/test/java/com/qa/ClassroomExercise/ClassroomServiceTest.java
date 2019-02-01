 package com.qa.ClassroomExercise;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Classroom;
import com.qa.persistence.repository.ClassroomMapRepository;

public class ClassroomServiceTest {

	private ClassroomMapRepository repo;
	
	private static final String MOCK_DATA_ARRAY_ONE = "{\"TrainerFirstName\":\"Matt\",\"TrainerLastName\":\"Hunt\",\"classroomNumber\":\"1234\"}";	
	private static final String MOCK_DATA_ARRAY_TWO = "{\"TrainerFirstName\":\"John\",\"TrainerLastName\":\"Gordon\",\"TraineeFirstName\":\"Mark\",\"TraineeLastName\":\"Smith\",\"classroomNumber\":\"1345\"}";
	private static final String MOCK_DATA_ARRAY_THREE = "{\"TrainerFirstName\":\"Gareth\",\"TrainerLastName\":\"Davies\",\"TraineeFirstName\":\"Alex\",\"TraineeLastName\":\"Thain\",\"classroomNumber\":\"1457\"}";
	private static final String MOCK_DATA_ARRAY_FOUR = "{\"TrainerFirstName\":\"Dale\",\"TrainerLastName\":\"Carr\",\"classroomNumber\":\"1395\"}";
	private static final String MOCK_DATA_ARRAY_FIVE = "{\"TrainerFirstName\":\"Jim\",\"TrainerLastName\":\"Bob\",\"classroomNumber\":\"1245\"}";
	
	/*@Before
	public void setup() {
		repo = new ClassroomMapRepository();
	}
	
	@Test
	public void addClassroomTest() {
		String reply = repo.createClassroomRequest(MOCK_DATA_ARRAY_THREE);
		Assert.assertEquals(1, repo.returnSize());
		
	}
	
	@Test
	public void add2ClassroomTest() {
		String reply = repo.createClassroomRequest(MOCK_DATA_ARRAY_TWO);
		Assert.assertEquals("Created new request with the First Name: John. Last Name: Gordon. Teaching Trainee with the First Name: Mark. Last Name: Smith. Classroom Number: 1345", reply);
	}

	@Test
	public void removeClassroomTest() {
		repo.createClassroomRequest(MOCK_DATA_ARRAY_TWO);
		repo.deleteClassroomRequest(1345L);
		Assert.assertEquals(0 ,repo.returnSize());
		
	}
	
//	@Test
//	public void remove2AccountTest() {
//		String reply = repo.deleteAccount(4321L);
//		Assert.assertEquals("Removed account with the ID: 4321.", reply);
//		
//	}
//	
//	/*@Test
//	public void updateAccount1to2() {
//		repo.createAccount(MOCK_DATA_ARRAY_ONE);
//		repo.updateAccount(1234L, MOCK_DATA_ARRAY_THREE);
//		Assert.assertEquals(MOCK_DATA_ARRAY_THREE, repo.findAccount(1234L));
//	}*/
//	
//	@Test
//	public void remove2AccountTestAnd1ThatDoesntExist() {
//		repo.createAccount(MOCK_DATA_ARRAY_ONE);
//		repo.createAccount(MOCK_DATA_ARRAY_FOUR);
//		repo.deleteAccount(1234L);
//		repo.deleteAccount(4323L);
//		repo.deleteAccount(4666L);
//		Assert.assertEquals(0, repo.returnSize());
//	}
//	
//	@Test
//	public void accountConversionToJSONTestWithEmptyMap() {
//	
//	}
//	
//	@Test
//	public void accountConversionToJSONTestEmptyMapWithConversion() {
//	
//	}
//
//	@Test
//	public void accountConversionToJSONTest() {
//		
//		
//	}
//
//	@Test
//	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
//		repo.createAccount(MOCK_DATA_ARRAY_ONE);
//		Assert.assertEquals(0, repo.getAccountByName("jim"));
//	}
//	
//	@Test
//	public void getCountForFirstNamesInAccountWhenOne() {
//		repo.createAccount(MOCK_DATA_ARRAY_FOUR);
//		Assert.assertEquals(0, repo.getAccountByName("jim"));
//	}
//
//	@Test
//	public void getCountForFirstNamesInAccountWhenMult() {
//		repo.createAccount(MOCK_DATA_ARRAY_FOUR);
//		repo.createAccount(MOCK_DATA_ARRAY_FIVE);
//		Assert.assertEquals(0, repo.getAccountByName("jim"));
//	}

}
