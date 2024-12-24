package in.reqres.reqresinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestDeleteUser extends TestBase {

    @Test
    public void testDeleteUser() {
        Response response = given()
                .when()
                .delete("/api/users/2")  // Assuming 2 is a valid user ID to delete
                .then()
                .statusCode(204)  // No Content for successful delete
                .extract()
                .response();
    }
}

