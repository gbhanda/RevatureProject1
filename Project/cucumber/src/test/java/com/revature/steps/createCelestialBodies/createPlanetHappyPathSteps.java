package com.revature.steps.createCelestialBodies;

import com.revature.TestRunner;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class createPlanetHappyPathSteps {

    @Then("the new planet {string} is on the table")
    public void the_new_planet_is_on_the_table(String string) {
        Assert.assertTrue(TestRunner.homePage.checkIfaPlanetIsOnTheTable(string));
    }
}
