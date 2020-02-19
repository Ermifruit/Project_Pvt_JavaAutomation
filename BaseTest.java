package base;

import pages.BaseElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest extends BaseElement {

    public BaseTest() throws IOException {
    }

    @BeforeTest
    public void startTest() throws IOException {
        logger.info(String.format("===========Start the test on %s===========", readProperties.getConfigProperty("nameBrowser")));
        long implicitTimeOut = Long.parseLong(readProperties.getConfigProperty("implicitTimeOut"));
        driver.manage().timeouts().implicitlyWait(implicitTimeOut, SECONDS);
        driver.manage().window().maximize();
        driver.get(projectUrl);
    }

    @AfterTest
    public void finishTest() throws IOException {
    createBrowserWebDriver.quitDriver();
    logger.info(String.format("===========Finish Test on %s===========", readProperties.getConfigProperty("nameBrowser")));
    }
}

