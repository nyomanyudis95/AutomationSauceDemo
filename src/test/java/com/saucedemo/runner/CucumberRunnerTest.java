package com.saucedemo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"com.saucedemo"},
        features = {"src/test/resources/features"},
        plugin = {
                "pretty",
                "html:reports/test-report-web.html",
                "json:reports/test-report-web.json"
        },
//        tags = "@CurrentTest",
        monochrome = true
)
public class CucumberRunnerTest {
}
