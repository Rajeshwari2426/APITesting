package com.CQA.APIFramework;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.CQA.APIFramework.helpers.PersonServiceHelper;
import com.CQA.APIFramework.models.Person;

public class TestGETPerson {
	private PersonServiceHelper personServiceHelper;
	
	@BeforeClass
	
	public void init() {
		personServiceHelper = new PersonServiceHelper();
	}
	
	@Test
	
	public void  testGetAllPerson() {
		List<Person>personList=personServiceHelper.getAllPerson();
		assertNotNull(personList,"PersonList not empty");
		assertFalse(personList.isEmpty(),"personList is not true");
		
	}
	

}
