package shop.parent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import shop.pages.ProductsPage;
import shop.pages.LoginShopPage;

import java.time.Duration;

public class BaseShopTest {
    public WebDriver driver;
    protected LoginShopPage loginShopPage;
    protected ProductsPage productsPage;

    // это будет выполняться перед каждым тестовым методом.
    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--guest");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loginShopPage = new LoginShopPage(driver);
        productsPage = new ProductsPage(driver);
    }

    // это будет выполняться после  каждого  тестового метода.
    @AfterMethod
    // закрытие браузера
    public void close() {
        driver.quit();
    }
}
