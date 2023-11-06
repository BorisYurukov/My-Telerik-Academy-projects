package jira.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.jira.testframework.pages.Utils.getWebDriver;

public class PopUpPage extends BaseJiraPage {

    public static final String bugDescription = "*Description* \n As regular user i want to " +
            "check company  website and what they are offer. " +
            "I'm russian native speaker therefore i want to read it translated into russian language.\n " +
            " *Preconditions:*" +
            "\n Connected to the internet." +
            "\n *Steps to reproduce:*" +
            "\n 1. Navigate to url: http://phptravels.net " +
            "\n 2 .Scroll down until you reach bottom of the page. " +
            "\n *Expected result:*" +
            "\n Whole page should be translated into russian language. " +
            "\n*Actual result:*  " +
            "\n Some of buttons and fields in the page aren’t translated and they are still in english.\n" +
            "\n *Severity:* Major ";

    private static final String storyDescription = "As a regular customer i want to create new reservation in russian language.";


    public PopUpPage(WebDriver driver) {
        super(driver, "");
    }

    public void CreateBug(String bugName) {
        actions.waitForElementVisible("jira.header.create.menuButton");
        actions.waitForElementClickable("jira.header.create.menuButton");
        actions.clickElement("jira.header.create.menuButton");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        actions.waitForElementVisible("jira.newBugPopMenuUpIssueTypeButton");
        actions.clickElement("jira.newBugPopMenuUpIssueTypeButton");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().activeElement().sendKeys("Bug");
        actions.pressEnterKey();

        actions.waitForElementVisible("jira.newBUgPopMenuSummaryBox");
        actions.typeValueInField(bugName, "jira.newBUgPopMenuSummaryBox");
//
        actions.waitForElementVisible("jira.newBugPopMenuDescriptionBox");
        actions.typeValueInField(bugDescription, "jira.newBugPopMenuDescriptionBox");
//
        actions.waitForElementVisible("jira.newBugPopUpMenuPriorityButton");
        actions.clickElement("jira.newBugPopUpMenuPriorityButton");

        actions.waitForElementVisible("jira.priorityField");
        actions.typeValueInField("Highest", "jira.priorityField");
        actions.pressEnterKey();

        actions.waitForElementClickable("jira.newBugPopUpMenuCreateButton");
        actions.clickElement("jira.newBugPopUpMenuCreateButton");


    }

    public void assertBugIsCreated(String bugName) {
        actions.waitForElementVisible("jira.createdissuePopUpBox");
        actions.assertElementPresent("jira.createdissuePopUpBox");

        actions.waitForElementClickable("jira.openedIssueRefreshButton");
        actions.clickElement("jira.openedIssueRefreshButton");

        actions.waitForElementPresent("jira.issues.checkIssueExistingByName", bugName);
    }

    public void createStory(String storyName) {
        actions.waitForElementVisible("jira.header.create.menuButton");
        actions.waitForElementClickable("jira.header.create.menuButton");

        actions.clickElement("jira.header.create.menuButton");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actions.waitForElementVisible("jira.newBugPopMenuUpIssueTypeButton");
        actions.clickElement("jira.newBugPopMenuUpIssueTypeButton");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().activeElement().sendKeys("Story");
        actions.pressEnterKey();

        actions.waitForElementVisible("jira.newBUgPopMenuSummaryBox");
        actions.typeValueInField(storyName, "jira.newBUgPopMenuSummaryBox");

        actions.waitForElementVisible("jira.newBugPopMenuDescriptionBox");
        actions.typeValueInField(storyDescription, "jira.newBugPopMenuDescriptionBox");

        actions.waitForElementVisible("jira.newBugPopUpMenuPriorityButton");
        actions.clickElement("jira.newBugPopUpMenuPriorityButton");

        actions.waitForElementVisible("jira.priorityField");
        actions.typeValueInField("Highest", "jira.priorityField");
        actions.pressEnterKey();

        actions.waitForElementClickable("jira.newBugPopUpMenuCreateButton");
        actions.clickElement("jira.newBugPopUpMenuCreateButton");

        actions.waitForElementVisible("jira.createdissuePopUpBox");
        actions.assertElementPresent("jira.createdissuePopUpBox");
    }

    public void assertStoryIsCreated(String storyName) {
        actions.waitForElementVisible("jira.createdissuePopUpBox");
        actions.assertElementPresent("jira.createdissuePopUpBox");

        actions.waitForElementClickable("jira.openedIssueRefreshButton");
        actions.clickElement("jira.openedIssueRefreshButton");

        actions.waitForElementPresent("jira.issues.checkIssueExistingByName", storyName);
    }

    public void linkStoryToBug(String issueName, String issueToBeLinked) {
        actions.waitForElementClickable("jira.openedIssueRefreshButton");
        actions.clickElement("jira.openedIssueRefreshButton");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.waitForElementVisible("jira.issues.checkIssueExistingByName", issueName);
        actions.clickElement("jira.issues.checkIssueExistingByName", issueName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        actions.waitForElementPresent("jira.openedIssueLinkingIssueButton");
        actions.clickElement("jira.openedIssueLinkingIssueButton");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actions.waitForElementPresent("jira.openedIssueLinkSearchBox");
        actions.typeValueInField(issueToBeLinked, "jira.openedIssueLinkSearchBox");
        actions.pressEnterKey();

       actions.scrollToElement("jira.openedIssueClickLinkButton");

        actions.clickElement("jira.openedIssueClickLinkButton");
    }

    public void assertLinkedIssues() {
        actions.waitForElementPresent("jira.BlockingContainer");
    }

    public void createIssue(String bugName, String issueType) {

        actions.waitForElementVisible("jira.header.create.menuButton");
        actions.waitForElementClickable("jira.header.create.menuButton");
        actions.clickElement("jira.header.create.menuButton");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        actions.waitForElementPresent("jira.newBugPopMenuUpIssueTypeButton");
        actions.clickElement("jira.newBugPopMenuUpIssueTypeButton");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actions.waitForElementPresent("jira.issueTypeField");
        actions.typeValueInField(issueType, "jira.issueTypeField");
        actions.pressEnterKey();

        actions.waitForElementPresent("jira.newBUgPopMenuSummaryBox");
        actions.typeValueInField(bugName, "jira.newBUgPopMenuSummaryBox");
//
        actions.waitForElementPresent("jira.newBugPopMenuDescriptionBox");
        actions.typeValueInField(storyDescription, "jira.newBugPopMenuDescriptionBox");
//
        actions.waitForElementVisible("jira.newBugPopUpMenuPriorityButton");
        actions.clickElement("jira.newBugPopUpMenuPriorityButton");

        actions.waitForElementVisible("jira.priorityField");
        actions.typeValueInField("Highest", "jira.priorityField");
        actions.pressEnterKey();

        actions.waitForElementClickable("jira.newBugPopUpMenuCreateButton");
        actions.clickElement("jira.newBugPopUpMenuCreateButton");

        actions.waitForElementVisible("jira.createdissuePopUpBox");
        actions.assertElementPresent("jira.createdissuePopUpBox");
    }


}
