package com.bigfish.steps.nominationsSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import org.openqa.selenium.WebDriver;

public class NominationsBaseSteps extends NominationsBasePage {

    private ContextSteps contextSteps;
    WebDriver driver;

    // PicoContainer injects class ContextSteps
    public NominationsBaseSteps(ContextSteps contextSteps) throws Exception {
        super(contextSteps);
    }

}
