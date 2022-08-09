package com.CQA.APIFramework;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.CQA.APIFramework.helpers.PersonServiceHelper;

public class TestPATCHPerson {
private PersonServiceHelper personServiceHelper;
	
	@BeforeClass	
	public void init() {
		personServiceHelper = new PersonServiceHelper();
	}
	
	@Test	
	public void  testUpdatePerson() {		
			String id = personServiceHelper.updatePerson(4).jsonPath().getString("id");
			System.out.println(id);
			assertNotNull(id,"Updated");		
	}
	

}
