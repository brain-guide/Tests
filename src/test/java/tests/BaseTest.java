package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;

public class BaseTest {
    public WebDriver browser;
    LoginPage loginPage;

    // это будет выполняться перед каждым тестовым методом.
    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        browser = new ChromeDriver(options);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginPage = new LoginPage(browser);
    }

    // это будет выполняться после  каждого  тестового метода.
    @AfterMethod
    public void close() {
        // закрытие браузера
        browser.quit();
    }
}
