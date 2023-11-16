package com.saucedemo.hooks;

import com.saucedemo.utility.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks extends BaseTest {
    @Before
    public void beforeTest(){
        getDriverAndPage();
    }

    @After
    public void afterTest(){
        driver.close();
    }

}
