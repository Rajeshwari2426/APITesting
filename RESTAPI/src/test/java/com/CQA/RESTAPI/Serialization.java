package com.CQA.RESTAPI;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;



public class Serialization {
	
	private static final ObjectMapper MAPPER=new ObjectMapper();
	@Test
	
	public  void  serialrize() throws JsonProcessingException {
		Blog_Posts blogposts=new Blog_Posts();
		blogposts.setId(5);
		blogposts.setTitle("maps");
		blogposts.setAuthor("Abc");
		 String url="http://localhost:3000/posts";
		 String json=MAPPER.writeValueAsString(blogposts);
		 Response response=RestAssured.given()
				              .contentType("application/json")
				              .log().all(true)
				              .body(json)
				              .post(url)
				              .andReturn();
		 response.prettyPrint();
		 int statusCode=response.statusCode();
			Assert.assertEquals(statusCode, 201);
	} 
	

}
