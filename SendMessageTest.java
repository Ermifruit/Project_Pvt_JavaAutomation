package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LogIn;
import pages.SendMessage;

import java.io.IOException;

public class SendMessageTest extends BaseTest {
    SendMessage sendMessage = new SendMessage();

    public SendMessageTest() throws IOException {
    }

    @BeforeClass
    public void beforeTest() throws IOException, InterruptedException {
        LogIn logIn = new LogIn();
        logIn.enterLogin(login);
        logIn.clickEnterButton();
        logIn.enterPass(password);
        logIn.clickEnterButton();
        logger.info("===========opened the browser, went to the mail.ru website and logged in===========");
        Thread.sleep(10000);
    }

    @Test
    public void sendingAMessageToAGroupOfUsers() {
        sendMessage.createNewMessage();
        logger.info("===========Click button new Message===========");
        sendMessage.setDestination();
        logger.info("===========Fill in the data entry Fields===========");
        sendMessage.sendMessage();
        logger.info("===========Send message===========");
        Assert.assertTrue(sendMessage.sendMessageLink());
        logger.info("===========Checked that messages have been sent===========");
    }
}
