package tests;
import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import  static com.telerikacademy.api.tests.Constants.*;
import  static  com.telerikacademy.api.tests.NamesAndDescriptions.*;
import static io.restassured.RestAssured.*;
import static java.lang.String.format;
import static org.testng.Assert.*;


public class CreateNewListTest extends BaseTestSetup {



    @Test
    public  void createNewListTest(){
checkForBoard(boardId);
        baseURI = format("%s/lists?name=%s&idBoard=%s&key=%s&token=%s",
                baseURL,
                listName,
                boardId,
                accountKey,
                accountToken);
        Response response = given().contentType("application/json")
                                   .when()
                                   .post(baseURI);
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200,"Invalid status code");
        assertNotNull(response.body().asString());
        assertEquals(response.getBody().jsonPath().get("name").toString(),
                listName,"Name of the list is not corresponding.");
        listId=response.getBody().jsonPath().get("id").toString();
        System.out.printf("List %s with id :%s was created\n",listName,listId);
        System.out.println();

    }

    private  void checkForBoard(String BoardId){

        if(BoardId==null){
            CreateBoardTest createBoardTest=new CreateBoardTest();
            createBoardTest.createBoardTest();
        }
    }
}
