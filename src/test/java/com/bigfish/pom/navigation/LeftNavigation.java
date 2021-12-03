package com.bigfish.pom.navigation;

import com.bigfish.pom.common.*;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeftNavigation extends  BasePage{
    WebDriver driver;
    public LeftNavigation(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public static By getLocatorForField(String fieldName){
        By LOCATOR_VALUE = null;
        switch(fieldName) {
            case "Nomination": LOCATOR_VALUE = By.xpath("//span[text()='Nomination']");
            break;

            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

    public By getLocatorForLeftNavigationLink(String fieldName){
        return By.xpath("//a[@title='"+fieldName+"']");
    }
    public static By GetLocatorForConfigNavigationLink(String LinkName){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//a[contains(text(),'"+LinkName+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By GetLocatorForComponentCreateButton(String CreateBtn){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//*[contains(text(),'"+CreateBtn+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public void clickOnLeftNavigationLink(String fieldName) throws InterruptedException {
        clickElement(getLocatorForLeftNavigationLink(fieldName));
    }

}