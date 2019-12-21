package Task_Selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.Random;


public class Action {

    void clickOn(WebElement webElement) {
        webElement.click();
    }

    void waitToBeClickable(WebElement webElement) {
        Helper.waiter.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    void waitToBeVisible(WebElement webElement) {
        Helper.waiter.until(ExpectedConditions.visibilityOf(webElement));
    }

    void insertInto(WebElement webElement, String string) {
        webElement.sendKeys(string);
    }

    static int randomOutOf4() {
        final int[] RANDOM_PRODUCTS_ARRAY = new int[]{1, 2, 3, 4};
        int rnd = new Random().nextInt(RANDOM_PRODUCTS_ARRAY.length);
        return RANDOM_PRODUCTS_ARRAY[rnd];
    }

    void clearOff(WebElement webElement) {
        webElement.clear();
    }

    String textFrom(WebElement webElement) {
        return webElement.getText();
    }

}
