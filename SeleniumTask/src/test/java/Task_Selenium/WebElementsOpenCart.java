package Task_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebElementsOpenCart {

    @FindBy(xpath = "//ul/li[2]/a")
    public static WebElement headerDropdown;


    @FindBy(xpath = "//ul/li[2]/ul/li[2]/a")
    public static WebElement loginHeader;


    public static void clickOn(WebElement webElement) {
        webElement.click();
    }

}
