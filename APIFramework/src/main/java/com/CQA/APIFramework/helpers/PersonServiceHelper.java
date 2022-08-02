package com.CQA.APIFramework.helpers;


import java.util.List;

import com.CQA.APIFramework.constants.EndPoints;
import com.CQA.APIFramework.models.Person;
import com.CQA.APIFramework.utils.ConfigManager;

import io.qameta.allure.internal.shadowed.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;

public class PersonServiceHelper {// fetch the data from endpoints,we need to read config values,Rest Assured
									// about Url,port,
	// make get request on this url and send the data to test person

	public static final String BASE_URL = ConfigManager.getInstance().getString( k:"baseUrl");
	public static final String PORT = ConfigManager.getInstance().getString("port");
    public PersonServiceHelper()
    {
        RestAssured.baseUrl=BASE_URL;
        RestAssured.port=Integer.parseInt(PORT);
        RestAssured.useRelaxedHTTPSValidation;
    }
    public List<Person>getAllPerson()
    {
    	Response response =RestAssured.given()
    			              .contentType(ContentType.JSON)
    			              .get(EndPoints.GETAllPerson)
    			              .andreturn();
    	Type type=new TypeRefernce<List<Person>>() {}.getType();
    	List<Person>PersonList=response.as(Type);
    	return PersonList;
    }
}
