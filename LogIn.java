package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class LogIn extends BaseElement {
    @FindBy(name = "login")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@value='Ввести пароль']")
    private WebElement submit;

    @FindBy(xpath = ".//input[@value=\"Ввести пароль\"]")
    private WebElement buttonEnter;

    @FindBy(xpath = ".//span[@class='compose-button__txt']")
    private WebElement loginСheck;


    public LogIn() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void enterLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void enterPass(String password) {
        emailField.sendKeys(password);
    }

    public void clickEnterButton() {
        buttonEnter.click();
    }

    public boolean loginСheckPresents() {
        return loginСheck.isDisplayed();
    }
}
