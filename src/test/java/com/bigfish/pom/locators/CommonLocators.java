package com.bigfish.pom.locators;

import org.openqa.selenium.By;

public class CommonLocators {

    public static By getLocatorForField(String fieldName){
        By LOCATOR_VALUE = null;
        switch(fieldName){
            case "username": LOCATOR_VALUE = By.xpath("//input[@id='exampleInputEmail1']"); break;
            case "password": LOCATOR_VALUE = By.xpath("//input[@type='"+fieldName+"']"); break;
            case "Login": LOCATOR_VALUE = By.xpath("//button[@type='submit']"); break;
            case "Continue": LOCATOR_VALUE = By.xpath("//*[@name='continue' and @type='button'] | //*[@name='continue' and @id='continue_button'] | //*[@name='continue' and @type='submit' and @value='Continue >']"); break;
            case "sign-out": LOCATOR_VALUE = By.linkText("Sign out"); break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

}
