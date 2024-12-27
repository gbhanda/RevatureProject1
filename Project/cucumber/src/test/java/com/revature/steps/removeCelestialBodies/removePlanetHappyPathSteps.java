package com.revature.steps.removeCelestialBodies;

import org.junit.Assert;

import com.revature.TestRunner;

import io.cucumber.java.en.Then;

public class removePlanetHappyPathSteps {
    @Then("the planet {string} is off the table")
    public void the_planet_is_off_the_table(String string) {
        Assert.assertTrue(TestRunner.homePage.checkIfaPlanetIsDeleted(string)); 
    }

    @Then("no moon with owner {string} is present in the table")
    public void no_moon_with_owner_is_present_in_the_table(String string) {
        Assert.assertTrue(TestRunner.homePage.checkIfaPlanetsMoonIsDeleted(string)); 
    }
}
