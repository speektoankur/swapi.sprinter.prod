package com.swapi.prod.swapi.sprinter.prod;

import com.swapi.prod.swapi.sprinter.prod.CustomAssertions.InformationServiceAssertions;
import com.swapi.prod.swapi.sprinter.prod.DataModels.ErrorResponse;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@SpringBootTest
class ApplicationTests extends InformationServiceAssertions {

	@BeforeTest
	public void setUp(){
		SpringApplication.run(Application.class);
	}
	@Test(enabled = false)
	void verifySuccessRequestWithValidTestData() {
		Response response =
				given()
						.baseUri("http://localhost:8080/information")
						.and()
						.queryParam("attackingPersonName","Darth Vader")
						.queryParam("planetName","Alderaan")
						.and()
						.get()
						.then().extract().response();
		response.prettyPrint();

	}

	@Test
	void verifySuccessRequestWithInvalidQueryParams() {
		Response response =
				given()
						.baseUri("http://localhost:8080/information")
						.and()
						.queryParam("attackingPersonName",10)
						.queryParam("planetName",9333)
						.and()
						.get()
						.then().extract().response();
		response.prettyPrint();
		ErrorResponse errorResponse = response.as(ErrorResponse.class);
		super.AssertInvalidQueryParamResponse(errorResponse);
	}

	@Test(enabled = false)
	void verifySuccessRequestWithInValidCall() {
		Response response =
				given()
						.baseUri("http://localhost:8080/information")
						.and()
						.queryParam("attackingPersonName","Darth Vader")
						.queryParam("planetName","Alderaan")
						.and()
						.get()
						.then().extract().response();
		response.prettyPrint();
		ErrorResponse errorResponse = response.as(ErrorResponse.class);
		super.AssertBadRequestResponse(errorResponse);
	}

}
