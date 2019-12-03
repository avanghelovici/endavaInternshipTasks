package Task_Selenium;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static Task_Selenium.OpenCartExploring.driver;

import java.util.concurrent.TimeUnit;

public class Helper {

    static final String CREDENTIALS = "artur.test@test.com";
    static final String DRIVER_LOCATION = "src/main/resources/chromedriver.exe";

    static final Wait waiter = new FluentWait<>(driver)
            .withTimeout(10, TimeUnit.SECONDS)
            .pollingEvery(2, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
}