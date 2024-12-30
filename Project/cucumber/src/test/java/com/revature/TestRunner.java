package com.revature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.time.Duration;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.revature.poms.HomePage;
import com.revature.poms.LoginPage;
import com.revature.poms.RegistrationPage;

import io.cucumber.core.cli.Main;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = "com.revature.steps",
        plugin = {
                "pretty",
                "html:src/test/resources/reports/html-report.html",
                "json:src/test/resources/reports/json-report.json"
        }
)
public class TestRunner {
    public static int numberOfTable = 100; 
    public static WebDriver driver = null;
    public static WebDriverWait wait;
    public static HomePage homePage;
    public static LoginPage loginPage;
    public static RegistrationPage registrationPage;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
    }

    @AfterClass
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }

    public static void implicitlyWaitForSeconds(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static boolean checkIfaPlanetIsDeleted(String planetName){
         //TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),0));
        for (WebElement row : wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("tr")))) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().equals("planet") && cells.get(2).getText().equals(planetName)) { 
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfaPlanetIsOnTheTable(String planetName){
        System.out.println("=============Helper Method=================");
        System.out.println(homePage.getTable().toString());
        //TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),0));
        //implicitlyWaitForSeconds(2);
        for (WebElement row : driver.findElements(By.tagName("tr"))) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if(cells.size()>0){
                if (cells.get(0).getText().equals("planet") && cells.get(2).getText().equals(planetName)) { 
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkIfaMoonIsOnTheTable(String moonName){
        //TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),0));
        for (WebElement row : wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("tr")))) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().equals("moon") && cells.get(2).getText().equals(moonName)) { 
                return true;
            }
        }
        return false;
    }

    public static boolean checkIfaPlanetsMoonIsDeleted(String planetId){
        //TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),0));
        for (WebElement row : wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("tr")))) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().equals("moon") && cells.get(3).getText().equals(planetId)) { 
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfaMoonIsDeleted(String moonName){
        //TestRunner.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("tr"),0));
        for (WebElement row : wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("tr")))) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().equals("moon") && cells.get(2).getText().equals(moonName)) { 
                return false;
            }
        }
        return true;
    }
}