package com.CQA.RESTAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SpotifyPlaylistsApi {
	String playlistId;
	String token="Bearer BQBkKijArU_f1m-lWdy3y-Mz2OEE8gDPGCesIdjq-VOIo9f_-Me1hZmnmfxI6hpIL6B9cMDIK3BGJwUrNDNel3rECMbsejC5-DoGnHMmzVioFwmv0LUc33TVZj-PN_SFiqbQiwhkJJcJwFl53Qj9V57hGpk4aECD6PHlNhVfWX-CZK_SqyKXql4KMhUje5CupVB6wtHiJqyFmGdT";
	@Test

	public void GetCurrentUserPlaylists()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization" ,token);		
		Response response =requestSpecification.request(Method.GET,"https://api.spotify.com/v1/me/playlists");
		playlistId=response.path("[items].id");
		System.out.println("playlistId:"+playlistId);
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);

}
	@Test

	public void GetPlaylistCoverImage()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization" ,token);		
		Response response =requestSpecification.request(Method.GET,"https://api.spotify.com/v1/playlists/5pt3Az7OOLvxa5A6PHxaSY/images");		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);

	}
	@Test

	public void GetPlaylistItems()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization" ,token);
		
		Response response =requestSpecification.request(Method.GET,"https://api.spotify.com/v1/playlists/5pt3Az7OOLvxa5A6PHxaSY/tracks");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);

}
	@Test

	public void GetPlaylist()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization" ,token);
		
		Response response =requestSpecification.request(Method.GET,"	https://api.spotify.com/v1/playlists/5pt3Az7OOLvxa5A6PHxaSY");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);

}
	@Test

	public void 	GetUserPlaylists()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization" ,token);
		
		Response response =requestSpecification.request(Method.GET,"	https://api.spotify.com/v1/users/31nch6l64pqubxwdsfdlcoll7gq4/playlists");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);

}
	@Test

	public void AddItemstoPlaylist()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization" ,token);
		requestSpecification.queryParam("uris","spotify:track:5QDLhrAOJJdNAmCTJ8xMyW");
		
		Response response =requestSpecification.request(Method.POST,"https://api.spotify.com/v1/playlists/5pt3Az7OOLvxa5A6PHxaSY/tracks");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 201);

}
	@Test

	public void CreatePlaylist()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization" ,token);
		requestSpecification.body("{\"name\":\"New Playlist\", \"description\": \"New playlist description\", \"public\": false}");
		
		Response response =requestSpecification.request(Method.POST,"	https://api.spotify.com/v1/users/31nch6l64pqubxwdsfdlcoll7gq4/playlists");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 201);

}
//	@Test
//
//	public void AddCustomPlaylistCoverImage()
//	{
//		RequestSpecification requestSpecification=RestAssured.given();
//		requestSpecification.accept(ContentType.JSON);
//		requestSpecification.contentType("application/json");
//		requestSpecification.header("Authorization" ,token);
//		requestSpecification.body("{\"name\":\"New Playlist\", \"description\": \"New playlist description\", \"public\": false}");
//		
//		Response response =requestSpecification.request(Method.PUT,"	https://api.spotify.com/v1/playlists/6kUxUeNI17ZFUWX1juHHpz/images");
//		
//		response.prettyPrint();
//		int statusCode=response.statusCode();
//		Assert.assertEquals(statusCode, 200);
//
//}
	@Test

	public void UpdatePlaylistItems()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization" ,token);
		requestSpecification.queryParam("uris","spotify:track:5QDLhrAOJJdNAmCTJ8xMyW");
		requestSpecification.body("{\r\n"
				+ "  \"range_start\": 1,\r\n"
				+ "  \"insert_before\": 3,\r\n"
				+ "  \"range_length\": 2\r\n"
				+ "}");
		
		Response response =requestSpecification.request(Method.PUT,"https://api.spotify.com/v1/playlists/1mTLVGPhmjz5Dscz0LGN5k/tracks");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 201);
		}
	@Test
	public void ChangePlaylistDetails()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization" ,token);
		requestSpecification.body("{\r\n"
				+ "  \"name\": \"Updated Playlist Name\",\r\n"
				+ "  \"description\": \"Updated playlist description\",\r\n"
				+ "  \"public\": false\r\n"
				+ "}");
		
		Response response =requestSpecification.request(Method.PUT,"https://api.spotify.com/v1/playlists/1mTLVGPhmjz5Dscz0LGN5k");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
		}
	@Test
	public void RemovePlaylistItems()
	{
		RequestSpecification requestSpecification=RestAssured.given();
		requestSpecification.accept(ContentType.JSON);
		requestSpecification.contentType("application/json");
		requestSpecification.header("Authorization" ,"Bearer BQCJ2m70x4Zmi-g6ud7J72-7x2utb6vVxjroKLm5lXGY_kNhy_EfvKN5hEDzS5rMDvn8t2gFmivSWMhJg0SW1NrA2zrZ265AQGLbYc5AlFrKHqpMC_86IZhg7YteqTKlnDbnPEdC2Hti0WUuKvGFgxF6wQCPwQ12rc8mLlxQTkSF8PrRCfu9A3BclrvST_JFSrn5CmRr6raxccv9EvnvSLX1-q7B3izz_mXFK8-kFOaGcWM1ivX3htz-Gjlo9-dy");
		requestSpecification.body("{ \"tracks\": [{ \"uri\": \"spotify:track:5QDLhrAOJJdNAmCTJ8xMyW\" }]}");
		
		Response response =requestSpecification.request(Method.DELETE,"	https://api.spotify.com/v1/playlists/1mTLVGPhmjz5Dscz0LGN5k/tracks");
		
		response.prettyPrint();
		int statusCode=response.statusCode();
		Assert.assertEquals(statusCode, 200);
		}
}
