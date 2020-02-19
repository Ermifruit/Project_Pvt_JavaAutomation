package pages;

import com.google.common.base.Function;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import utils.CreateBrowserWebDriver;
import utils.ReadProperties;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseElement {

    public CreateBrowserWebDriver createBrowserWebDriver = CreateBrowserWebDriver.getInstance();
    public ReadProperties readProperties = new ReadProperties();
    public String projectUrl = readProperties.getConfigProperty("projectUrl");
    public String login = readProperties.getConfigProperty("login");
    public String password = readProperties.getConfigProperty("password");
    public Logger logger = Logger.getLogger(this.getClass().getName());
    public SoftAssert softAssert = new SoftAssert();
    public WebDriver driver ;
    public File resourcesDirectory = new File("src/test/resources");

    public BaseElement() throws IOException {
        this.driver = createBrowserWebDriver.getDrivers();
    }


    public void fluentWait(WebElement element) throws IOException {
        long fluentTimeOutFullSecond = Long.parseLong(readProperties.getConfigProperty("fluentTimeOutFullSecond"));
        long fluentTimeOutPeriodMilliseconds = Long.parseLong(readProperties.getConfigProperty("fluentTimeOutPeriodMilliseconds"));
        Wait<WebElement> fluentWait = new FluentWait<WebElement>(element).
                withTimeout(fluentTimeOutFullSecond, TimeUnit.SECONDS).
                pollingEvery(fluentTimeOutPeriodMilliseconds, TimeUnit.MILLISECONDS);
        fluentWait.until(new Function<WebElement, Boolean>() {
                             @Override
                             public Boolean apply(WebElement element) {
                                 return element.isDisplayed();
                             }
                         }
        );
    }

    public void expliciteWait(WebElement element) throws IOException {
        Long explicitTimeOut = Long.parseLong(readProperties.getConfigProperty("explicitTimeOut"));
        WebDriverWait wait = new WebDriverWait(driver, explicitTimeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    public void threadSleep() throws IOException, InterruptedException {
        Long threadSleep = Long.parseLong(readProperties.getConfigProperty("threadSleep"));
        Thread.sleep(threadSleep);
    }


}
