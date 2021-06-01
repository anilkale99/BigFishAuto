package com.bigfish.steps.common;

import com.bigfish.pom.common.*;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.utilities.PropertiesOperation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import sun.awt.X11.XSizeHints;

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
        Thread.sleep(3000);
        enterValue(userName, "username");
        enterValue(passWord, "password");
        clickElement("Login");
//        if(driver.findElements(CommonLocators.getLocatorForField("MoodboadOps")).size()!=0)
//        {
//            driver.switchTo().activeElement();
//            driver.findElement(CommonLocators.getLocatorForField("MoodboadOps")).click();
//        }
//        else
//        {
//            System.out.println("Moodboard is already selected");
//        }
//
//		// Click on Anniversary or birthday popup
//
//        if (driver.findElements(CommonLocators.getLocatorForField("LoginRecogPopupBtn")).size()!=0)
//        {
//          Thread.sleep(2000);
//		  driver.switchTo().activeElement();
//		  driver.findElement(CommonLocators.getLocatorForField("LoginRecogPopupBtn")).click();
//        }
//
//		 // Click on Recognition popup
//
//        if(driver.findElements(CommonLocators.getLocatorForField("BirthdayAnnivarsaryPopup")).size()!=0)
//        {
//          Thread.sleep(2000);
//		  driver.getWindowHandles();
//		  driver.findElement(CommonLocators.getLocatorForField("BirthdayAnnivarsaryPopup")).click();
//        }
//
//        System.out.println("Logged in Successfully ");

    }
    @Given("User Signing out from the Application.")
    public void LogoutUser() throws InterruptedException {
        scrollToElement("HomePageProfileImage","click");
        Thread.sleep(8000);
        scrollToElement("SignOut","click");
        System.out.println("User is logged out Successfully");
    }


}