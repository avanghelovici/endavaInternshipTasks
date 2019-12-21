package Task_Selenium;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartSection {
    @FindBy(xpath = "/html/body/header/div/div/div[3]/div/button")
    private WebElement cartButton;
    @FindBy(xpath = "//div/div[2]/div[2]/button[1]")
    private WebElement addToCart;
    @FindBy(xpath = "/html/body/header/div/div/div[3]/div/ul/li[2]/div/p/a[2]/strong")
    private WebElement hasProduct;
    @FindBy(xpath = "/html/body/header/div/div/div[3]/div/ul/li[1]/table/tbody/tr/td[5]/button/i")
    private WebElement removeButton;
    @FindBy(xpath = "/html/body/header/div/div/div[3]/div/ul/li/p")
    private WebElement isEmpty;
    @FindBy(xpath = "/html/body/header/div/div/div[3]/div/ul")
    private WebElement cartElementForAssert;


    WebElement getCartButton() {
        return cartButton;
    }

    WebElement getAddToCart() {
        return addToCart;
    }

    WebElement getHasProduct() {
        return hasProduct;
    }

    WebElement getRemoveButton() {
        return removeButton;
    }

    WebElement getIsEmpty() {
        return isEmpty;
    }

    WebElement getCartElementForAssert() {
        return cartElementForAssert;
    }
}
