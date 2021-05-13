package com.bigfish.pom.pages.Nomination;

import org.openqa.selenium.WebDriver;

import com.bigfish.pom.common.ContextSteps;

public class CreateNominationPage extends NominationsBasePage{
    WebDriver driver;
    public CreateNominationPage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }



}