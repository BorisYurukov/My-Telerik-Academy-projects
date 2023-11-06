package pages.trello;

import org.openqa.selenium.WebDriver;

import static com.telerikacademy.testframework.Utils.getUIMappingByKey;

public class BoardsPage extends BaseTrelloPage {

    public BoardsPage(WebDriver driver) {
        super(driver, "");
    }

    public void createBoard() {

        String boardName = getUIMappingByKey("trello.boardName");

        actions.waitForElementClickable("trello.header.create.menuButton");
        actions.waitForElementPresent("trello.header.create.menuButton");
        actions.clickElement("trello.header.create.menuButton");

        actions.waitForElementVisible("trello.header.createBoard.dropDownButton");
        actions.clickElement("trello.header.createBoard.dropDownButton");

        actions.waitForElementVisible("trello.createBoard.titleInput");
        actions.typeValueInField(boardName, "trello.createBoard.titleInput");

        actions.waitForElementClickable("trello.create.board.submitButton");
        actions.clickElement("trello.create.board.submitButton");
    }

    public void clickOnBoard(String boardName) {
        actions.waitForElementVisible("trello.boardsPage.boardByTeamAndName");
        actions.clickElement("trello.boardsPage.boardByTeamAndName", boardName);
    }
}
