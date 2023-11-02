package com.telerikacademy.api.tests;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.SummariesAndDescriptions.*;
import static java.lang.String.format;
import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.SummariesAndDescriptions.*;
public class RequestsBodies {
    public static final String storyBody =format(
            "{\n" +
                    "  \"fields\": {\n" +
                    "    \"project\": {\n" +
                    "      \"key\": \"%s\"\n" +
                    "    },\n" +
                    "    \"summary\": \"%s\",\n" +
                    "    \"description\": \"%s\",\n" +
                    "    \"issuetype\": {\n" +
                    "      \"name\": \"%s\"\n" +
                    "    }\n" +
                    "  }\n" +
                    "}",projectKey,storySummary,storyDescription,storyIssueType);




    public static final String  createProject="{\n"+
            "\"assigneeType\": \"PROJECT_LEAD\","+
            "\"key\": \"TBDS\","+
            "\"leadAccountId\":\"712020:24230a06-bc45-440c-be1a-93fa7f492578\","+
            "\"name\":\"TOBEDELETEDSECOND\","+
            "\"projectTemplateKey\":\"com.pyxis.greenhopper.jira:gh-simplified-scrum-classic\""+
            "}";
    public static final String bugBody = format("{\n" +
            "  \"fields\": {\n" +
            "    \"project\": {\n" +
            "      \"key\": \"%s\"\n" +
            "    },\n" +
            "    \"summary\": \"%s\",\n" +
            "    \"description\": \"%s\",\n" +
            "    \"issuetype\": {\n" +
            "      \"name\": \"%s\"\n" +
            "    }\n" +
            "  }\n" +
            "}",projectKey,bugSummary,bugDescription,bugIssueType);

    public static final String linkBody = "{\n" +
            "    \"update\":{\n" +
            "        \"issuelinks\":[ {\n" +
            "            \"add\":{\n" +
            "    \"type\": {\n" +
            "        \"name\": \"Blocks\",\n" +
            "        \"inward\":\"is blocked by\",\n" +
            "        \"outward\":\"blocks\"\n" +
            "    },\n" +
            "    \"outwardIssue\": {\n" +
            "        \"key\": \"%s\"\n" +
            "    }\n" +
            "            }\n" +
            "        }\n" +
            "        ]\n" +
            "}\n"+
            "}";
    public static final String assigneBody =
            "{\n" +
                    "     \"fields\":{\n" +
                    "         \"assignee\":{\n" +
                    "              \"accountId\": \"%s\"\n" +
                    "         }\n" +
                    "     }\n" +
                    "}";

    public  static  String addingCustomFields(String fieldName){
        String body=format("{ \n"+
                        "\"fields\": { \n"+
                        "\"customfield_10040\": [{\n"+
                        "\"value\": \"%s\" \n"+
                        "}]\n"+
                        "}\n"+
                        "}"
                ,fieldName);

        return  body;
    }

}
