package org.api.resource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;


@QuarkusTest
class TransactionResourceTest {

    @Test
    void testTransactionsGET() {
        given()
            .when().get("/transactions")
            .then()
                .statusCode(200)
                .body(is("[]")); // Assuming no transactions are present initially
    }
}
