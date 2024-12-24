package in.reqres.testbase;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

/**
 * Created by Jay Vaghani
 */
public class TestBase {

    @BeforeClass
    public void init(){
        RestAssured.baseURI = "https://reqres.in" ;
        RestAssured.basePath = "/api";

    }

}