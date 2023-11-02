package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;

import static com.telerikacademy.api.tests.NamesAndDescriptions.*;
import static com.telerikacademy.api.tests.RequestsBodies.createNewCard;
import static io.restassured.RestAssured.*;
import static java.lang.String.format;
import static org.testng.Assert.*;
import  static com.telerikacademy.api.tests.JSONValidator.*;

public class CreateCardTest extends BaseTestSetup {

    @Test
    public void createCardTest() {
        checkForBoardAndList(listId);

        baseURI = format("%s/cards?idList=%s&key=%s&token=%s", baseURL, listId, accountKey, accountToken);

        assertTrue(isValid(createNewCard),"Invalid body.");

        Response response = given().contentType("application/json")
                                   .body(createNewCard)
                                   .when()
                                   .post(baseURI);

        int statusCode = response.getStatusCode();

        assertEquals(response.getBody().jsonPath().get("name")
                , cardName,
                "Card name is not correct");
        assertEquals(response.getBody().jsonPath().get("desc")
                , cardDescription,
                "Card description is not correct");
        assertEquals(statusCode, 200, "Invalid status code");
        assertNotNull(response.body().asString());

        cardId = response.getBody().jsonPath().get("id").toString();
        System.out.printf("Card %s with id:%s was created\n", cardName, cardId);
        System.out.println();

    }

    private void checkForBoardAndList(String ListId) {
        if (ListId == null) {
            CreateBoardTest createBoardTest = new CreateBoardTest();
            createBoardTest.createBoardTest();
            CreateNewListTest createNewListTest = new CreateNewListTest();
            createNewListTest.createNewListTest();
        }
    }
}
