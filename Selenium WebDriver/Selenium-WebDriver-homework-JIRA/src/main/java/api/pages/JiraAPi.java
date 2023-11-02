package api.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;

import static api.Constants.Constants.*;
import static api.Constants.JSONBodies.bugBody;
import static api.Constants.JSONBodies.storyBody;
import static io.restassured.RestAssured.baseURI;

public class JiraAPi {


    public static RequestSpecification getApplicationJSONSpecification() {
        return RestAssured.given().auth().preemptive().basic(user_email, password)
                .contentType("application/json").when();
    }

    public void successfullyCreateJiraBug_when_valid_arguments_are_passed(String bugSummary ) {
        baseURI = baseURL + endOfTheUrl;

        String bugBodyStampped=bugBody(bugSummary);

        Response response =(Response) getApplicationJSONSpecification()
                .body(bugBodyStampped)
                .when()
                .post(baseURI);
    }

    public  void successfullyCreateStory_When_valid_arguments_are_passed(String storySummary) {
        baseURI = baseURL + endOfTheUrl;
        String storyBodyStampped=storyBody(storySummary);

        Response response =(Response) getApplicationJSONSpecification()
                .body(storyBodyStampped)
                .when()
                .post(baseURI);

    }



}
