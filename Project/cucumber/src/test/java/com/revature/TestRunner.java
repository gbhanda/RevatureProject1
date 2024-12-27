package com.revature;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    // Needs to be removed
    public static void waitForChecking(){
        try {
            Thread.sleep(10000); // Wait for 2 seconds (2000 milliseconds)
        } catch (InterruptedException e) {
            System.err.println("Interrupted: " + e.getMessage());
        }
    }
}