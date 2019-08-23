import config.EndPoint;
import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class FootballApiTests extends TestConfig {

    @Test
    public void getAllTeamsForOneSeason() {

        given().
                spec(footballAPI_RequestSpec).
                queryParam("season", 2018).
        when().
                get(EndPoint.GET_PREMIER_LEAGUE_TEAMS).
        then();

    }
}
