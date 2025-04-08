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
                .body(is("[{\"id\":1,\"name\":\"Ifood\",\"transactionTypeId\":0,\"transactionDate\":\"2025-03-26\",\"amount\":-52.0,\"category\":\"Food\"},{\"id\":2,\"name\":\"Salary\",\"transactionTypeId\":1,\"transactionDate\":\"2025-03-27\",\"amount\":5300.0,\"category\":\"Salary\"}]"));
    }
}
