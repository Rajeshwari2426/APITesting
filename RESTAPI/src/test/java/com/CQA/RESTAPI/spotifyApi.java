package com.CQA.RESTAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class spotifyApi {
	public String userID;
	String token = "Bearer BQDnroteGnwEZ3v9Wv3ufwLG2SeXQ6cDR9Bd8v3nbGsiyPikwm6t5y4DejigQ4NJ3a_HRGR_4qxILT4YPmgymktE41nlFnhN3GcYE-vanCiT0lUQhpxDVxl_12Fn5p_0eKC8flp7DB6R-kqXqAxGi5JAPNzTyo8upRLvTQBuvDvo1J8QNyz9tIKeYzOgr7meU6I";

	@Test(priority = 1)
	public void GetCurrentUsersProfile() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET, "https://api.spotify.com/v1/me");
		userID = response.path("id");
		System.out.println("user id:" + userID);
		response.prettyPrint();
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}

	@Test

	public void GetUsersProfile() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET, "https://api.spotify.com/v1/users/"+ userID +"");

		response.prettyPrint();
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
