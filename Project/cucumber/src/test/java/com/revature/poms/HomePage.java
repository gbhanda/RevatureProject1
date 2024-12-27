package com.revature.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;

    @FindBy(id="locationSelect")
    private WebElement dropdownElement;

    @FindBy(id="deleteButton")
    private WebElement deleteButton;

    @FindBy(id="deleteInput")
    private WebElement deleteInput;

    @FindBy(id="planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id="planetImageInput")
    private WebElement planetImageInput;

    @FindBy(id="moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id="orbitedPlanetInput")
    private WebElement orbitedPlanetInput;

    @FindBy(id="moonImageInput")
    private WebElement moonImageInput;

    @FindBy(xpath = "//button[@class='submit-button']")
    private WebElement submitButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterPlanetName(String planetName){
        planetNameInput.sendKeys(planetName);
    }

    public void enterPlanetImagePath(String planetImagePath){
        planetImageInput.sendKeys(planetImagePath);
    }

    public void enterMoonName(String moonName){
        moonNameInput.sendKeys(moonName);
    }

    public void enterOrbittedPlanetId(int planetId){
        orbitedPlanetInput.sendKeys(Integer.toString(planetId));
    }

    public void enterMoonImagePath(String moonImagePath){
        moonImageInput.sendKeys(moonImagePath);
    }

    public void enterDeleteInput(String celestialBodyName){
        deleteInput.sendKeys(celestialBodyName);
    }

    public void clickDeleteButton(){
        deleteButton.click();
    }

    public void clickSubmitButton(){
        submitButton.click();
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){
        return tableRows.size()-1;
    }

    public boolean checkIfaPlanetIsDeleted(String planetName){
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().equals("planet") && cells.get(2).getText().equals(planetName)) { 
                return false;
            }
        }
        return true;
    }

    public boolean checkIfaPlanetIsOnTheTable(String planetName){
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().equals("planet") && cells.get(2).getText().equals(planetName)) { 
                return true;
            }
        }
        return false;
    }

    public boolean checkIfaMoonIsOnTheTable(String moonName){
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().equals("moon") && cells.get(2).getText().equals(moonName)) { 
                return true;
            }
        }
        return false;
    }

    public boolean checkIfaPlanetsMoonIsDeleted(String planetId){
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().equals("moon") && cells.get(3).getText().equals(planetId)) { 
                return false;
            }
        }
        return true;
    }

    public boolean checkIfaMoonIsDeleted(String moonName){
        for (WebElement row : tableRows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(0).getText().equals("moon") && cells.get(2).getText().equals(moonName)) { 
                return false;
            }
        }
        return true;
    }

    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public void logout(){
        logoutButton.click();
    }

    public void moonIsSelected(){
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("moon");
    }

    public void planetIsSelected(){
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("planet");
    }
}
