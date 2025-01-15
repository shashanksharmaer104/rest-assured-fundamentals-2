package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class FootballConfig {

    @BeforeClass
    public static void setup() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.football-data.org/")
                .setBasePath("/v4")
                .addHeader("X-Auth-Token", "")
                .addHeader("X-Response-Control", "minified")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        ResponseSpecification responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

}
