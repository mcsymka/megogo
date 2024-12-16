package services;

import io.restassured.response.ExtractableResponse;
import io.restassured.specification.RequestSpecification;
import org.springframework.web.util.UriComponents;

import java.net.URI;
import java.net.URL;
import java.util.LinkedHashMap;

import static io.restassured.RestAssured.given;

public class RestAssuredRequests {

    protected String executeGet( RequestSpecification spec, URI uri ) {
        return given()
                .spec( spec )
                .when()
                .get( uri )
                .then()
                .assertThat()
                .statusCode( 200 )
                .and()
                .extract()
                .asString();
    }
}
