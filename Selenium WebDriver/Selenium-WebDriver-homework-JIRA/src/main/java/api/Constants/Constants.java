package api.Constants;

import static com.jira.testframework.pages.Utils.getConfigPropertyByKey;

public class Constants {

    public static final String password = getConfigPropertyByKey("trello.users.user.apiToken");
    //    Provide your email address:
    public static final String user_email = getConfigPropertyByKey("jira.users.user.username");
    //    Provide your  Jira URL
    public static final String baseURL=getConfigPropertyByKey("jira.restAssured.baseUrl");
    public  static  final String endOfTheUrl="/rest/api/2/issue";
//    Provide your personal path to the picture.Bellow is just an example.It can be anywhere on pc:

    //   Provide your own project key:
    public static  final String projectKey=getConfigPropertyByKey("jira.existingProjectKey");
    public  static  String STORY_KEY;
    public  static  String BUG_KEY;

    public  static  String BUG_NAME=getConfigPropertyByKey("jira.createBugName");
    public static  String STORY_NAME=getConfigPropertyByKey("jira.createStoryName");



}
