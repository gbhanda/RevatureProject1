package com.revature.steps.createCelestialBodies;

import com.revature.TestRunner;

import org.junit.Assert;
import io.cucumber.java.en.Then;

public class createMoonHappyPathSteps {
    @Then("the new moon {string} is on the table")
    public void the_new_moon_is_on_the_table(String string) {
        Assert.assertTrue(TestRunner.homePage.checkIfaMoonIsOnTheTable(string));
    }
}
