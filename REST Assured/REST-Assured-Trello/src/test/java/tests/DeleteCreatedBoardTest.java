package tests;
import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import  static com.telerikacademy.api.tests.Constants.*;

import static io.restassured.RestAssured.*;
import static java.lang.String.format;
import static org.testng.Assert.*;
public class DeleteCreatedBoardTest extends BaseTestSetup {

@Test
    public static void deleteCreatedBoardTest(){

        baseURI=format("%s/boards/%s?key=%s&token=%s",baseURL,boardId,accountKey,accountToken);

        Response response=delete(baseURI);
        int statusCode=response.getStatusCode();
        assertEquals(statusCode,200,"Invalid status code.");
        System.out.println("Board was deleted.");
    }
}
