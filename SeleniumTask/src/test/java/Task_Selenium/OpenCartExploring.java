package Task_Selenium;

import org.hamcrest.MatcherAssert;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Task_Selenium.Helper.*;
import static org.hamcrest.CoreMatchers.is;

public class OpenCartExploring {
    private static WebDriver driver;
    private static WebDriverWait driverWait;

    @BeforeClass
    public static void beforeTestsBegin() {
        System.setProperty("webdriver.chrome.driver", DRIVER_LOCATION);
        driver = Driver.getInstance().getWebDriver();
        driverWait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/");

    }

    @Before
    public void doBeforeTest() {
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(PageElements.DROP_DOWN_HEADER)));
        driver.findElement(PageElements.DROP_DOWN_HEADER).click();
        driver.findElement(PageElements.DROP_DOWN_HEADER_LOGIN).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(PageElements.LOGIN_BUTTON));
        driver.findElement(PageElements.EMAIL_ADDRESS).sendKeys(CREDENTIALS);
        driver.findElement(PageElements.PASSWORD).sendKeys(CREDENTIALS);
        driver.findElement(PageElements.LOGIN_BUTTON).click();
    }

    @After
    public void afterTest() {
        driver.findElement(PageElements.HOME_PAGE).click();
        driver.findElement(PageElements.DROP_DOWN_HEADER).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(PageElements.DROP_DOWN_HEADER_LOGOUT));
        driver.findElement(PageElements.DROP_DOWN_HEADER_LOGOUT).click();
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public static void afterClass() {
        driver.quit();
    }

    @Test
    public void loginSearchProductAndAddToCart() throws InterruptedException {
        driverWait.until(ExpectedConditions.elementToBeClickable(PageElements.SEARCH_FIELD));
        driver.findElement(PageElements.SEARCH_FIELD).sendKeys("Mac");
        driver.findElement(PageElements.SEARCH_BUTTON).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(PageElements.ADD_TO_CART_BUTTON));
        driver.findElement(PageElements.ADD_TO_CART_BUTTON).click();
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(PageElements.CART_BUTTON)));
        MatcherAssert.assertThat("Assert that cart has product", PageElements.CART_HAS_PRODUCT, is(PageElements.CART_HAS_PRODUCT));
        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
    }


    @Test
    public void loginSearchProductAddToCartAndRemove() throws InterruptedException {
        driverWait.until(ExpectedConditions.elementToBeClickable(PageElements.SEARCH_FIELD));
        driver.findElement(PageElements.SEARCH_FIELD).sendKeys("Mac");
        driver.findElement(PageElements.SEARCH_BUTTON).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(PageElements.ADD_TO_CART_BUTTON));
        driver.findElement(PageElements.ADD_TO_CART_BUTTON).click();
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(PageElements.CART_BUTTON)));
        MatcherAssert.assertThat("Assert that cart has product", PageElements.CART_HAS_PRODUCT, is(PageElements.CART_HAS_PRODUCT));
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(PageElements.CART_BUTTON)));
        Thread.sleep(2000);
        driver.findElement(PageElements.CART_BUTTON).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(PageElements.REMOVE_BUTTON));
        driver.findElement(PageElements.REMOVE_BUTTON).click();
        MatcherAssert.assertThat("Assert that cart is empty", PageElements.CART_IS_EMPTY, is(PageElements.CART_IS_EMPTY));
    }

    @Test
    public void loginAddMultipleProductsRemoveOne() {
        driverWait.until(ExpectedConditions.elementToBeClickable(PageElements.SEARCH_FIELD));
        driver.findElement(PageElements.SEARCH_FIELD).sendKeys("Ipod");
        driver.findElement(PageElements.SEARCH_BUTTON).click();
        driverWait.until(ExpectedConditions.elementToBeClickable(PageElements.ADD_TO_CART_BUTTON));
        driver.findElement(PageElements.ADD_TO_CART_PRODUCT).click();
        driver.findElement(PageElements.SEARCH_FIELD).clear();
        driver.findElement(PageElements.SEARCH_FIELD).sendKeys("Mac");
        driver.findElement(PageElements.SEARCH_BUTTON).click();
        driver.findElement(PageElements.ADD_TO_CART_PRODUCT).click();
        driverWait.until(ExpectedConditions.visibilityOf(driver.findElement(PageElements.CART_BUTTON))).click();
        MatcherAssert.assertThat("Assert that cart has product", PageElements.CART_HAS_PRODUCT, is(PageElements.CART_HAS_PRODUCT));
        driverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(PageElements.CART_BUTTON)));
        driver.findElement(PageElements.CART_BUTTON).click();
        driver.findElement(PageElements.REMOVE_BUTTON).click();
        String actualString = driver.findElement(PageElements.CART_ELEMENT).getText();
        String expectedString = "iPod";
        Assert.assertFalse(actualString.contains(expectedString));
    }
}

