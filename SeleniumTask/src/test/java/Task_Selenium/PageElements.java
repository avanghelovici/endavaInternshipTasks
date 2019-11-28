package Task_Selenium;

import org.openqa.selenium.By;

public class PageElements {
    public static final By DROP_DOWN_HEADER = By.xpath("//ul/li[2]/a");
    public static final By DROP_DOWN_HEADER_LOGIN = By.xpath("//ul/li[2]/ul/li[2]/a");
    public static final By DROP_DOWN_HEADER_LOGOUT = By.xpath("/html/body/nav/div/div[2]/ul/li[2]/ul/li[5]/a");
    public static final By LOGIN_BUTTON = By.xpath("//div[2]/div/form/input");
    public static final By EMAIL_ADDRESS = By.xpath("//div/div[2]/div/form/div[1]/input");
    public static final By PASSWORD = By.xpath("//div/div/div[2]/div/form/div[2]/input");
    public static final By SEARCH_FIELD = By.xpath("//div[2]/div/input");
    public static final By SEARCH_BUTTON = By.xpath("//div/div/div[2]/div/span/button");
    public static final By CART_BUTTON = By.xpath("/html/body/header/div/div/div[3]/div/button");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//div/div[2]/div[2]/button[1]");
    public static final By CART_HAS_PRODUCT = By.xpath("/html/body/header/div/div/div[3]/div/ul/li[2]/div/p/a[2]/strong");
    public static final By REMOVE_BUTTON = By.xpath("/html/body/header/div/div/div[3]/div/ul/li[1]/table/tbody/tr/td[5]/button/i");
    public static final By CART_IS_EMPTY = By.xpath("/html/body/header/div/div/div[3]/div/ul/li/p");
    public static final By CART_ELEMENT = By.xpath("/html/body/header/div/div/div[3]/div/ul");
    public static final By HOME_PAGE = By.xpath("/html/body/header/div/div/div[1]/div/h1/a");
    public static final By ADD_TO_CART_PRODUCT = By.xpath(
            String.format("/html/body/div[2]/div/div/div[3]/div[%s]/div/div[2]/div[2]/button[1]",
                    Helper.returnsInt(Helper.RANDOM_PRODUCTS_ARRAY)));

}
