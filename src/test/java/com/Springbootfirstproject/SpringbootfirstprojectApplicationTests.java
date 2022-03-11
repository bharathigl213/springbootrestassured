package com.Springbootfirstproject;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SpringBootTest
class SpringbootfirstprojectApplicationTests {
	String name = "bharathi";
    String city = "Hyderabad";
    
	@Test
    public void User() {
	 RestAssured.baseURI ="http://localhost:8080"; 
	    RequestSpecification request = RestAssured.given(); 
        request.header("Content-Type", "application/json");
        Response response = request.body("{ \"name\":\"" + name + "\", \"city\":\"" + city + "\" }")
                .post("/addUser");
        System.out.println("Response is - "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
	@Test
	  public void getaddUserById() {
		 RestAssured.baseURI ="http://localhost:8080"; 
		    RequestSpecification request = RestAssured.given().pathParam("id", "1");
	        request.header("Content-Type", "application/json");
	        Response response = request.get("/user/{id}");
	        System.out.println("Response is - "+response.getStatusCode());
	        Assert.assertEquals(response.getStatusCode(), 200);
	    }
	
	 @Test
public void updateUsers() {
	 String name = "bharathi";
	      String city = "Hyderabad";
	      RestAssured.baseURI ="http://localhost:8080"; 
		 RequestSpecification request = RestAssured.given();      
	     request.header("Content-Type", "application/json");	        
		 Response response = request.body("{ \"name\":\"" + name + "\", \"city\":\"" + city + "\" }")
	               .put("/updateUser");
	        System.out.println("Response is - "+response.getStatusCode());
	        Assert.assertEquals(response.getStatusCode(), 200);
  }
}


