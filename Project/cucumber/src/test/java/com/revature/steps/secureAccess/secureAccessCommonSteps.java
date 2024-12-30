package com.revature.steps.secureAccess;

import com.revature.TestRunner;

import io.cucumber.java.en.When;

public class secureAccessCommonSteps {
    @When("the user submits the login credentials")
    public void the_user_submits_the_login_credentials() {
        TestRunner.loginPage.clickLoginButton();
    }
}