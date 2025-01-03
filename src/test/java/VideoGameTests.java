import config.VideoGameConfig;
import config.VideoGameEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoGameTests extends VideoGameConfig {

    @Test
    public void getAllVideoGames() {
        given()
        .when()
                .get(VideoGameEndpoints.ALL_VIDEO_GAME)
        .then();
    }

    @Test
    public void createNewGameByJSON() {

        String requestGameJSONBody = "{\n" +
                "  \"category\": \"Platform\",\n" +
                "  \"name\": \"Transformers\",\n" +
                "  \"rating\": \"Mature 123\",\n" +
                "  \"releaseDate\": \"2012-05-04\",\n" +
                "  \"reviewScore\": 85\n" +
                "}";

        given()
                .body(requestGameJSONBody)
        .when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAME)
        .then();
    }

    @Test
    public void createGameByXML() {

        String requestGameXMLBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<VideoGameRequest>\n" +
                "\t<category>Platform</category>\n" +
                "\t<name>Mario</name>\n" +
                "\t<rating>Mature</rating>\n" +
                "\t<releaseDate>2012-05-04</releaseDate>\n" +
                "\t<reviewScore>85</reviewScore>\n" +
                "</VideoGameRequest>";

        given()
                .contentType("application/xml")
                .accept("application/xml")
                .body(requestGameXMLBody)
        .when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAME)
        .then();
    }

}
