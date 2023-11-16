package com.saucedemo.utility;

import com.saucedemo.page.CartPage;
import com.saucedemo.page.HomePage;
import com.saucedemo.page.LoginPage;
import com.saucedemo.page.ProductDetailPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver;
    protected static LoginPage loginPage;
    protected static HomePage homePage;
    protected static CartPage cartPage;
    protected static ProductDetailPage productDetailPage;

    protected void getDriverAndPage(){
        WebDriver driver =  new ChromeDriver();
        this.loginPage = new LoginPage(driver);
        this.homePage = new HomePage(driver);
        this.cartPage = new CartPage(driver);
        this.productDetailPage = new ProductDetailPage(driver);
        this.driver = driver;
    }

}
