package com.bigfish.steps.common;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.navigation.LeftNavigation;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LeftNavigationStep extends LeftNavigation   {

    private ContextSteps contextSteps;
    WebDriver driver;

    // PicoContainer injects class ContextSteps
    public LeftNavigationStep(ContextSteps contextSteps) throws Exception {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @When("User on left side bar navigate to {string}")
    public void useronleftsidebarnavigateto(String fieldName) throws InterruptedException {
        clickOnLeftNavigationLink(fieldName);
    }
}
