package com.revature.steps.registration;

import com.revature.TestRunner;

import io.cucumber.java.en.When;

public class registrationCommonSteps {
    @When("the user submits the credentials")
    public void the_user_submits_the_credentials() {
        TestRunner.registrationPage.clickCreateButton();
    }
}
