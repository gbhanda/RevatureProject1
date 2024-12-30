package com.revature.steps.createCelestialBodies;

import com.revature.TestRunner;

import io.cucumber.java.en.When;

public class createMoonCommonSteps {
    @When("the user provides moon name {string}")
    public void the_user_provides_moon_name(String string) {
        TestRunner.homePage.enterMoonName(string);
    }

    @When("the user provides planet Id {int}")
    public void the_user_provides_planet_Id(Integer int1) {
        TestRunner.homePage.enterOrbittedPlanetId(int1);
    }

    @When("the user provides moon image {string} file")
    public void the_user_provides_moon_image_file(String string) {
        if(!string.equals("null")){
            TestRunner.homePage.enterMoonImagePath(string);;
        }
    }

    @When("Submits the moon name")
    public void submits_the_moon_name() {
        TestRunner.numberOfTable = TestRunner.homePage.getNumberOfCelestialRows();
        TestRunner.homePage.clickSubmitButton();
        TestRunner.implicitlyWaitForSeconds(1);
    }
}
