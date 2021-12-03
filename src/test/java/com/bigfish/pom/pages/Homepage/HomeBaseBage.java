package com.bigfish.pom.pages.Homepage;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.WebDriver;

public class HomeBaseBage extends BasePage {
    WebDriver driver;

    public HomeBaseBage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }
}
