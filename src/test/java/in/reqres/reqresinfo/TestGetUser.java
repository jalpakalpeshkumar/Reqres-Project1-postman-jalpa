package in.reqres.reqresinfo;

import in.reqres.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestGetUser extends TestBase {

    @Test
    public void getListUsere(){
        Response response = given()
                .when()
                .get("/users?page=2");
        response.then().statusCode(200);
        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(),200);
        Assert.assertEquals(2, response.jsonPath().getInt("page"), "Page should be 2");
        Assert.assertEquals(6, response.jsonPath().getInt("per_page"), "per_page should be 6");
        Assert.assertEquals(8, response.jsonPath().getInt("data[1].id"), "Second user's ID should be 8");
        Assert.assertEquals("Byron", response.jsonPath().getString("data[3].first_name"), "Fourth user's first name should be Byron");
        Assert.assertEquals(6, response.jsonPath().getList("data").size(), "There should be 6 users");
        Assert.assertEquals("https://reqres.in/img/faces/12-image.jpg", response.jsonPath().getString("data[5].avatar"), "Avatar of 6th user should match");
        Assert.assertEquals("https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral", response.jsonPath().getString("support.url"), "Support URL should be correct");
        Assert.assertEquals("Tired of writing endless social media content? Let Content Caddy generate it for you.", response.jsonPath().getString("support.text"), "Support text should be correct");
    }



    @Test
    public void testGetSingleUser(){
        Response response = given()
                .when()
                .get("/api/users/2");
        response.prettyPrint();
        response.then().statusCode(200);

        Assert.assertEquals(2, response.jsonPath().getInt("data.id"), "User ID should be 2");


    }
}
