import config.VideoGameConfig;
import config.VideoGameEndpoints;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoGameTests extends VideoGameConfig {

    String requestGameJSONBody = "{\n" +
            "  \"category\": \"Platform\",\n" +
            "  \"name\": \"Transformers\",\n" +
            "  \"rating\": \"Mature 123\",\n" +
            "  \"releaseDate\": \"2012-05-04\",\n" +
            "  \"reviewScore\": 85\n" +
            "}";

    String requestGameXMLBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<VideoGameRequest>\n" +
            "\t<category>Platform</category>\n" +
            "\t<name>Tekken 8</name>\n" +
            "\t<rating>Mature</rating>\n" +
            "\t<releaseDate>2024-08-04</releaseDate>\n" +
            "\t<reviewScore>90</reviewScore>\n" +
            "</VideoGameRequest>";

    @Test
    public void getAllVideoGames() {
        given()
        .when()
                .get(VideoGameEndpoints.ALL_VIDEO_GAME)
        .then();
    }

    @Test
    public void createNewGameByJSON() {
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
                .contentType("application/xml") //to specify explicitly
                .accept("application/xml") //to specify explicitly
                .body(requestGameXMLBody)
        .when()
                .post(VideoGameEndpoints.ALL_VIDEO_GAME)
        .then();
    }

    @Test
    public void updateGameByJSON() {
        given()
                .body(requestGameJSONBody)
        .when()
                .put("/videogame/2")
        .then();
    }

    @Test
    public void updateGameByXML() {
        given()
                .contentType("application/xml") //to specify explicitly
                .accept("application/xml") //to specify explicitly
                .body(requestGameXMLBody)
        .when()
                .put("/videogame/6")
        .then();
    }

    @Test
    public void deleteGame() {
        given()
                .accept("text/plain")
        .when()
                .delete("/videogame/4")
        .then();
    }

}
