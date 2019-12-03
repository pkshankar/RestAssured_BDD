package com.qa.test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetRestAssuredBDD {

	@Test(enabled=false)
	public void getCityInfoTest() {

		given().
			pathParam("CITY_NAME", "DELHI").
		when().
			get("http://restapi.demoqa.com/utilities/weather/city/{CITY_NAME}").
		then().
			assertThat().
			body("City", equalTo("Delhi")).
			and().
			body("WeatherDescription", equalTo("haze"));

	}
	
	@Test
	public void getCirucitInfo2015Test() {
		
		RestAssured.baseURI="http://ergast.com";
		given().
			pathParam("RACE_YEAR", 2015).
		when().
			get("api/f1/{RACE_YEAR}/circuits.json").
		then().
			assertThat().
			body("MRData.total", equalTo("19")).
			and().
			body(("MRData.CircuitTable.season"),equalTo("2015")).
			and().
			body(("MRData.CircuitTable.Circuits.circuitId[0]"),equalTo("albert_park"));
	}

}
