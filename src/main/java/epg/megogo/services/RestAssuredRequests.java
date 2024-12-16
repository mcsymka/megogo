package epg.megogo.services;

import io.restassured.specification.RequestSpecification;

import java.net.URI;

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
