import config.VideoGameConfig;
import config.VideoGameEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class MyFirstVideoGame extends VideoGameConfig {

    @Test
    public void myFirstTest() {
        given()
                .log().all()
        .when()
                .get("/videogame")
        .then()
                .log().all();
    }

    @Test
    public void myFirstTestWithEndpoint() {
        get(VideoGameEndpoints.ALL_VIDEO_GAME)
                .then().log().all();
    }
}
