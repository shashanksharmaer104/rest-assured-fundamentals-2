package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.BeforeClass;

public class TestConfig {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://www.videogamedb.uk/";
        RestAssured.basePath = "/api/v2";
        RestAssured.port = 443; //optional if it's https

        //Inside setup() method
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType("application/xml")
                //.setAccept("application/json")
                .addHeader("Accept", "application/json") //use addHeader method to define explicitly
                .build();

        //Inside setup() method
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

}
