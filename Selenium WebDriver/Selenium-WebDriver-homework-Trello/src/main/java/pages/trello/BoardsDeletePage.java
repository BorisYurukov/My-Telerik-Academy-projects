package pages.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
public class BoardsDeletePage extends BaseTrelloPage{
    public BoardsDeletePage(WebDriver driver) {
        super(driver, "");
    }
    public void  closeAndDeleteBoard(){
        actions.waitForElementVisible("trello.deleteBoardPageDropDownButton");
        actions.clickElement("trello.deleteBoardPageDropDownButton");

        actions.waitForElementVisible("trello.deleteBoard.CloseBoardButton");
        actions.clickElement("trello.deleteBoard.CloseBoardButton");

        actions.waitForElementVisible("trello.deleteBoard.CloseBoardConfirmButton");
        actions.clickElement("trello.deleteBoard.CloseBoardConfirmButton");

        actions.waitForElementVisible("trello.deleteBoard.DeleteButton");
        actions.clickElement("trello.deleteBoard.DeleteButton");

    }
    public void  areThereAnyMoreBoards(){
        List < WebElement> Boards =driver.findElements(By.xpath("//div[@class=\"board-canvas\"]"));
        System.out.println(Boards.size());
    }
}
