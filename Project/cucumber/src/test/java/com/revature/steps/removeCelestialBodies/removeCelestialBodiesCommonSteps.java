package com.revature.steps.removeCelestialBodies;

import org.junit.rules.TestRule;

import com.revature.TestRunner;

import io.cucumber.java.en.When;

public class removeCelestialBodiesCommonSteps {
    @When("the user provides name {string}")
    public void the_user_provides_name(String string) {
        TestRunner.homePage.enterDeleteInput(string);
    }

    @When("Clicks on Delete")
    public void clicks_on_Delete() {
        TestRunner.numberOfTable = TestRunner.homePage.getNumberOfCelestialRows();
        TestRunner.homePage.clickDeleteButton();
    }
}
