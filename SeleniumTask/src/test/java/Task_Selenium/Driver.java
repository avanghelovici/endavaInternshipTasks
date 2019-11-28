package Task_Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static Driver instance = null;

    private static WebDriver webDriver;

    private Driver() {
        webDriver = new ChromeDriver();
    }

    public static Driver getInstance() {
        if (instance != null) {
            return instance;
        } else {
            return new Driver();
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}

