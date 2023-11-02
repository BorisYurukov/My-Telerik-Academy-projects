package tests;

import io.restassured.response.Response;
import base.BaseTestSetup;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.JSONValidation.isValid;
import static com.telerikacademy.api.tests.KeysValidation.*;
import static com.telerikacademy.api.tests.Constants.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static java.lang.String.format;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TransitionTest extends BaseTestSetup {

    @Test
    public void moveStory() {

        checkStoryKey();
        baseURI = baseURL + endOfTheUrl + "/" + STORY_KEY + "/transitions";
        String  storyStatus="To Do";
        String id = getTranstionId(storyStatus);
        String body = format(
                "{\n" +
                        "\"transition\": {" +
                        "\"id\": \"%s\"\n" +
                        "}\n" +
                        "}", id);


        assertTrue(isValid(body), "Invalid body.");
        Response response = given().contentType("application/json").body(body).post();

        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 204, "Incorrect status code");
        assertEquals(response.body().asString(), "", "Response body isn't empty.");
        System.out.printf("Story with key %s was moved to \"%s\".", STORY_KEY,storyStatus);
    }

    private String getTranstionId(String transition) {
        String transitionID = null;
//        String baseUrI = baseURL + endOfTheUrl + "/" + STORY_KEY + "/transitions";

        Response response = get();

        if (response.getBody().jsonPath().get("transitions[0].name").equals(transition)) {
            transitionID = response.getBody().jsonPath().get("transitions[0].id");
            System.out.println("Transition id is :" + transitionID);
        }

        return transitionID;
    }



}
