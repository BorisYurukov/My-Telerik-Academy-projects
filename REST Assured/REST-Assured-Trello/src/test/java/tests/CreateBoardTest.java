package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.RequestsBodies.*;
import static com.telerikacademy.api.tests.NamesAndDescriptions.*;
import static io.restassured.RestAssured.*;
import static java.lang.String.format;
import static org.testng.Assert.*;
import static com.telerikacademy.api.tests.JSONValidator.*;

public class CreateBoardTest extends BaseTestSetup {



    @Test
    public void createBoardTest() {

        boolean isNameValid = true;
        if (boardName.length() < MIN_BOARD_NAME_LENGHT || boardName.length() > MAX_BOARD_NAME_LENGTH) {
            isNameValid = false;
        }

        assertTrue(isNameValid, "invalid Board name");

        baseURI = format("%s/boards/?name=%s&key=%s&token=%s", baseURL, boardName, accountKey, accountToken);

        assertTrue(isValid(createBoardBody), "Invalid body.");

        Response response = given().contentType("application/json")
                                   .body(createBoardBody)
                                   .when()
                                   .post(baseURI);

        int statusCode = response.getStatusCode();
        String responseName = response.getBody().jsonPath().get("name").toString();
        int nameLength = responseName.length();


        assertEquals(statusCode, 200, "Invalid status code.");
        assertTrue(nameLength > MIN_BOARD_NAME_LENGHT || nameLength < MAX_BOARD_NAME_LENGTH);
        assertNotNull(response.body().asString(), "Response body is null");
        assertEquals(response.getBody().jsonPath().get("name").toString()
                , boardName,
                "Board name is different than expected");
        boardId = response.getBody().jsonPath().get("id").toString();

        System.out.printf("Board with id %s was created\n", boardId);
        System.out.println();

    }
}

