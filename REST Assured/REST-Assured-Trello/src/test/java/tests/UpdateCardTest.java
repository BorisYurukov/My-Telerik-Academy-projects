package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;

import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;

import static com.telerikacademy.api.tests.JSONValidator.isValid;
import static com.telerikacademy.api.tests.NamesAndDescriptions.*;
import static com.telerikacademy.api.tests.RequestsBodies.updateCard;
import static io.restassured.RestAssured.*;
import static java.lang.String.format;
import static org.testng.Assert.*;


public class UpdateCardTest extends BaseTestSetup {

    @Test
    public void updateCardTest() {
        checkForCard(cardId);

        baseURI = format("%s/cards/%s?key=%s&token=%s", baseURL, cardId, accountKey, accountToken);

        assertTrue(isValid(updateCard),"Invalid body.");

        Response response = given().contentType("application/json")
                                   .body(updateCard)
                                   .when()
                                   .put(baseURI);


        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "Invalid status code");
        assertNotNull(response.body().asString());
        assertEquals(response.getBody().jsonPath().get("name")
                , cardNewName,
                "Card name has not been updated.");
        assertEquals(response.getBody().jsonPath().get("desc")
                , cardNewDescription,
                "Card description  has not been updated.");

        System.out.printf("Card name \"%s\" was changed to \"%s\"\n " +
                        "Card description: \"%s\" was changed to \"%s\"",
                cardName,
                cardNewName,
                cardDescription,
                cardNewDescription);
        System.out.println();
    }

    private void checkForCard(String cardId) {

        if (cardId == null) {
            CreateBoardTest createBoardTest = new CreateBoardTest();
            createBoardTest.createBoardTest();
            CreateNewListTest createNewListTest = new CreateNewListTest();
            createNewListTest.createNewListTest();
            CreateCardTest createCardTest = new CreateCardTest();
            createCardTest.createCardTest();
        }
    }
}
