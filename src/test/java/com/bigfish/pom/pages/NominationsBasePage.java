package com.bigfish.pom.pages;

import com.bigfish.pom.common.BaseAction;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NominationsBasePage extends BaseAction {

    WebDriver driver;

    public NominationsBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public static By getLocatorForField(String fieldName){
        By LOCATOR_VALUE = null;
        switch(fieldName){
            case "New Nomination": LOCATOR_VALUE = By.xpath("//xpath for New Nomination"); break;
            case "Continue": LOCATOR_VALUE = By.xpath("//*[@name='continue' and @type='button'] | //*[@name='continue' and @id='continue_button'] | //*[@name='continue' and @type='submit' and @value='Continue >']"); break;
            case "sign-out": LOCATOR_VALUE = By.linkText("Sign out"); break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

}
