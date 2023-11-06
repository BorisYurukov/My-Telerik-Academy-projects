package api;

import com.telerikacademy.testframework.PropertiesManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class TrelloApi {

    private RequestSpecification getRestAssured() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .log().all()
                .baseUri(PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties().getProperty("trello.base.Url"))
                .queryParam("key", PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties().getProperty("tello.users.api.KEY"))
                .queryParam("token", PropertiesManager.PropertiesManagerEnum.INSTANCE.getConfigProperties().getProperty("trello.users.user.apiToken"));
    }

    public List<String> getUserBoards() {
        return getRestAssured()
                .get("/members/me")
                .thenReturn()
                .jsonPath()
                .get("idBoards");
    }

    public Response createBoard(String name, String description) {
        return getRestAssured()
                .queryParam("name", name)
                .queryParam("description", description)
                .when()
                .post("/board")
                .then()
                .extract()
                .response();
    }

    public Response deleteBoard(String boardId) {
        return getRestAssured()
                .when()
                .delete("boards/" + boardId)
                .then()
                .extract()
                .response();
    }

    public Response createList(String boardId, String name) {
        return getRestAssured()
                .when()
                .queryParam("name", name)
                .post(boardId + "/lists")
                .then()
                .extract()
                .response();
    }

    public Response createCard(String listId, String name) {
        return getRestAssured()
                .when()
                .queryParam("name", name)
                .queryParam("idLists", listId)
                .post("cards")
                .then()
                .extract()
                .response();
    }
}

