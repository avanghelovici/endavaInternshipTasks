package Task_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = "//div[2]/div/form/input")
    private WebElement loginButton;
    @FindBy(xpath = "//div/div[2]/div/form/div[1]/input")
    private WebElement email;
    @FindBy(xpath = "//div/div/div[2]/div/form/div[2]/input")
    private WebElement pass;

    WebElement getPass() {
        return pass;
    }

    WebElement getEmail() {
        return email;
    }

    WebElement getLoginButton() {
        return loginButton;
    }
}
