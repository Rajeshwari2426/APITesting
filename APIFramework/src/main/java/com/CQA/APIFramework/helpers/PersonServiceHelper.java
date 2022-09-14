package com.CQA.APIFramework.helpers;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.http.HttpStatus;

import com.CQA.APIFramework.constants.EndPoints;
import com.CQA.APIFramework.models.Person;
import com.CQA.APIFramework.utils.ConfigManager;
import com.fasterxml.jackson.core.type.TypeReference;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PersonServiceHelper {

	public static final String BASE_URL = ConfigManager.getInstance().getString("baseUrl");
	public static final String PORT = ConfigManager.getInstance().getString("port");

	public PersonServiceHelper() {
		RestAssured.baseURI = BASE_URL;
		RestAssured.port = Integer.parseInt(PORT);
		RestAssured.useRelaxedHTTPSValidation();
	}

	public List<Person> getAllPerson() {
		Response response = RestAssured.given().contentType(ContentType.JSON).get(EndPoints.GET_All_Person).andReturn();
		response.prettyPrint();

		Type type = new TypeReference<List<Person>>() {
		}.getType();
		List<Person> personList = response.as(type);
		return personList;
	}

	public Response createPerson() {
		Person person = new Person();

		person.setId(7);
		person.setTitle("xyz");
		person.setAuthor("mera");
		Response response = RestAssured.given().contentType(ContentType.JSON).body(person).post(EndPoints.CREATE_PERSON)
				.andReturn();
		response.prettyPrint();

		assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "created");
		return response;
	}

	public Response updatePerson(Integer id) {
		Person person = new Person();
		person.setId(4);
		person.setTitle("Sanju");
		person.setAuthor("Deeraj");
		Response response = RestAssured.given().contentType(ContentType.JSON).when().pathParam("id",id).body(person)
				.patch(EndPoints.UPDATE_PERSON).andReturn();
		response.prettyPrint();
		assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");
		
		return response;
	}

	public Response deletePerson(Integer id) {

		Response response = RestAssured.given().contentType(ContentType.JSON).pathParam("id",id).when()
				.delete(EndPoints.DELETE_PERSON).andReturn();
		response.prettyPrint();
		//assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "OK");
		return response;
	}

}
