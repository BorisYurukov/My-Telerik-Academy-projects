package test.cases.trello;

import org.junit.Before;
import pages.trello.LoginPage;

import com.telerikacademy.testframework.UserActions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class BaseTest {

    static UserActions actions = new UserActions();

    @BeforeClass
    public static void setUp() {
        UserActions.loadBrowser("trello.homePage");
    }

    @AfterClass
    public static void tearDown() {
        UserActions.quitDriver();
    }

    @BeforeClass
    public static void login() {
        LoginPage loginPage = new LoginPage(actions.getDriver());
        loginPage.loginUser("user");
    }

}
