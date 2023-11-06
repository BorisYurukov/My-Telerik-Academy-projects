package pages.trello;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BoardPage extends BaseTrelloPage {
    public BoardPage(WebDriver driver) {
        super(driver, "");
    }
    public void createList(String listName) {
        actions.waitForElementPresent("trello.boardsPageBlank");
        actions.clickElement("trello.boardsPageBlank");

        actions.waitForElementVisible("trello.boardPage.AddListComposerButton");
        actions.clickElement("trello.boardPage.AddListComposerButton");



        actions.waitForElementPresent("trello.boardPage.AddListInputBox");
        actions.typeValueInField(listName, "trello.boardPage.AddListInputBox");

        actions.waitForElementVisible("trello.boardPage.AddListButton");
        actions.clickElement("trello.boardPage.AddListButton");

    }

    public void addCardToList(String cardName, String listName) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
actions.waitForElementClickable("trello.boardPageAddCardButtons", listName);
        actions.waitForElementVisible("trello.boardPageAddCardButtons", listName);
        actions.clickElement("trello.boardPageAddCardButtons", listName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        actions.waitForElementPresent("trello.boardPage.TextBox");
        actions.waitForElementVisible("trello.boardPage.TextBox");
        actions.typeValueInField(cardName, "trello.boardPage.TextBox");

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

//        actions.waitForElementPresent("trello.boardPage.AddCard");
//        actions.waitForElementClickable("trello.boardPage.AddCard");
//        actions.clickElement("trello.boardPage.AddCard");

        actions.pressEnterKey();
    }


    public void moveCardToList(String cardName, String listName) {

        actions.waitForElementPresent("trello.boardPageSpecificCard", cardName);
        WebElement card = actions.findSpecificElement("trello.boardPageSpecificCard", cardName);

        actions.waitForElementVisible("trello.boardPageSpecificList", listName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement destination = actions.findSpecificElement("trello.boardPageSpecificList", listName);



        Actions act = new Actions(driver);
        act.clickAndHold(card).moveToElement(destination).release().build().perform();
    }

    public void assertCardExistInList(String listName, String cardName) {
        actions.waitForElementPresent("trello.boardPageCardOnList", listName, cardName);
    }

    public void assertCardIsNotInList(String listName, String cardName) {
        actions.waitForElementPresent("trello.CheckIfACard.NotInAList", listName, cardName);
    }

    public void assertListExists(String listName) {
        actions.waitForElementPresent("trello.boardPage.listByName", listName);
    }

    public void assertAddListExists() {
        actions.waitForElementPresent("trello.boardPage.AddListComposerButton");
    }
}
