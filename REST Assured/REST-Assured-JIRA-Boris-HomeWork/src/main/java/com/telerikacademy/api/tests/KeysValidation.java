package com.telerikacademy.api.tests;

import io.restassured.response.Response;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Constants.STORY_KEY;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class KeysValidation {
    public static  void checkBugKey() {

        if (BUG_KEY == null) {

            baseURI = baseURL + "/rest/api/2/search";

            String jql = format("project = %s AND type = Bug ORDER BY created DESC ", projectKey);

            Response response = given()
                    .queryParam("jql", jql)
                    .queryParam("maxResult", 1)
                    .get();
            System.out.println(response.getStatusCode());
            String check = response.getBody().jsonPath().get("issues.key[0]").toString();
            System.out.println(check);
            BUG_KEY = check;

        }
    }

    public static   void checkStoryKey(){

        if(STORY_KEY==null){

            baseURI=baseURL+ "/rest/api/2/search";

            String jql=format("project = %s AND type = Story ORDER BY created DESC ",projectKey);

            Response response = given()
                    .queryParam("jql", jql)
                    .queryParam("maxResult", 1)
                    .get();
            System.out.println(response.getStatusCode());
            String check=response.getBody().jsonPath().get("issues.key[0]").toString();
            System.out.println(check);
            STORY_KEY=check;
        }
    }

}
