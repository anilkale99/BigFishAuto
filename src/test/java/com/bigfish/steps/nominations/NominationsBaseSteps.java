package com.bigfish.steps.nominations;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.pages.NominationsBasePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class NominationsBaseSteps extends NominationsBasePage {

    private ContextSteps contextSteps;
    WebDriver driver;

    // PicoContainer injects class ContextSteps
    public NominationsBaseSteps(ContextSteps contextSteps) throws Exception {
        super(contextSteps);
    }

    @When("User on Nominations clicks on new {String} field")
    public void User_on_Nominations_clicks_on_new_Nominations_field(String fieldName) throws InterruptedException {
        clickElement(getLocatorForField(fieldName));
    }

}
