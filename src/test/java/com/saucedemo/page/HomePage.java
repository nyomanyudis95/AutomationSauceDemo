package com.saucedemo.page;

import com.saucedemo.dataSchema.DetailItemSchema;
import com.saucedemo.utility.SortingItemOption;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    WebDriver driver;
    By listInventoryItem = By.className("inventory_item");
    By counterTotalCart = By.className("shopping_cart_badge");
    By linkCart = By.className("shopping_cart_link");
    By selectOrderItem = By.className("product_sort_container");

    // =  Selector that inside  container Item ====
    By inventoryItemDescription = By.className("inventory_item_description");
    // ==  Selecter that inside inventoryItemDescription ====
    By priceBar = By.className("pricebar");
    By inventoryItemLabel = By.className("inventory_item_label");
    By itemTitle = By.className("inventory_item_name");
    By itemDescription = By.className("inventory_item_desc");
    By itemPrice = By.className("inventory_item_price");
    // ==  Selecter that display in inventoryItemDescription ====
    // =  Selector that display in container Item ====


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getFirstItem() {
        return driver.findElements(listInventoryItem).get(0);
    }

    public WebElement getBtnCartFirstItem(){
        return getFirstItem().findElement(inventoryItemDescription)
                .findElement(priceBar)
                .findElement(By.tagName("button"));
    }

    public WebElement getNameLinkFirstItem(){
        return getFirstItem().findElement(inventoryItemLabel).findElement(By.tagName("a"));
    }

    public void clickNameFirstItem(){
        getNameLinkFirstItem().click();
    }

    public void clickButtonAddOrRemoveCart(){
        getBtnCartFirstItem().click();
    }

    public DetailItemSchema getDetailFirstItem(){
        String idString = getFirstItem().findElement(inventoryItemLabel).findElement(By.tagName("a")).getAttribute("id");
        int id = Integer.parseInt(idString.split("_")[1]);
        String title = getFirstItem().findElement(itemTitle).getText();
        String description = getFirstItem().findElement(itemDescription).getText();
        String price = getFirstItem().findElement(itemPrice).getText();

        DetailItemSchema item = new DetailItemSchema(id,title,description,price);
        return item;
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

    public void assertBtnFirstItemText(String text){
        Assertions.assertEquals(text,getBtnCartFirstItem().getText());
    }

    public void selectSortItem(String option){
       WebElement selectOrder = driver.findElement(selectOrderItem);
        Select select = new Select(selectOrder);
        select.selectByValue(option);
    }

    public void assertSortItem(String option){
        switch (option){
            case "az":{
                List<WebElement> nameElements = driver.findElements(itemTitle);
                boolean isSort = true;
                WebElement prevElement = null;
                for(WebElement element: nameElements){
                    if(prevElement == null){
                        prevElement = element;
                    }
                    else{
                        String prevText = prevElement.getText();
                        String currentText = element.getText();
                        if(prevText.compareTo(currentText) > 0){
                            isSort = false;
                            break;
                        }
                        prevElement = element;
                    }
                }
                Assertions.assertEquals(true,isSort);
                break;
            }
            case "za":{
                List<WebElement> nameElements = driver.findElements(itemTitle);
                boolean isSort = true;
                WebElement prevElement = null;
                for(WebElement element: nameElements){
                    if(prevElement == null){
                        prevElement = element;
                    }
                    else{
                        String prevText = prevElement.getText();
                        String currentText = element.getText();
                        if(prevText.compareTo(currentText) < 0){
                            isSort = false;
                            break;
                        }
                        prevElement = element;
                    }
                }
                Assertions.assertEquals(true,isSort);
                break;
            }
            case "lohi":{
                List<WebElement> priceElements = driver.findElements(itemPrice);
                boolean isSort = true;
                WebElement prevElement = null;
                for(WebElement element: priceElements){
                    if(prevElement == null){
                        prevElement = element;
                    }
                    else{
                        float prevPrice = Float.parseFloat(prevElement.getText().substring(1));
                        float currentPrice = Float.parseFloat(element.getText().substring(1));
                        if(prevPrice > currentPrice){
                            isSort = false;
                            break;
                        }
                        prevElement = element;
                    }
                }
                Assertions.assertEquals(true,isSort);
                break;
            }
            case "hilo":{
                List<WebElement> priceElements = driver.findElements(itemPrice);
                boolean isSort = true;
                WebElement prevElement = null;
                for(WebElement element: priceElements){
                    if(prevElement == null){
                        prevElement = element;
                    }
                    else{
                        float prevPrice = Float.parseFloat(prevElement.getText().substring(1));
                        float currentPrice = Float.parseFloat(element.getText().substring(1));
                        if(prevPrice< currentPrice){
                            isSort = false;
                            break;
                        }
                        prevElement = element;
                    }
                }
                Assertions.assertEquals(true,isSort);
                break;
            }
        }
    }


}
