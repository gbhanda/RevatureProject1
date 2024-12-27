package com.revature.steps.registration;

import org.junit.Assert;

import com.revature.TestRunner;

import io.cucumber.java.en.Then;

public class registrationSadPathSteps {
    @Then("the user should stay on the registration page")
    public void the_user_should_stay_on_the_registration_page() {
        Assert.assertEquals("Account Creation", TestRunner.driver.getTitle());
    }

}
