package com.revature.steps.removeCelestialBodies;

import com.revature.TestRunner;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class removeMoonHappyPathSteps {
    @Then("the moon {string} is off the table")
    public void the_moon_is_off_the_table(String string) {
        Assert.assertTrue(TestRunner.homePage.checkIfaMoonIsDeleted(string));        
    }
}
