package github.getter;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.notNullValue;

@QuarkusTest
class GithubResourceTest {
    @Test
    void testGetReposByUsernameHappyPath() {
        given()
                .when().get("/repos/{userName}", "ajambor91")
                .then()
                .statusCode(200)
                .body("$", hasSize(notNullValue()))
                .body("[0].ownerName", is("ajambor91"))
                .body("[0].branches", notNullValue())
                .body("[0].branches", hasSize(notNullValue()))
                .body("[0].branches[0].branchName", notNullValue())
                .body("[0].branches[0].lastCommitSHA", notNullValue());
    }

}