package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class LogOut extends BaseElement {

    @FindBy(xpath = ".//a[@id='PH_logoutLink']")
    private WebElement buttonOut;

    @FindBy(xpath = ".//a[@id='PH_authLink']")
    private WebElement buttonIn;


    public LogOut() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }


    public void clickButtonOut(){
        buttonOut.click();
    }

    public boolean isMainPage(){
        return buttonIn.isDisplayed();
    }
}
