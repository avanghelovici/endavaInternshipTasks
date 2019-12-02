package Task_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralPage {

    @FindBy(xpath = "//ul/li[2]/a");
    private WebElement headerDropDown;
}
