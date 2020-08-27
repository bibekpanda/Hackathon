package com.honeywell.test.Hackathon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@SpringBootTest
class RestTest {
	
	@BeforeAll
	public void setup() {
		RestAssured.baseURI = "http://localhost:8080";
	}


	@Test
	void test() {
		
		Response res = RestAssured.given().pathParam("id", "2").when().get("/student");
		System.out.println(res.getBody().asString());
		 assertEquals(200, res.getStatusCode());
		
				
	}
	

}
