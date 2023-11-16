package com.saucedemo.stepdef;

import com.saucedemo.page.LoginPage;
import com.saucedemo.utility.BaseTest;
import com.saucedemo.utility.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDef extends BaseTest {
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        driver.get(Configuration.baseURL);
    }

    @When("user input username input text with {string}")
    public void userInputUsernameInputTextWith(String username) {
        loginPage.inputUsername(username);
    }

    @And("user input password input text with {string}")
    public void userInputPasswordInputTextWith(String password) throws InterruptedException {
        loginPage.inputPassword(password);
    }

    @And("user click button login")
    public void userClickButtonLogin() {
        loginPage.clickButtonLogin();
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        String url = driver.getCurrentUrl();
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html",url);
    }


    @Then("show alert error password is required")
    public void showAlertErrorPasswordIsRequired() {
        loginPage.assertAlertErrorMessage("Epic sadface: Password is required");
    }

    @Then("show alert error username is required")
    public void showAlertErrorUsernameIsRequired() {
        loginPage.assertAlertErrorMessage("Epic sadface: Username is required");
    }

    @Then("show alert error username and password dont match")
    public void showAlertErrorUsernameAndPasswordDontMatch() {
        loginPage.assertAlertErrorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @Then("show alert error user has been locked out")
    public void showAlertErrorUserHasBeenLockedOut() {
        loginPage.assertAlertErrorMessage("Epic sadface: Sorry, this user has been locked out.");
    }
}
