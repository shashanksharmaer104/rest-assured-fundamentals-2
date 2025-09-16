package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.junit.BeforeClass;

public class VideoGameConfig {

    @BeforeClass
    public static void setup() {
        //RestAssured.port = 443; //optional

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://videogamedb.uk/")
                .setBasePath("/api/v2/")
                .setPort(443) //optional
                .setContentType("application/json")
                .addHeader("Accept", "application/json") //either will work
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .build();
    }

}
