package com.revature.steps.registration;

import com.revature.TestRunner;

import io.cucumber.java.en.*;

public class registrationBackgroundSteps {

    @Given("the user is in the login page")
    public void the_user_is_in_the_login_page() {
        TestRunner.loginPage.openLoginPage();
    }

    @And("the user clicks the register link")
    public void the_user_clicks_the_register_link() {
        TestRunner.loginPage.clickRegistrationLink();
    }
}
