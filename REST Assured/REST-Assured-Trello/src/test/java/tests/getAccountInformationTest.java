package tests;
import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import  static com.telerikacademy.api.tests.Constants.*;
import static io.restassured.RestAssured.get;
import static java.lang.String.format;
import static org.testng.Assert.*;

public class getAccountInformationTest extends BaseTestSetup {



    @Test
    public void getAccountInformationTest(){
        String baseURI=format("%s/members/me?key=%s&token=%s",baseURL,accountKey,accountToken);

        Response response=get(baseURI);

        int statusCode=response.getStatusCode();

        assertEquals(statusCode,200,"Invalid status code");
        assertNotNull(response.getBody().asString(), "Response body is null");
        assertEquals(response.getBody().jsonPath().get("email").toString()
                ,email,
                "Email in response body is not corresponding");
        assertEquals(response.getBody().jsonPath().get("username").toString()
                ,userName,
                "Username in response body is not corresponding.");
    }

}
