package tests;

import base.BaseTestSetup;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.baseURL;
import static com.telerikacademy.api.tests.Constants.endOfTheUrl;
import static com.telerikacademy.api.tests.JSONValidation.isValid;
import static com.telerikacademy.api.tests.RequestsBodies.bugBody;
import static com.telerikacademy.api.tests.RequestsBodies.createProject;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;
public class DeleteProejct extends BaseTestSetup {
@Test
    public  void  deleteExistingProject(){

        baseURI = baseURL +  format("/rest/api/3/project/%s",projectId);

        assertTrue(isValid(bugBody));
        Response response = given().
                contentType("application/json")
                .when()
                .delete(baseURI);

        int statusCode = response.getStatusCode();
    System.out.println(statusCode);

        System.out.println("Response bug body is: \n " + response.getBody().asPrettyString());
    }
}
