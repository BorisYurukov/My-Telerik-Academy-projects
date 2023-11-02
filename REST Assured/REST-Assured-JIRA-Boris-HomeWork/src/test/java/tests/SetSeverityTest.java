package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.KeysValidation.checkBugKey;
import static com.telerikacademy.api.tests.RequestsBodies.addingCustomFields;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;
import static org.testng.AssertJUnit.assertEquals;

public class SetSeverityTest extends BaseTestSetup {
    @Test
    public static void addingFieldToExcsitiingClass() {
        CreateBugTest createBugTest=new CreateBugTest();
        createBugTest.successfullyCreateJiraBug_when_valid_arguments_are_passed();

        checkBugKey();
        baseURI = baseURL + endOfTheUrl + "/" + BUG_KEY;

        String severityScale = "Highest";
        String body = addingCustomFields(severityScale);

        Response response = given().
                contentType("application/json").
                body(body).
                put(baseURI);

        System.out.printf("Bug %s severity was set to %s.%n", BUG_KEY, severityScale);
        int statusCode = response.getStatusCode();
        assertEquals(204, statusCode);
        assertEquals("", response.getBody().asPrettyString());
        System.out.println(response.getStatusCode());
    }
}
