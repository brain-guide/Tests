package shop.shopTests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import shop.parent.BaseShopTest;

import static org.testng.Assert.*;

public class ShopTest extends BaseShopTest {
    @Test
    public void checkLoginShop() throws InterruptedException {
        // ввод корректных данных
        loginShopPage.open();
        loginShopPage.loginWithUsername("standard_user");
        loginShopPage.loginWithPassword("secret_sauce");
        productsPage.addToCart("Test.allTheThings() T-Shirt (Red)");
        assertTrue(productsPage.isTitlePresent());
        assertEquals(productsPage.getTitle(), "Products", "названия не совпадают");
    }

    @Test
    public void checkBlockedUserShop() {
        // ввод заблокированного пользователя
        loginShopPage.open();
        loginShopPage.loginWithUsername("locked_out_user");
        loginShopPage.loginWithPassword("secret_sauce");
        assertEquals(loginShopPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void checkNoPassword() {
        // ввод заблокированного пользователя
        loginShopPage.open();
        loginShopPage.loginWithUsername("locked_out_user");
        loginShopPage.loginWithPassword("");
        assertEquals(loginShopPage.checkErrorMsg(), "Epic sadface: Password is required");
    }

    @Test
    public void checkNoLogin() {
        // ввод заблокированного пользователя
        loginShopPage.open();
        loginShopPage.loginWithUsername("");
        loginShopPage.loginWithPassword("secret_sauce");
        assertEquals(loginShopPage.checkErrorMsg(), "Epic sadface: Username is required");
    }
}
