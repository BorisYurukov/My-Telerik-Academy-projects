package tests.jira;

import com.jira.testframework.pages.UserActions;
import jira.pages.HomePage;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

public class JiraBase {
    public static String timestamp;
    public static DateTimeFormatter dtf;
    static UserActions actions = new UserActions();

    @BeforeClass
    public static void setUp() {
        UserActions.loadBrowser("jira.homePage");
    }

//    @AfterClass
//    public static void tearDown() {
//        UserActions.quitDriver();
//    }

    @BeforeClass
    public static void login() {
        HomePage loginPage = new HomePage(actions.getDriver());
        loginPage.loginIn("user");
    }
    @BeforeClass
    public static void timeStamping(){
        dtf = DateTimeFormatter.ISO_INSTANT;
        Instant time = Instant.now();
        timestamp = dtf.format(time);
    }


}
