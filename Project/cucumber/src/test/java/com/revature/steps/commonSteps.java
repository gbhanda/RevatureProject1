package com.revature.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.revature.TestRunner;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class commonSteps {

    @Given("the user is not logged in")
    public void the_user_is_not_logged_in() {
        TestRunner.loginPage.openLoginPage();
    }

    @Given("the user is in the home page")
    public void the_user_is_in_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.setUpLoggedInUser();
        TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),0));
        // TestRunner.implicitlyWaitForSeconds(5);
        // TestRunner.numberOfTable = TestRunner.homePage.getNumberOfCelestialRows();
    }

    @Then("the user should get a browser alert saying {string}")
    public void the_user_should_get_a_browser_alert_saying(String string) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(string.toLowerCase(), alert.getText().toLowerCase());
        alert.accept();
    }
    
    @When("the user provides username {string}")
    public void the_user_provides_username(String string) {
        TestRunner.registrationPage.enterUsername(string);
    }

    @When("the user provides password {string}")
    public void the_user_provides_password(String string) {
        TestRunner.registrationPage.enterPassword(string);
    }

    @Then("the table refreshes")
    public void the_table_refreshes() {
        //String oldTable = TestRunner.homePage.getTable().toString();
        // TestRunner.wait.until(ExpectedConditions.not(driver -> {
        //     return TestRunner.numberOfTable == TestRunner.homePage.getNumberOfCelestialRows();
        // }));
        //TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),0));
        //Delete This
        TestRunner.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("tr")));
        System.out.print(TestRunner.homePage.getTable().toString());
        Assert.assertNotEquals(4 ,TestRunner.homePage.getNumberOfCelestialRows());
    }

    @Given("Planet is selected")
    public void planet_is_selected() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.planetIsSelected();
        TestRunner.implicitlyWaitForSeconds(2);
    }

    @Given("Moon is selected")
    public void moon_is_selected() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.moonIsSelected();
        TestRunner.implicitlyWaitForSeconds(2);
    }
}
