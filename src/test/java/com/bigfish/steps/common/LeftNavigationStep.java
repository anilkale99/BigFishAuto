package com.bigfish.steps.common;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.navigation.LeftNavigation;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class LeftNavigationStep extends LeftNavigation   {

    private ContextSteps contextSteps;
    WebDriver driver;

    // PicoContainer injects class ContextSteps
    public LeftNavigationStep(ContextSteps contextSteps) throws Exception {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @When("User on left side bar navigate to {string}.")
    public void useronleftsidebarnavigateto(String fieldName) throws InterruptedException {
        clickOnLeftNavigationLink(fieldName);
    }
    @When("User on configuration navigate to link {string}.")
    public void userOnConfigurationNavigateToLink(String LinkName) throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        WebElement ConfigLink = driver.findElement(CommonLocators.GetLocatorForTheConfigurationLink(LinkName));
        WaitAndClick(ConfigLink);
        }

    @And("User click on the {string}  button and create.")
    public void userClickOnTheButtonAndCreate(String ButtonText) throws InterruptedException {
        Thread.sleep(8000);
        WebElement CreateBtn = driver.findElement(LeftNavigation.GetLocatorForComponentCreateButton(ButtonText));
        CreateBtn.click();
        Thread.sleep(4000);




    }

}

