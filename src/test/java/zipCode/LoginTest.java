package zipCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import zipCode.pages.LoginPage;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest  extends BaseTest {
    @Test
    public void checkErrorLogin() {
        // ввод корректного числа
        loginPage.open();
        loginPage.loginThroughZip("1");
        String errorMsg = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorMsg, "Oops, error on page. ZIP code should have 5 digits");
    }

    @Test
    public void checkLogin() {
        // ввод корректного числа
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        loginPage.open();
        loginPage.loginThroughZip("12345");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sign Up']")));
        boolean IsPresent = browser.findElement(By.xpath("//*[text()='Sign Up']")).isDisplayed();
        assertTrue(IsPresent);
    }
}
