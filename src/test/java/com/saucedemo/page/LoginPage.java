package com.saucedemo.page;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginPage {
    WebDriver driver;
    By inputTextUsername = By.id("user-name");
    By inputTextPassword = By.id("password");
    By buttonLogin = By.id("login-button");
    By alertError = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    By formGroups = By.className("form_group");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void inputUsername(String username){
        driver.findElement(inputTextUsername).sendKeys(username);
    }

    public void inputPassword(String password){
        driver.findElement(inputTextPassword).sendKeys(password);
    }

    public void clickButtonLogin(){
        driver.findElement(buttonLogin).click();
    }

    public void loginWithValidUsername(){
        inputUsername("standard_user");
        inputPassword("secret_sauce");
        clickButtonLogin();
    }

    public void assertAlertErrorMessage(String message){
        String errorMessage = driver.findElement(alertError).getText();
        Assertions.assertEquals(message,errorMessage);
        assertIconErrorFormGroupShow();
    }

    public void assertIconErrorFormGroupShow(){
        int totalIconError = 0;
        List<WebElement> listForm = driver.findElements(formGroups);
        for(WebElement element : listForm){
            if(element.findElement(By.tagName("svg")).isDisplayed())
                totalIconError++;
        }
        System.out.println("totalIconError = "+totalIconError);
        Assertions.assertEquals(totalIconError,2);
    }


}
