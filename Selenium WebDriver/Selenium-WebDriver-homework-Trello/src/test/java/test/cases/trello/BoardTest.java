package test.cases.trello;

import com.telerikacademy.testframework.UserActions;
import org.junit.AfterClass;
import pages.trello.BoardPage;
import pages.trello.BoardsDeletePage;
import pages.trello.BoardsPage;

import org.junit.Test;

public class BoardTest extends BaseTest {

    public static final String CARD_NAME = "My first card";
    public static final String FIRST_LIST = "To move from";
    public static final String SECOND_LIST = "To be moved";

    @Test
    public void createBoardWhenCreateBoardClicked() {

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());
        boardPage.assertAddListExists();
        BoardsDeletePage boardsDeletePage = new BoardsDeletePage(actions.getDriver());
        boardsDeletePage.closeAndDeleteBoard();
    }


    @Test
    public void createNewCardInExistingBoardWhenCreateCardClicked() {

        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());

        boardPage.createList(FIRST_LIST);
        boardPage.assertListExists(FIRST_LIST);

        boardPage.addCardToList(CARD_NAME, FIRST_LIST);
        boardPage.assertCardExistInList(FIRST_LIST, CARD_NAME);


        BoardsDeletePage boardsDeletePage = new BoardsDeletePage(actions.getDriver());
        boardsDeletePage.closeAndDeleteBoard();
    }


    @Test
    public void moveCardBetweenStatesWhenDragAndDropIsUsed() {
        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardPage boardPage = new BoardPage(actions.getDriver());

        boardPage.createList(FIRST_LIST);
        boardPage.assertListExists(FIRST_LIST);

        boardPage.addCardToList(CARD_NAME, FIRST_LIST);

        boardPage.createList(SECOND_LIST);
        boardPage.assertListExists(SECOND_LIST);

        boardPage.moveCardToList(CARD_NAME, SECOND_LIST);

        boardPage.assertCardIsNotInList(FIRST_LIST, CARD_NAME);
        boardPage.assertCardExistInList(SECOND_LIST, CARD_NAME);

        BoardsDeletePage boardsDeletePage = new BoardsDeletePage(actions.getDriver());
        boardsDeletePage.closeAndDeleteBoard();
    }


    @Test
    public void deleteBoardWhenDeleteButtonIsClicked() {
        BoardsPage boardsPage = new BoardsPage(actions.getDriver());
        boardsPage.createBoard();

        BoardsDeletePage boardsDeletePage = new BoardsDeletePage(actions.getDriver());
        boardsDeletePage.closeAndDeleteBoard();
    }

    @AfterClass
    public static void tearDown() {
        UserActions.quitDriver();
    }
}
