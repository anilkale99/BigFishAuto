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
            case "HomePageProfileImage": LOCATOR_VALUE = By.xpath("//div[@class=\"nav-wrapper pt-sm\"]//ul/li[4][@class=\"dropdown mr pl-lg\"]"); break;
            case "SignOut": LOCATOR_VALUE = By.xpath("//ul[@class='dropdown-menu animated']/li/a[text()='Log Out']"); break;
            case "Select_Criteria_Link" : LOCATOR_VALUE = By.xpath("//label[text()=\"Who can be nominated\"]/ancestor::div/div/a");break;
            case "Select_Criteria_Link1" : LOCATOR_VALUE = By.xpath("//div[text()='Who can nominate']/ancestor::div[contains(@class,'stage-panel mt')]//a");break;
            case "Select_Criteria_Link2" : LOCATOR_VALUE = By.xpath("//div[text()='Who can validate']/ancestor::div[contains(@class,'stage-panel mt')]//a");break;
            case "Select_Criteria_Link3" : LOCATOR_VALUE = By.xpath("//div[text()='Who can vote']/ancestor::div[contains(@class,'stage-panel mt')]//a");break;
            case  "MoodboadOps" : LOCATOR_VALUE= By.xpath("//div[@class=\"wrapper\"]//div[@class=\"modal fade in\"]//div[text()='Awesome']/ancestor::div[@class=\"text-center\"]");break;
            case  "LoginRecogPopupBtn" : LOCATOR_VALUE=By.xpath("//div[@aria-hidden=\"false\"]//button[@class=\"btn btn-info pull-right mb mr-sm\"]]");break;
            case  "BirthdayAnnivarsaryPopup"  : LOCATOR_VALUE = By.xpath("//span[contains(text(), 'BIRTHDAY') or contains(text(),'ANNIVERSARY')]/ancestor::div[@role=\"dialog\"]//button[@class=\"close pull-right\"]");break;

            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

}
