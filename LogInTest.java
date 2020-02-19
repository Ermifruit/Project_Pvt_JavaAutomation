package tests;

import base.BaseTest;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogIn;

import java.io.IOException;

public class LogInTest extends BaseTest {
    LogIn logIn = new LogIn();

    public LogInTest() throws IOException {
    }

    @Test
    public void loginTest() throws InterruptedException {
        logIn.enterLogin(login);
        logger.info("===========Enter Email===========");
        logIn.clickEnterButton();
        logger.info("===========Click next button===========");
        logIn.enterPass(password);
        logger.info("===========Enter Password===========");
        logIn.clickEnterButton();
        logger.info("===========Click Enter===========");
        Thread.sleep(Long.parseLong("7000"));
        logger.info("===========Wait 7 seconds===========");
        Assert.assertTrue(logIn.loginСheckPresents());
        logger.info("===========All is good===========");

    }
}