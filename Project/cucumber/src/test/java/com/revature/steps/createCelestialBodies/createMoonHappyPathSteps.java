package com.revature.steps.createCelestialBodies;

import com.revature.TestRunner;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;

public class createMoonHappyPathSteps {
    @Then("the new moon {string} is on the table")
    public void the_new_moon_is_on_the_table(String string) {
        boolean moonIsPresent = false;
        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"), TestRunner.numberOfTable));
        for (WebElement row : TestRunner.driver.findElements(By.tagName("tr"))) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if(cells.size()>0){
                if (cells.get(0).getText().equals("moon") && cells.get(2).getText().equals(string)) { 
                    moonIsPresent = true;
                }
            }            
        }
        Assert.assertTrue(moonIsPresent);
    }
}
