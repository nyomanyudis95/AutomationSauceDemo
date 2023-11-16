package com.saucedemo.stepdef;

import com.saucedemo.utility.BaseTest;
import com.saucedemo.utility.SortingItemOption;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortingProductStepDef extends BaseTest {
    @When("user select sorting type to Name\\(A to Z)")
    public void userSelectSortingTypeToNameAToZ() {
        homePage.selectSortItem(SortingItemOption.ascendingNameItem);
    }

    @Then("all item display in Home Page is sort ascending base on productName")
    public void allItemDisplayInHomePageIsSortAscendingBaseOnProductName() {
        homePage.assertSortItem(SortingItemOption.ascendingNameItem);
    }

    @When("user select sorting type to Name\\(Z to A)")
    public void userSelectSortingTypeToNameZToA() {
        homePage.selectSortItem(SortingItemOption.descendingNameItem);
    }

    @Then("all item display in Home Page is sort descending base on productName")
    public void allItemDisplayInHomePageIsSortDescendingBaseOnProductName() {
        homePage.assertSortItem(SortingItemOption.descendingNameItem);
    }

    @When("user select sorting type to Price\\(low to high)")
    public void userSelectSortingTypeToPriceLowToHigh() {
        homePage.selectSortItem(SortingItemOption.ascendingPriceItem);
    }

    @Then("all item display in Home Page is sort ascending base on productPrice")
    public void allItemDisplayInHomePageIsSortAscendingBaseOnProductPrice() {
        homePage.assertSortItem(SortingItemOption.ascendingPriceItem);
    }

    @When("user select sorting type to Price\\(high to low)")
    public void userSelectSortingTypeToPriceHighToLow() {
        homePage.selectSortItem(SortingItemOption.descendingPriceItem);
    }

    @Then("all item display in Home Page is sort descending base on productPrice")
    public void allItemDisplayInHomePageIsSortDescendingBaseOnProductPrice() {
        homePage.assertSortItem(SortingItemOption.descendingPriceItem);
    }
}
