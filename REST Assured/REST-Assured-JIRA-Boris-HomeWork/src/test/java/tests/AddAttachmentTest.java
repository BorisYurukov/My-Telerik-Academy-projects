package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static com.telerikacademy.api.tests.Constants.*;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static com.telerikacademy.api.tests.KeysValidation.*;
public class AddAttachmentTest extends BaseTestSetup {
    @Test
    public static void uploadFile()
    {
        checkBugKey();
        baseURI = baseURL + "/rest/api/2/user/search?query=" + user_email;
        Response mainUserAccountInformation = given()
                .contentType("application/json")
                .get(baseURI);

        String accID = mainUserAccountInformation.getBody()
                                                 .jsonPath()
                                                 .getList("accountId")
                                                 .get(0)
                                                 .toString();


        String attachmentBaseUrl = baseURL + endOfTheUrl + "/" + BUG_KEY + "/attachments";
        //Go to Contstants and provide your file location;
        File file = new File(FILE_LOCATION_ON_PC);

        Response response = given()
                .header("X-Atlassian-Token", "no-check")
                .multiPart("file", file)
                .post(attachmentBaseUrl);

        String assignBodyCheck = response.getBody().asPrettyString();
        System.out.println("File upload rest API response body is :\n" + assignBodyCheck);

        int statusCode = response.getStatusCode();
        String fileAttachmentID = response.getBody().jsonPath().getList("id").get(0).toString();
        String fileAttachmentSelf = response.getBody().jsonPath().getList("self").get(0).toString();
        String authorID = response.getBody().jsonPath().getList("author.accountId").get(0).toString();
        String dateOfCreation = response.getBody().jsonPath().getList("created").get(0).toString();
        String fileType = response.getBody().jsonPath().getList("mimeType").get(0).toString();
        String fileAttachmentContnentFiled = response.getBody().jsonPath().getList("content").get(0).toString();

        assertEquals(200, statusCode);
        assertEquals("image/jpeg", fileType);
        assertTrue(dateOfCreation.contains(FILE_CREATION_DATE));
        assertEquals(accID, authorID);
        assertTrue(fileAttachmentSelf.contains(fileAttachmentID));
        assertTrue(fileAttachmentContnentFiled.contains(fileAttachmentID));
    }
}
