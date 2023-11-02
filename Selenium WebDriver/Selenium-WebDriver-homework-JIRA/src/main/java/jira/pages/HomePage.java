package jira.pages;

import org.openqa.selenium.WebDriver;

import static com.jira.testframework.pages.Utils.getConfigPropertyByKey;

public class HomePage extends BaseJiraPage {


    public HomePage(WebDriver driver) {
        super(driver,"jira.loginPage");
    }

    public void loginIn(String userKey) {
        String username=getConfigPropertyByKey("jira.users." + userKey + ".username");
        String password=getConfigPropertyByKey("jira.users." + userKey + ".password");
        navigateToPage();
        assertPageNavigated();

        actions.waitForElementVisible("jira.loginPage.username");
        actions.typeValueInField(username,"jira.loginPage.username");
        actions.clickElement("jira.loginPage.continueSubmitButton");

        actions.waitForElementVisible("jira.loginPage.password");
        actions.typeValueInField(password,"jira.loginPage.password");
        actions.waitForElementClickable("jira.loginPage.continueSubmitButton");
        actions.clickElement("jira.loginPage.continueSubmitButton");
    }
}

