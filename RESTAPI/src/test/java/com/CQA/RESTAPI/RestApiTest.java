package com.CQA.RESTAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiTest
{
	@Test(priority=0)
	public void getPosts()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		
		Response response =requestSpecification.request(Method.GET," http://localhost:3000/posts");
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	@Test(priority=1)
	public void createPost()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body("{\r\n"
				+ "        \"id\": 5,\r\n"
				+ "        \"title\": \"stories\",\r\n"
				+ "        \"author\": \"raji\"\r\n"
				+ "    }");
		
		Response response =requestSpecification.request(Method.POST," http://localhost:3000/posts");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 201);
	}
	@Test(priority=2)
	public void updatePost()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body("{\r\n"
				+ "        \"id\": 5,\r\n"
				+ "        \"title\": \"stories\",\r\n"
				+ "        \"author\": \" deeraji\"\r\n"
				+ "    }");
		
		Response response =requestSpecification.request(Method.PUT," http://localhost:3000/posts/5");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	@Test(priority=3)
	public void deletePost()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
				
		Response response =requestSpecification.request(Method.DELETE," http://localhost:3000/posts/5");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	@Test(priority=4)
	public void getAllComents()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
				
		Response response =requestSpecification.request(Method.GET,"  http://localhost:3000/comments");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	@Test(priority=5)
	public void addComment()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body(" {\r\n"
				+ "        \"id\": 3,\r\n"
				+ "        \"body\": \"good to see\",\r\n"
				+ "        \"postId\": 3\r\n"
				+ "    }");
				
		Response response =requestSpecification.request(Method.POST,"  http://localhost:3000/comments");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 201);
	}
	@Test(priority=6)
	public void updateComment()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body(" {\r\n"
				+ "        \"id\": 3,\r\n"
				+ "        \"body\": \"happy to see\",\r\n"
				+ "        \"postId\": 3\r\n"
				+ "    }");
				
		Response response =requestSpecification.request(Method.PUT,"  http://localhost:3000/comments/3");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	@Test(priority=7)
	public void updatewithpatchComment()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.body(" {\"body\": \"evergreen\"}");
				
		Response response =requestSpecification.request(Method.PATCH,"  http://localhost:3000/comments/3");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	@Test(priority=8)
	public void deleteComment()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		
		Response response =requestSpecification.request(Method.DELETE,"  http://localhost:3000/comments/3");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	@Test(priority=9)
	public void getCommentforPostId1()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.queryParam("PostId", 1);
				
		Response response =requestSpecification.request(Method.GET,"  http://localhost:3000/comments");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	

}
