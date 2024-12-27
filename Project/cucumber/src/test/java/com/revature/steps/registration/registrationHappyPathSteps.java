package com.revature.steps.registration;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.TestRunner;

import io.cucumber.java.en.Then;

public class registrationHappyPathSteps {
    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Account Creation")));
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }
}
