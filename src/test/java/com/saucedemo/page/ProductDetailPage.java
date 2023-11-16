package com.saucedemo.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {
    WebDriver driver;
    By itemName = By.className("inventory_details_name");
    By itemDesc = By.className("inventory_details_desc");
    By itemPrice = By.className("inventory_details_price");
    By counterTotalCart = By.className("shopping_cart_badge");
    By btnItem = By.className("btn_inventory");

    public ProductDetailPage(WebDriver driver){
        this.driver = driver;
    }

    public void assertBtnItemText(String text){
        String txtBtn = driver.findElement(btnItem).getText();
        Assertions.assertEquals(txtBtn,text);
    }

    public void clickBtnAddToCartOrRemove(){
        driver.findElement(btnItem).click();
    }

    public void assertCounterCart(int total){
        if(driver.findElements(counterTotalCart).size() > 0){
            WebElement counterTotalCartElement = driver.findElement(counterTotalCart);
            Assertions.assertEquals(true,counterTotalCartElement.isDisplayed());
            Assertions.assertEquals(total,Integer.parseInt(counterTotalCartElement.getText()));
        }
        else{
            Assertions.assertEquals(0,driver.findElements(counterTotalCart).size());
        }
    }
}
