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
	String token = "Bearer BQAyZXKSKUd19o_wNq1Dt7hiSVNffQkkVbUgELZUAyI3bXSqV4yf9dobpwr_aWKOmbup_YAYNeFeIJM9yMxXU4UhGtqzJsAdjRN8aGST8cjjJp7eOMDsBJ5TCa-pfu0Sz7nC6R7bwuOUpDRbpMzFXgdqEFrk3C42yH1Gf5K1ET9dt5FHsy97jdKuVr6jnd6RWPM_oiruJmbaws0q4GY3zw8iL1W9w37lu1fy5j-Ge1pestSgharz5ybAg69vh14s";

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

	@Test(priority = 2)

	public void GetUsersProfile() {
		RequestSpecification requestSpecification = RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization", token);

		Response response = requestSpecification.request(Method.GET,"https://api.spotify.com/v1/users/+userID");

		response.prettyPrint();
		int statusCode = response.statusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
