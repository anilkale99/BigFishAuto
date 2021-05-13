package com.bigfish.steps.common;

import com.bigfish.pom.common.*;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.utilities.PropertiesOperation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login extends BasePage {

    private ContextSteps contextSteps;
    WebDriver driver;

    // PicoContainer injects class ContextSteps
    public Login(ContextSteps contextSteps) throws Exception {
        super(contextSteps);
    }

    @When("User enters value {string} in {string} field")
    public void enterValueInfield(String value, String fieldName) {
        enterValue(value, fieldName);
    }

    @When("User clicks on {string}")
    public void clickOnElement(String fieldName) throws InterruptedException {
        clickElement(fieldName);
        Thread.sleep(3000);
    }


    @Given("User is on application home page")
    public void userIsAtHomePage() throws InterruptedException {
        Thread.sleep(6000);
        WebElement HomePageProfileImg= driver.findElement(CommonLocators.getLocatorForField("HomePageProfileImage"));
        WaitForElementToBeVisible(HomePageProfileImg);

    }

    @Given("User Login to application with {string} and {string}.")
    public void LoginUser(String Username, String Password) throws InterruptedException {
        String userName = PropertiesOperation.getRadicalValueBykey(Username);
        String passWord = PropertiesOperation.getRadicalValueBykey(Password);
        enterValue(userName, "username");
        enterValue(passWord, "password");
        clickElement("Login");
    }


}