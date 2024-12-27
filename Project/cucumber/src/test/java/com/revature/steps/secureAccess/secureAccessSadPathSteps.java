package com.revature.steps.secureAccess;

import org.junit.Assert;

import com.revature.TestRunner;

import io.cucumber.java.en.Then;

public class secureAccessSadPathSteps {
   @Then("the user should stay on the login page")
    public void the_user_should_stay_on_the_login_page() {
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    } 
}
