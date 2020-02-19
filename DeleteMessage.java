package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class DeleteMessage extends BaseElement {
    @FindBy(xpath = ".//*[@class='llc__avatar']")
    private WebElement mark;

    @FindBy(xpath = ".//span[@class='button2__txt' and text()='Удалить']")
    private WebElement buttonDelete;


    public DeleteMessage() throws IOException {
        super();
        PageFactory.initElements(driver, this);
    }

    public void markAndDelete(){
        mark.click();
        buttonDelete.click();
    }

}
