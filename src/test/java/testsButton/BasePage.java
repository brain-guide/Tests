package testsButton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver browser;
    WebDriverWait wait;

    public static final String BASE_URL = "https://the-internet.herokuapp.com/add_remove_elements/";

    public BasePage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, Duration.ofSeconds(5));
    }
}
