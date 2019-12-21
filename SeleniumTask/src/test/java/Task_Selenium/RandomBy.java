package Task_Selenium;


import org.openqa.selenium.By;

import static Task_Selenium.OpenCartExploring.driver;

public class RandomBy {

    static void randomProduct() {
        final By ADD_TO_CART_PRODUCT = By.xpath(
                String.format("/html/body/div[2]/div/div/div[3]/div[%s]/div/div[2]/div[2]/button[1]",
                        Action.randomOutOf4()));
        driver.findElement(ADD_TO_CART_PRODUCT).click();
    }

}
