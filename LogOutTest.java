package tests;

import base.BaseTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LogIn;
import pages.LogOut;
import java.io.IOException;


public class LogOutTest extends BaseTest {
    LogOut logOut = new LogOut();
    LogIn logIn = new LogIn();

    public LogOutTest() throws IOException {
    }

    @BeforeTest
    public void beforeTest() throws IOException, InterruptedException {
        logIn.enterLogin(login);
        logIn.clickEnterButton();
        logIn.enterPass(password);
        logIn.clickEnterButton();
        logger.info("===========opened the browser, went to the mail.ru website and logged in===========");
        Thread.sleep(10000);
    }

    @Test
    public void logOutTest() throws InterruptedException {
        logger.info("===========Wait 5 seconds===========");
        Thread.sleep(5000);
        logger.info("===========Click Enter===========");
        logOut.clickButtonOut();
        logger.info("===========Click out button===========");
        logger.info("===========Wait 5 seconds===========");
        Thread.sleep(5000);
        Assert.assertTrue(logOut.isMainPage());
        logger.info("===========All is good===========");

    }
}