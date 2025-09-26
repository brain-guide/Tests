package shop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginShopPage extends BasePage {

    public LoginShopPage(WebDriver driver) {
        super(driver);
    }

    // константа, не изменна, если есть эти три слова
    private static final By USERNAME_INPUT = By.xpath("//input[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//input[@id='login-button']");
    private static final By ERROR = By.xpath("//*[@data-test='error']");

    public void open() {
        driver.get(BASE_URL);
    }

    public void loginWithUsername(String userName) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName); // логин
    }

    public void loginWithPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);  //пароль
        driver.findElement(LOGIN_BUTTON).click(); //кнопка Логин для подтверждения
    }

    public String checkErrorMsg() {
        return driver.findElement(ERROR).getText();
    }
}
