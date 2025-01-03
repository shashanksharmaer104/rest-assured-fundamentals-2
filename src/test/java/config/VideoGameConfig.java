package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.BeforeClass;

public class VideoGameConfig {

    @BeforeClass
    public static void setup() {

        //Inside setup() method
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://www.videogamedb.uk/")
                .setBasePath("/api/v2")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setContentType("application/json")
                //.setAccept("application/json")
                .addHeader("Accept", "application/json") //use addHeader method to define explicitly
                .build();

        //Inside setup() method
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

}
