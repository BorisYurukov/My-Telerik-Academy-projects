package tests.jira;

import api.pages.JiraAPi;
import jira.pages.PopUpPage;
import jira.pages.StartPage;
import org.junit.BeforeClass;
import org.junit.Test;

import static api.Constants.Constants.BUG_NAME;
import static api.Constants.Constants.STORY_NAME;

public class JiraTest extends JiraBase {
    public static String uniqueBugName = BUG_NAME + timestamp;
    public static String uniqueStoryName = STORY_NAME + timestamp;

    @BeforeClass
    public static void navigateMainRequiredPage() {
        StartPage startPage = new StartPage(actions.getDriver());
        startPage.switchToJira();
        startPage.selectExistingProject();
        startPage.navigateToIssuesBox();
    }

    @Test
    public void createBugTest() {
        PopUpPage createIssue = new PopUpPage(actions.getDriver());
        createIssue.CreateBug(uniqueBugName);
        createIssue.assertBugIsCreated(uniqueBugName);
    }

    @Test
    public void createStoryTest() {
        PopUpPage createIssue = new PopUpPage(actions.getDriver());
        createIssue.createStory(uniqueStoryName);
        createIssue.assertStoryIsCreated(uniqueStoryName);
    }

    @Test
    public void linkingStoryToBugTest() {
        String inputBugName = uniqueBugName;
        String storyName = uniqueStoryName;
        JiraAPi createIssuesViaREstAssured = new JiraAPi();
        createIssuesViaREstAssured.successfullyCreateJiraBug_when_valid_arguments_are_passed(inputBugName);
        createIssuesViaREstAssured.successfullyCreateStory_When_valid_arguments_are_passed(storyName);

        PopUpPage linking = new PopUpPage(actions.getDriver());
        linking.linkStoryToBug(inputBugName, storyName);
        linking.assertLinkedIssues();
    }
}


