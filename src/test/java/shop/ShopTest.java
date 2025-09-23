package shop;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.*;

public class ShopTest extends BaseShopTest {
    @Test
    public void checkLoginShop() throws InterruptedException {
        // ввод корректных данных
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(5));
        shopPage.open();
        shopPage.loginWithUsername("standard_user");
        shopPage.loginWithPassword("secret_sauce");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='title']")));
        boolean IsPresent = browser.findElement(By.xpath("//span[@class='title']")).isDisplayed();
        assertTrue(IsPresent);
    }

    @Test
    public void checkWrongPasswordShop() throws InterruptedException {
        // ввод Некорректного пароля
        shopPage.open();
        shopPage.loginWithUsername("standard_user");
        shopPage.loginWithPassword("111");
        String errorMsg = browser.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and')]")).getText();
        assertEquals(errorMsg, "Epic sadface: Username and password do not match any user in this service");
    }
}
