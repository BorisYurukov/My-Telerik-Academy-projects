package tests;

import base.BaseTestSetup;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;


import org.json.JSONObject;
import org.testng.annotations.Test;



import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.JSONValidation.isValid;
import static com.telerikacademy.api.tests.RequestsBodies.*;
import static com.telerikacademy.api.tests.SummariesAndDescriptions.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.testng.Assert.assertNotNull;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateBugTest extends BaseTestSetup {
    @Test(priority = 1)
    public  void successfullyCreateJiraBug_when_valid_arguments_are_passed() {
        baseURI = baseURL + endOfTheUrl;

        assertTrue(isValid(bugBody));
        Response response =(Response) getApplicationJSONSpecification()
                .body(bugBody)
                .when()
                .post(baseURI);

        int statusCode = response.getStatusCode();

        System.out.println("Response bug body is: \n " + response.getBody().asPrettyString());

        JsonPath jsonPath = response.jsonPath();
        String bugID = jsonPath.get("id");
        String bugKey = jsonPath.get("key");
        String bugURL = jsonPath.get("self");

        String expectedURL = baseURL + endOfTheUrl + "/" + bugID;

        assertEquals(format("Incorrect status code.Expected 200 but actual is %d", statusCode), statusCode, 201);
        assertNotNull(response.getBody());
        assertTrue(bugKey.contains(projectKey));
        assertEquals(bugURL, expectedURL);
        assertTrue(bugURL.contains(bugID));
        System.out.printf("Bug with %s key was created\n", bugKey);
        BUG_KEY = bugKey;
    }

    @Test
    public void createBugWithJsonObject(){

        baseURI=baseURL+endOfTheUrl;

       JSONObject project=new JSONObject();
       project.put("key",projectKey);

       JSONObject issuetype=new JSONObject();
       issuetype.put("name",bugIssueType);

       JSONObject fields=new JSONObject();
       fields.put("project",project);
       fields.put("summary",bugSummary);
       fields.put("description",bugDescription);
       fields.put("issuetype",issuetype);


      JSONObject bodyBugy=new JSONObject();
      bodyBugy.put("fields",fields);

      assertTrue(isValid(String.valueOf(bodyBugy)),"Invalid body");


        Response response = given().
                contentType("application/json")
                .body(bodyBugy.toString())
                .when()
                .post(baseURI);

        int statusCode = response.getStatusCode();

        System.out.println("Response bug body is: \n " + response.getBody().asPrettyString());

    }
}
