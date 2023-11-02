package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.KeysValidation.*;
import static com.telerikacademy.api.tests.RequestsBodies.assigneBody;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.testng.AssertJUnit.assertEquals;

public class AssignAssignessTest extends BaseTestSetup {
   static String accID;

    @BeforeTest
    public static void gettingAccId() {
        String baseURI = baseURL + "/rest/api/2/user/search?query=" + user_email;
        Response response = given()
                .contentType("application/json")
                .get(baseURI);

        accID = response.getBody().jsonPath().getList("accountId").get(0).toString();
    }

    @Test
    public static void assignAssigneToTheStory_when_email_is_provided() {
        checkStoryKey();

        String storyURL = baseURL + endOfTheUrl + "/" + STORY_KEY;

        Response assign = given()
                .contentType("application/json")
                .body(format(assigneBody, accID))
                .put(storyURL);

        String assignBodyCheck = assign.getBody().asPrettyString();
        int statusCode = assign.getStatusCode();
        assertEquals(204, statusCode);
        assertEquals("", assignBodyCheck);
    }

    @Test
    public void assignAssigneToTheBug_when_email_is_provided() {
        checkBugKey();
        String bugURL = baseURL + endOfTheUrl + "/" + BUG_KEY;

        Response assign = given()
                .contentType("application/json")
                .body(format(assigneBody, accID))
                .put(bugURL);

        String assignBodyCheck = assign.getBody().asPrettyString();
        int statusCode = assign.getStatusCode();

        assertEquals(204, statusCode);
        assertEquals("", assignBodyCheck);
    }
}
