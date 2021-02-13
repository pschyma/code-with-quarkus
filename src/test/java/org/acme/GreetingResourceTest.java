package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class GreetingResourceTest {

  @Test
  public void testHelloEndpoint() {
    given()
        .when()
        .get("/hello-resteasy/10")
        .then()
        .statusCode(200)
        .body(is("Hello RESTEasy\n".repeat(10)));
  }

  @Test
  public void testHelloEndpointExceptionLogged() {
    given()
            .when()
            .get("/hello-resteasy/1000")
            .then()
            .statusCode(200)
            .body(is("Hello RESTEasy\n".repeat(1000)));
  }

  @Test
  public void testHelloEndpointExceptionLoggedAndTestFailure() {
    given()
            .when()
            .get("/hello-resteasy/2000")
            .then()
            .statusCode(200)
            .body(is("Hello RESTEasy\n".repeat(2000)));
  }
}
