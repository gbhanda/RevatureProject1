package com.revature.steps.viewOwnedResources;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;

import com.revature.TestRunner;

public class viewOwnedResourcesSadPathSteps {

    @When("the user tries to directly access the home page")
    public void the_user_tries_to_directly_access_the_home_page() {
        Assert.assertEquals("Planetarium Login", TestRunner.driver.getTitle());
    }

    @Then("the user should be denied access")
    public void the_user_should_be_denied_access() {
        Assert.assertNotEquals("Home", TestRunner.driver.getTitle());
    }
}
