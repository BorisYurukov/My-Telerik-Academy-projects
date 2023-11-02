package web.drivers.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;

import static com.helpers.Constants.*;
import static com.helpers.Xpaths.*;
import static com.helpers.Xpaths.BING_FIRST_RESULT_XPATH;

public class SearchUsingGoogleChromeHeadlessTest {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void webDriverSetup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    @Test
    public void searchWithBing() {
        driver.get(BING_BASE_URL);

        Assertions.assertEquals(BING_EXPECTED_URL,
                driver.getCurrentUrl(),
                "URL is different than expected.");

//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(BING_ACCEPT_COOKIES_BUTTON_XPATH)));
//        WebElement acceptCookiesButton = driver.findElement(By.xpath(BING_ACCEPT_COOKIES_BUTTON_XPATH));
//        acceptCookiesButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BING_SEARCHBOX_XPATH)));
        WebElement searchBox = driver.findElement(By.xpath(BING_SEARCHBOX_XPATH));
        searchBox.sendKeys(SEARCHED_VALUE);

        WebElement searchButton = driver.findElement(By.xpath(BING_SEARCHBUTTON_XPATH));
        searchButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(BING_FIRST_RESULT_XPATH)));
        WebElement result = driver.findElement(By.xpath(BING_FIRST_RESULT_XPATH));
        Assertions.assertEquals(EXPECTED_TITTLE, result.getText(), "Tittle is different than expected.");

        System.out.printf("\"%s\" tittle was found successfully.\n", EXPECTED_TITTLE);
    }

    @Test
    public void searchWithGoogle() {
        driver.get(GOOGLE_BASE_URL);

        Assertions.assertEquals(GOOGLE_EXPECTED_URL, driver.getCurrentUrl(), "URL is different than expected.");

        WebElement agreeButton = driver.findElement(By.xpath(GOOGLE_AGREEBUTTON_XPATH));
        agreeButton.click();

        WebElement searchBox = driver.findElement(By.xpath(GOOGLE_SEARCHBOX_XPATH));
        searchBox.sendKeys(SEARCHED_VALUE);

        WebElement googleLogo=driver.findElement(By.xpath(GOOGLE_LOGO_XPATH));
        googleLogo.click();

        WebElement searchButton = driver.findElement(By.xpath(GOOGLE_SEARCHBUTTON_XPATH));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButton.click();

        WebElement firstResult = driver.findElement(By.xpath(GOOGLE_FIRST_RESULT_XPATH));
        Assertions.assertEquals(EXPECTED_TITTLE, firstResult.getText(), "Search result not found");

        System.out.printf("\"%s\" tittle was found successfully.\n", EXPECTED_TITTLE);
    }

    @AfterAll
    public static void closeBrowserWindow() {
        driver.close();
    }
}