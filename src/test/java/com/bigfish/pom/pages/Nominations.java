package com.bigfish.pom.pages;

import com.bigfish.pom.common.BaseAction;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.WebDriver;

public class Nominations extends BaseAction {

    WebDriver driver;

    public Nominations(ContextSteps contextSteps){
        super(contextSteps);
        driver = contextSteps.getDriver();
    }
}
