package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class TestConfig {

    public static RequestSpecification videoGameDB_RequestSpec;
    public static RequestSpecification footballAPI_RequestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setUp() {

        RestAssured.proxy("localhost", 8888);

        videoGameDB_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(8080).
                setBasePath("/app/").
                addHeader("Content-Type", "application/json").
                addHeader("Accept", "application/json").
                build();

        footballAPI_RequestSpec = new RequestSpecBuilder().
                setBaseUri("http://api.football-data.org").
                setBasePath("/v2/").
                addHeader("X-Auth-Token", "xxxx").
                addHeader("X-Response-Control", "minified").
                build();

        //RestAssured.requestSpecification = videoGameDB_RequestSpec;
        RestAssured.requestSpecification = footballAPI_RequestSpec;

        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                build();

        RestAssured.responseSpecification = responseSpec;

    }
}
