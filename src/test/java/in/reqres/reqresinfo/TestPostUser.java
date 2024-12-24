package in.reqres.reqresinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPostUser extends TestBase {

    @Test
            public void testPostCreateUser(){

        // Prepare JSON payload for creating a new user
        String requestBody = "{ \"name\": \"John\", \"job\": \"Developer\" }";



        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)  // 201 is for successful creation
                .extract()
                .response();

        Assert.assertEquals("John", response.jsonPath().getString("name"));
        Assert.assertEquals("Developer", response.jsonPath().getString("job"));
    }

    @Test
    public void testPostLoginSuccessful() {
        String requestBody = "{ \"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\" }";

        Response response = given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/login")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Check for token or successful login response
       Assert.assertTrue(response.jsonPath().getString("token").length() > 0, "Token should be present");
    }

}
