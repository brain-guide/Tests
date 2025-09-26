package zipCode.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver browser;

    public LoginPage(WebDriver driver) {
        this.browser = driver;
    }

    // константа, не изменна, если есть эти три слова
    private static final By ZIP_INOUT = By.xpath("//*[@name='zip_code']");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@value='Continue']");

    public void open() {
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
    }

    public void loginThroughZip(String zipCode) {
        browser.findElement(ZIP_INOUT).sendKeys(zipCode);
        browser.findElement(CONTINUE_BUTTON).click(); //кнонка продолжить
    }
}
