import config.EndPoint;
import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class VideoGameDBTests extends TestConfig {

    @Test
    public void getAllGames() {

        given().
        when().get(EndPoint.VIDEOGAMES).
        then();

    }

    @Test
    public void createNewGameByJSON() {

        String gameBodyJSON = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"MyNameGame\",\n" +
                "  \"releaseDate\": \"2019-08-22T23:12:00.105Z\",\n" +
                "  \"reviewScore\": 50,\n" +
                "  \"category\": \"Driving\",\n" +
                "  \"rating\": \"Mature\"\n" +
                "}";

        given().
                body(gameBodyJSON).
        when().
                post(EndPoint.VIDEOGAMES).
        then();
    }

//    @Test
//    public void createNewGameByXML() {
//
//        String gameBodyXML = "<videoGame category=\"Sport\" rating=\"General\">\n" +
//                "    <id>12</id>\n" +
//                "    <name>AnotherGame</name>\n" +
//                "    <releaseDate>2019-08-22T00:00:00-04:00</releaseDate>\n" +
//                "    <reviewScore>60</reviewScore>\n" +
//                "  </videoGame>";
//
//        given().
//                body(gameBodyXML).
//                when().
//                post(EndPoint.VIDEOGAMES).
//                then();
//    }

    @Test
    public void updateExistingVideoGame() {

        String updateGameByJSON = "{\n" +
                "    \"id\": 12,\n" +
                "    \"name\": \"BetterGame\",\n" +
                "    \"releaseDate\": \"2019-08-22\",\n" +
                "    \"reviewScore\": 75,\n" +
                "    \"category\": \"Sport\",\n" +
                "    \"rating\": \"General\"\n" +
                "  }";

        given().
                body(updateGameByJSON).
        when().
                put(EndPoint.VIDEOGAMES + "/12").
        then();
    }

    @Test
    public void deleteVideoGame() {

        given().
        when().
                delete(EndPoint.VIDEOGAMES + "/12").
         then();
    }

    @Test
    public void getSingleGame() {

        given().
                pathParam("videoGameId", 11).
        when().
                get(EndPoint.SINGLE_VIDEOGAME).
        then();
    }
}
