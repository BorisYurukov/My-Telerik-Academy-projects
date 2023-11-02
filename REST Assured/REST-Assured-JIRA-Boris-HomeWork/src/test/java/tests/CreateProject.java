package tests;

import base.BaseTestSetup;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.JSONValidation.isValid;
import static com.telerikacademy.api.tests.RequestsBodies.bugBody;
import static com.telerikacademy.api.tests.RequestsBodies.createProject;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.testng.Assert.assertTrue;

public class CreateProject extends BaseTestSetup {

    @Test
    public void createProject() {
        baseURI = baseURL + "/rest/api/2/project";

        assertTrue(isValid(createProject));
        Response response = getApplicationJSONSpecification()
                .body(createProject)
                .when()
                .post(baseURI);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);


        String id = response.getBody().jsonPath().get("id").toString();
        System.out.println(id);
        System.out.println("Response bug body is: \n " + response.getBody().asPrettyString());

           projectId=id;



//        baseURI = baseURL +  format("/rest/api/3/project/%s",id);
//
//        assertTrue(isValid(bugBody));
//        Response response3 = given().
//                contentType("application/json")
//                .when()
//                .delete(baseURI);
//
//        int statusCode3 = response.getStatusCode();
//        System.out.println(statusCode3);
//
//        System.out.println("Response bug body is: \n " + response.getBody().asPrettyString());



//



    }


    @Test
    public  void  deleteExistingProject(){

        baseURI = baseURL +  format("/rest/api/3/project/%s",projectId);

        assertTrue(isValid(bugBody));
        Response response = getApplicationJSONSpecification()
                .when()
                .delete(baseURI);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        System.out.println("Response bug body is: \n " + response.getBody().asPrettyString());
    }


    @Test
    public  void deleteItEternaly(){
        baseURI = baseURL + format("/rest/api/content/%s",projectId);

        assertTrue(isValid(bugBody));
        Response response2 = getApplicationJSONSpecification()
                .when()
                .delete(baseURI);

        int statusCode4 = response2.getStatusCode();
        System.out.println(response2.getBody().asPrettyString());
        System.out.println(statusCode4);
    }
}









//    @Test
//    public void getMyId() {
//        baseURI = baseURL + "/rest/api/2/myself";
//        Response response = given().contentType("application/json").get(baseURI);
//        JsonPath jsonPath = response.jsonPath();
//        String accId = jsonPath.get("accountId");
//        System.out.println(accId);
////        System.out.println("Response bug body is: \n " + response.getBody().asPrettyString());
//    }

