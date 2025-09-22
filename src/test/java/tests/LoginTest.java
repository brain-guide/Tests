package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
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

    @Test
    public void checkDeleteButton() throws InterruptedException {
        browser.get("https://the-internet.herokuapp.com/add_remove_elements/");
        browser.findElement(By.xpath("//*[text()='Add Element']")).click();
        browser.findElement(By.xpath("//*[text()='Add Element']")).click();
        Thread.sleep(6000);
        browser.findElement(By.xpath("//*[text()='Delete']")).click();
        List<WebElement> list = browser.findElements(By.xpath("//*[text()='Delete']"));
        assertEquals(list.size(), 1);
    }
}
