package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage {
    WebDriver browser;

    public ShopPage(WebDriver browser) {
        this.browser = browser;
    }

    // константа, не изменна, если есть эти три слова
    private static final By USERNAME_INPUT = By.xpath("//input[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//input[@id='login-button']");

    public void open() {
        browser.get("https://www.saucedemo.com/");
    }

    public void loginWithUsername(String userName) {
        browser.findElement(USERNAME_INPUT).sendKeys(userName); // логин
    }

    public void loginWithPassword(String password) {
        browser.findElement(PASSWORD_INPUT).sendKeys(password);  //пароль
        browser.findElement(LOGIN_BUTTON).click(); //кнопка Логин для подтверждения
    }
}
