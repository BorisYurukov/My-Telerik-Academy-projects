package api.Constants;

import static api.Constants.Constants.*;
import static api.Constants.SummariesAndDescriptions.*;
import static java.lang.String.format;

public class JSONBodies {

    public static String storyBody(String summary) {
        return format(
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
                        "}", projectKey,summary , storyDescription, storyIssueType);
    }


    public static final String  createProject=format("{\n"+
            "\"assigneeType\": \"PROJECT_LEAD\","+
            "\"key\": \"%s\","+
            "\"leadAccountId\":\"712020:24230a06-bc45-440c-be1a-93fa7f492578\","+
            "\"name\":\"%s\","+
            "\"projectTemplateKey\":\"com.pyxis.greenhopper.jira:gh-simplified-scrum-classic\""+
            "}",projectKey,projectKey);
    public static String bugBody(String bugSummary) {
        return format("{\n" +
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
                "}", projectKey, bugSummary, bugDescription, bugIssueType);
    }


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
