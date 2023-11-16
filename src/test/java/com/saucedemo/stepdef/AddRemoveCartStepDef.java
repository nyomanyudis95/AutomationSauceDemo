package com.saucedemo.stepdef;

import com.saucedemo.dataSchema.DetailItemSchema;
import com.saucedemo.utility.BaseTest;
import com.saucedemo.utility.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.ObjectInputFilter;

public class AddRemoveCartStepDef extends BaseTest {
    DetailItemSchema firstItem;
    @Given("User is already login")
    public void userIsAlreadyLogin() {
        driver.get(Configuration.baseURL);
        loginPage.loginWithValidUsername();
    }

    @When("user click add cart in first item")
    public void userClickAddCartInFirstItem() {
        homePage.clickButtonAddOrRemoveCart();
        firstItem = homePage.getDetailFirstItem();
    }

    @Then("assert button in first item change to remove")
    public void assertButtonInFirstItemChangeToRemove() {
        homePage.assertBtnFirstItemText("Remove");
    }



    @And("assert firstItem in Cart Page")
    public void assertFirstItemInCartPage() {
        driver.get(Configuration.baseURL+Configuration.urlCart);
        cartPage.assertFirstItem(firstItem);
    }

    @And("assert button Cart in selected Product Detail is change to remove")
    public void assertButtonCartInSelectedProductDetailIsChangeToRemove() {
        driver.get(Configuration.baseURL+Configuration.urlProductDetail+"?id="+firstItem.getId());
        productDetailPage.assertBtnItemText("Remove");
    }

    @And("assert counterTotalCart to one")
    public void assertCounterTotalCartToOne() {
        driver.get(Configuration.baseURL+Configuration.urlHomePage);
        homePage.assertCounterCart(1);
        driver.get(Configuration.baseURL+Configuration.urlCart);
        cartPage.assertCounterCart(1);
        driver.get(Configuration.baseURL+Configuration.urlProductDetail+"?id="+firstItem.getId());
        productDetailPage.assertCounterCart(1);
    }

    @When("user click remove cart in first item")
    public void userClickRemoveCartInFirstItem() {
        firstItem = homePage.getDetailFirstItem();
       homePage.clickButtonAddOrRemoveCart();
    }

    @Then("assert button in first item change to add to Cart")
    public void assertButtonInFirstItemChangeToAddToCart() {
        homePage.assertBtnFirstItemText("Add to cart");
    }

    @And("assert counterTotalCart to zero")
    public void assertCounterTotalCartToZero() {
        driver.get(Configuration.baseURL+Configuration.urlHomePage);
        homePage.assertCounterCart(0);
        driver.get(Configuration.baseURL+Configuration.urlCart);
        cartPage.assertCounterCart(0);
        driver.get(Configuration.baseURL+Configuration.urlProductDetail+"?id="+firstItem.getId());
        productDetailPage.assertCounterCart(0);
    }

    @And("assert no item in Cart Page")
    public void assertNoItemInCartPage() {
        driver.get(Configuration.baseURL+Configuration.urlCart);
        cartPage.assertListItemEmpty();
    }

    @And("assert button Cart in selected Product Detail is change to add to cart")
    public void assertButtonCartInSelectedProductDetailIsChangeToAddToCart() {
        driver.get(Configuration.baseURL+Configuration.urlProductDetail+"?id="+firstItem.getId());
        productDetailPage.assertBtnItemText("Add to cart");
    }

    @When("user click item name in first item")
    public void userClickItemNameInFirstItem() {
       firstItem = homePage.getDetailFirstItem();
       homePage.clickNameFirstItem();
    }

    @And("user click button Add to cart in Product Detail")
    public void userClickButtonAddToCartInProductDetail() {
        productDetailPage.clickBtnAddToCartOrRemove();
    }

    @Then("assert button text in Product Detail And Home Page First Item is Remove")
    public void assertButtonTextInProductDetailHomePageAndCartPageIsRemove() {
        driver.get(Configuration.baseURL+Configuration.urlProductDetail+"?id="+firstItem.getId());
        productDetailPage.assertBtnItemText("Remove");
        driver.get(Configuration.baseURL+Configuration.urlHomePage);
        homePage.assertBtnFirstItemText("Remove");
    }

    @And("user click button Remove to cart in Product Detail")
    public void userClickButtonRemoveToCartInProductDetail() {
        productDetailPage.clickBtnAddToCartOrRemove();
    }

    @Then("assert button text in Product Detail And Home Page First Item is Add to cart")
    public void assertButtonTextInProductDetailAndHomePageFirstItemIsAddToCart() {
    }
}
