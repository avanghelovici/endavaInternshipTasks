package Task_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralPage {

    WebElement getHeaderDropDown() {
        return headerDropDown;
    }

    WebElement getHeaderDropDownLogin() {
        return headerDropDownLogin;
    }

    WebElement getHomePage() {
        return homePage;
    }

    WebElement getHeaderDropDownLogout() {
        return headerDropDownLogout;
    }

    WebElement getSearchField() {
        return searchField;
    }

    WebElement getSearchButton() {
        return searchButton;
    }

    @FindBy(xpath = "//ul/li[2]/a")
    private WebElement headerDropDown;
    @FindBy(xpath = "//ul/li[2]/ul/li[2]/a")
    private WebElement headerDropDownLogin;
    @FindBy(xpath = "/html/body/header/div/div/div[1]/div/h1/a")
    private WebElement homePage;
    @FindBy(xpath = "/html/body/nav/div/div[2]/ul/li[2]/ul/li[5]/a")
    private WebElement headerDropDownLogout;
    @FindBy(xpath = "//div[2]/div/input")
    private WebElement searchField;
    @FindBy(xpath = "//div/div/div[2]/div/span/button")
    private WebElement searchButton;

}
