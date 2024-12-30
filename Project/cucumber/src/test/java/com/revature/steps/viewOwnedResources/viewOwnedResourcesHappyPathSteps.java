package com.revature.steps.viewOwnedResources;

import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.TestRunner;

import io.cucumber.java.en.Then;

import java.time.Duration;

import org.junit.Assert;

public class viewOwnedResourcesHappyPathSteps {
    @Then("the user should see their planets and moons")
    public void the_user_should_see_their_planets_and_moons() {
        // Write code here that turns the phrase above into concrete actions
            TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
            //TestRunner.implicitlyWaitForSeconds(2);;
            Assert.assertEquals(
            String.format(
                            "Expected 'Welcome to the Home Page Batman, but got %s",
                            TestRunner.homePage.getHomePageGreeting()
                    ),
                    "Welcome to the Home Page Batman",
                    TestRunner.homePage.getHomePageGreeting());
                    TestRunner.implicitlyWaitForSeconds(2);;
            Assert.assertEquals(4, TestRunner.homePage.getNumberOfCelestialRows());
    }
}
