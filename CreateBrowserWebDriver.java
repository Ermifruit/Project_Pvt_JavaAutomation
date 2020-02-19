package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class CreateBrowserWebDriver {
    private static final ReadProperties readProperties = new ReadProperties();
    private static final String chrome = "Chrome";
    private static final File resourceDirectory = new File("src/main/resources");
    private static WebDriver drivers;
    private static CreateBrowserWebDriver instance;

    private CreateBrowserWebDriver() throws IOException {
        if (readProperties.getConfigProperty("nameBrowser").equals(chrome)) {
            System.setProperty("webdriver.chrome.driver", resourceDirectory.getPath() + readProperties.getConfigProperty("chromeDriverPath"));
            drivers = new ChromeDriver();
        }
    }

    public static CreateBrowserWebDriver getInstance() throws IOException {
        CreateBrowserWebDriver localInstance = instance;
        if (localInstance == null) {
            synchronized (CreateBrowserWebDriver.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new CreateBrowserWebDriver();
                }
            }
        }
        return localInstance;
    }


    public static WebDriver getDrivers() {
        return drivers;
    }


    public void quitDriver(){
        drivers.quit();
    }

}
