package com.saucedemo.page;

import com.saucedemo.dataSchema.DetailItemSchema;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;
    By listItem = By.className("cart_item");
    By counterTotalCart = By.className("shopping_cart_badge");

    // = Item Container =
    By itemName = By.className("inventory_item_name");
    By itemDesc = By.className("inventory_item_desc");
    By itemPrice = By.className("inventory_item_price");

    // = Item Container =

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getFirstItemContainer(){
        return driver.findElements(listItem).get(0);
    }

    public void assertFirstItem(DetailItemSchema item){
        String name = getFirstItemContainer().findElement(itemName).getText();
        String description = getFirstItemContainer().findElement(itemDesc).getText();
        String price = getFirstItemContainer().findElement(itemPrice).getText();

        Assertions.assertEquals(item.getName(), name);
        Assertions.assertEquals(item.getDescription(), description);
        Assertions.assertEquals(item.getPrice(), price);
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
    public void assertListItemEmpty(){
        Assertions.assertEquals(driver.findElements(listItem).isEmpty(),true);
    }
}
