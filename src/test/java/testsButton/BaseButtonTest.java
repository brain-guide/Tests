package testsButton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseButtonTest {
    public WebDriver browser;

    // это будет выполняться перед каждым тестовым методом.
    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browser = new ChromeDriver(options);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // это будет выполняться после  каждого  тестового метода.
    @AfterMethod
    public void close() {
        // закрытие браузера
        browser.quit();
    }
}
