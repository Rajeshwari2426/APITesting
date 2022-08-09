package com.CQA.APIFramework;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.CQA.APIFramework.helpers.PersonServiceHelper;

public class TestPOSTPerson {
	private PersonServiceHelper personServiceHelper;
	@BeforeClass
	public void init() {
		personServiceHelper = new PersonServiceHelper();
	}
	
	@Test
	public void testPOSTCreatePerson() {
		String id=personServiceHelper.createPerson().jsonPath().getString("id");
		System.out.println(id);
		assertNotNull(id,"person id not null");
		
	}

}
