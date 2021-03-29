package com.bigfish.steps.common;

import com.bigfish.pom.common.BaseAction;
import com.bigfish.pom.common.ContextSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BaseAction{

    private ContextSteps contextSteps;
    WebDriver driver;

    // PicoContainer injects class ContextSteps
    public Login(ContextSteps contextSteps) throws Exception {
        super(contextSteps);
    }
    
    @When("User enters value {string} in {string} field")
    public void enterValueInfield(String value, String fieldName){
        enterValue(value, fieldName);
    }
    
    @When("User clicks on {string}")
    public void clickOnElement(String fieldName){
        clickElement(fieldName);
    }


//    @Given("User is on application home page")
//    public void userIsAtHomePage() throws InterruptedException {
//        driver.get("https://barclays.dev-givingforce.com/");
//        driver.findElement(By.xpath("//button[@id='details-button']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
//    }


}
