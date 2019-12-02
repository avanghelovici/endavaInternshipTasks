package Task_Selenium;

import org.hamcrest.MatcherAssert;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import static Task_Selenium.Helper.*;
import static org.hamcrest.CoreMatchers.is;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class OpenCartExploring {
    static WebDriver driver;
    private GeneralPage generalPage = PageFactory.initElements(driver, GeneralPage.class);
    private LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    private CartSection cart = PageFactory.initElements(driver, CartSection.class);
    private Action action = new Action();


    @BeforeClass
    public static void beforeTestsBegin() {
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
        driver = Driver.getInstance().getWebDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

    }

    @Before
    public void doBeforeTest() {
        action.waitToBeVisible(generalPage.getHomePage());
        action.clickOn(generalPage.getHeaderDropDown());
        action.clickOn(generalPage.getHeaderDropDownLogin());
        action.waitToBeClickable(loginPage.getLoginButton());
        action.insertInto(loginPage.getEmail(), CREDENTIALS);
        action.insertInto(loginPage.getPass(), CREDENTIALS);
        action.clickOn(loginPage.getLoginButton());
    }

    @After
    public void afterTest() {
        action.clickOn(generalPage.getHomePage());
        action.clickOn(generalPage.getHeaderDropDown());
        action.waitToBeVisible(generalPage.getHeaderDropDownLogout());
        action.clickOn(generalPage.getHeaderDropDownLogout());
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @Test
    public void firstLoginSearchProductAndAddToCart() {
        action.waitToBeVisible(generalPage.getSearchField());
        action.insertInto(generalPage.getSearchField(), "Mac");
        action.clickOn(generalPage.getSearchButton());
        action.waitToBeClickable(cart.getAddToCart());
        action.clickOn(cart.getAddToCart());
        action.waitToBeClickable(cart.getCartButton());
        action.clickOn(cart.getCartButton());
        MatcherAssert.assertThat("Assert that cart has product", cart.getHasProduct(), is(cart.getHasProduct()));
        action.waitToBeClickable(generalPage.getHomePage());
    }


    @Test
    public void secondLoginSearchProductAddToCartAndRemove() {
        action.waitToBeVisible(generalPage.getSearchField());
        action.insertInto(generalPage.getSearchField(), "Mac");
        action.clickOn(generalPage.getSearchButton());
        action.waitToBeClickable(cart.getAddToCart());
        action.clickOn(cart.getAddToCart());
        action.waitToBeClickable(cart.getCartButton());
        action.clickOn(cart.getCartButton());
        MatcherAssert.assertThat("Assert that cart has product", cart.getHasProduct(), is(cart.getHasProduct()));
        action.waitToBeClickable(cart.getCartButton());
        action.waitToBeClickable(cart.getRemoveButton());
        action.clickOn(cart.getRemoveButton());
        action.waitToBeClickable(cart.getCartButton());
        action.clickOn(cart.getCartButton());
        action.waitToBeVisible(cart.getIsEmpty());
        MatcherAssert.assertThat("Assert that cart is empty", cart.getIsEmpty(), is(cart.getIsEmpty()));
    }

    @Test
    public void thirdLoginAddMultipleProductsRemoveOne() {
        action.waitToBeVisible(generalPage.getSearchField());
        action.insertInto(generalPage.getSearchField(), "Ipod");
        action.clickOn(generalPage.getSearchButton());
        action.waitToBeClickable(cart.getAddToCart());
        RandomBy.randomProduct();
        action.clearOff(generalPage.getSearchField());
        action.insertInto(generalPage.getSearchField(), "Mac");
        action.clickOn(generalPage.getSearchButton());
        RandomBy.randomProduct();
        action.waitToBeVisible(cart.getCartButton());
        action.clickOn(cart.getCartButton());
        MatcherAssert.assertThat("Assert that cart has product", cart.getHasProduct(), is(cart.getHasProduct()));
        action.waitToBeClickable(cart.getCartButton());
        action.clickOn(cart.getCartButton());
        action.clickOn(cart.getRemoveButton());
        String actualString = action.textFrom(cart.getCartElementForAssert());
        String expectedString = "iPod";
        Assert.assertFalse(actualString.contains(expectedString));
    }
}

