package com.revature.steps.createCelestialBodies;

import com.revature.TestRunner;

import io.cucumber.java.en.Then;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class createPlanetHappyPathSteps {
    
    @Then("the new planet {string} is on the table")
    public void the_new_planet_is_on_the_table(String string) {
        boolean planetIsOnTheTable = false;

        TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"), TestRunner.numberOfTable));
        for (WebElement row : TestRunner.driver.findElements(By.tagName("tr"))) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if(cells.size()>0){
                if (cells.get(0).getText().equals("planet") && cells.get(2).getText().equals(string)) { 
                    planetIsOnTheTable = true;
                }
            }            
        }
        Assert.assertTrue(planetIsOnTheTable);


    }
    
}
