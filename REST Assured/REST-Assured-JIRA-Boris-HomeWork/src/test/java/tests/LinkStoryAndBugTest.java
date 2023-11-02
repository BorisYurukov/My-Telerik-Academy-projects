package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.RequestsBodies.linkBody;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static java.lang.String.format;
import static com.telerikacademy.api.tests.KeysValidation.*;
public class LinkStoryAndBugTest extends BaseTestSetup {
    @Test
    public static void e_linkStoryAndBug() {
        checkBugKey();
        checkStoryKey();
        String bugURL = baseURL + endOfTheUrl + "/" + BUG_KEY;

        Response assign = given()
                .contentType("application/json")
                .body(format(linkBody, STORY_KEY))
                .put(bugURL);

        String assignBodyCheck = assign.getBody().asPrettyString();
        int statusCode = assign.getStatusCode();

        assertEquals(204, statusCode);
        assertEquals("", assignBodyCheck);
    }
}
