package jira.pages;

import org.openqa.selenium.WebDriver;

import static com.jira.testframework.pages.Utils.getConfigPropertyByKey;

public class StartPage extends BaseJiraPage{

    public StartPage(WebDriver driver){
        super(driver, "");
    }

    public void switchToJira() {

        actions.waitForElementVisible("jira.startPage.switchToJiraButton");
        actions.clickElement("jira.startPage.switchToJiraButton");
    }

    public void selectExistingProject() {

        String projectKey=getConfigPropertyByKey("jira.existingProjectKey");

        actions.waitForElementVisible("jira.startPage.existingProjectWithKey", projectKey);
        actions.clickElement("jira.startPage.existingProjectWithKey", projectKey);
    }

    public void navigateToIssuesBox() {
        actions.waitForElementVisible("//a[@data-testid=\"navigation-apps-sidebar-software-classic.ui.menu.issues-link--item\"]");
        actions.clickElement("//a[@data-testid=\"navigation-apps-sidebar-software-classic.ui.menu.issues-link--item\"]");
    }
}
