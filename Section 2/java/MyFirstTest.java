import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class MyFirstTest extends TestConfig {

    @Test
    public void myFirstTest() {
        given().
                log().
                ifValidationFails().
        when().get("videogames/3").
        then().
                log().
                all().
                statusCode(200);
    }

}
