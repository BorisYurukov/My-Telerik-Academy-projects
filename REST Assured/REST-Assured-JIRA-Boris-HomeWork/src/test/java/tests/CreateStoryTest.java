package tests;


import base.BaseTestSetup;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.testng.annotations.Test;




import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.RequestsBodies.*;
import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertTrue;


public class CreateStoryTest extends BaseTestSetup {


    @Test(priority = 1)

    public static void successfullyCreateStory_When_valid_arguments_are_passed() {
        baseURI = baseURL + endOfTheUrl;

        Response response = given().
                contentType("application/json").
                body(storyBody)
                .when()
                .post(baseURI);


        System.out.println("Story response  body is:\n " + response.getBody().asPrettyString());

        int statusCode = response.getStatusCode();

        JsonPath jsonPath = response.jsonPath();

        String storyURL = jsonPath.get("self");
        String storyID = jsonPath.get("id");
        String storyKey = jsonPath.get("key");

        storyKey = storyKey;
        String expectedURL = baseURL + endOfTheUrl + "/" + storyID;


        assertEquals(201, statusCode);
        assertNotNull(response.getBody());
        assertTrue(storyURL.contains(storyID));
        assertTrue("Incorrect response body.Story key must contain project key", storyKey.contains(projectKey));
        assertEquals(storyURL, expectedURL);


        STORY_KEY = storyKey;
    }
}
