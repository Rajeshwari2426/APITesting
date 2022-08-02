package com.CQA.RESTAPI;

import java.lang.reflect.Type;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;


import io.restassured.RestAssured;

public class Deserialization {

	@Test
	public void deserialze() {

		String url = "http://localhost:3000/posts/5";
		Blog_Posts blogposts = RestAssured.given().get(url).as(Blog_Posts.class);
		System.out.println("json object:" + blogposts.toString());

		String urlstring = "http://localhost:3000/posts";
		Type type = new TypeReference<List<Blog_Posts>>() {}.getType();

		List<Blog_Posts> blogpostsList = RestAssured.get(urlstring).as(type);

		System.out.println("java object1:" + blogpostsList);
	}

}
