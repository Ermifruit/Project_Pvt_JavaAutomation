package tests;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.DeleteMessage;
import pages.LogIn;

import java.io.IOException;

public class DeleteMessageTest extends BaseTest {
    DeleteMessage deleteMessage = new DeleteMessage();
    LogIn logIn = new LogIn();

    public DeleteMessageTest() throws IOException {
    }

    @BeforeTest
    public void beforeTest() throws InterruptedException {
        logIn.enterLogin(login);
        logIn.clickEnterButton();
        logIn.enterPass(password);
        logIn.clickEnterButton();
        logger.info("===========opened the browser, went to the mail.ru website and logged in===========");
        Thread.sleep(10000);
    }
    @Test
    public void sendingAMessageToAGroupOfUsers() {
        logger.info("===========Mark and delete some letters===========");
        deleteMessage.markAndDelete();
    }
}