package com.revature.steps.createCelestialBodies;

import com.revature.TestRunner;

import io.cucumber.java.en.When;
public class createPlanetCommonSteps {
        @When("the user provides planet name {string}")
        public void the_user_provides_planet_name(String string) {
            TestRunner.homePage.enterPlanetName(string);
        }

        @When("the user provides planet image {string} file")
        public void the_user_provides_planet_image_file(String string) {
            if(!string.equals("null")){
                TestRunner.homePage.enterPlanetImagePath(string);
            }
        }

        @When("Submits the planet name")
        public void submits_the_planet_name() {
            TestRunner.numberOfTable = TestRunner.homePage.getNumberOfCelestialRows();
            TestRunner.homePage.clickSubmitButton();
            TestRunner.implicitlyWaitForSeconds(1);
        }
    }