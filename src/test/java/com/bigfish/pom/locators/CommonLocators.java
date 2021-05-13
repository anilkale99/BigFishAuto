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
            case "HomePageProfileImage": LOCATOR_VALUE = By.xpath("//app-header/div//ul/li[4][@class=\"dropdown mr pl-lg\"]/a"); break;
            case "SignOut": LOCATOR_VALUE = By.xpath("//ul[@class='dropdown-menu animated']/li[7]"); break;
            case "Select_Criteria_Link" : LOCATOR_VALUE = By.xpath("//label[text()=\"Who can be nominated\"]/ancestor::div/div/a");break;
            case "Select_Criteria_Link1" : LOCATOR_VALUE = By.xpath("//div[text()='Who can nominate']/ancestor::div[contains(@class,'stage-panel mt')]//a");break;
            case "Select_Criteria_Link2" : LOCATOR_VALUE = By.xpath("//div[text()='Who can validate']/ancestor::div[contains(@class,'stage-panel mt')]//a");break;
            case "Select_Criteria_Link3" : LOCATOR_VALUE = By.xpath("//div[text()='Who can vote']/ancestor::div[contains(@class,'stage-panel mt')]//a");break;

            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

}
