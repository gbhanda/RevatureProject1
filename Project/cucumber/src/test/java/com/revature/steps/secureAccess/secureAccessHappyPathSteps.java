package com.revature.steps.secureAccess;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.TestRunner;

import io.cucumber.java.en.Then;

public class secureAccessHappyPathSteps {
    @Then("the user should get access to the Planetarium Homepage")
    public void the_user_should_get_access_to_the_Planetarium_Homepage() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Planetarium Login")));
        Assert.assertEquals("Home", TestRunner.driver.getTitle());
    }
}
