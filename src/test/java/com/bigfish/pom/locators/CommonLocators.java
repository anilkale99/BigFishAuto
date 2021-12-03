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
            case "HomePageProfileImage": LOCATOR_VALUE = By.xpath("//div[@class=\"nav-wrapper pt-sm\"]//ul/li[4]//a[@id=\"header-user-menu\"]"); break;
            case "SignOut": LOCATOR_VALUE = By.xpath("//ul[contains(@class,'dropdown-menu')]/li/a[text()='Log Out']"); break;
            case  "MoodboadOps" : LOCATOR_VALUE= By.xpath("//div[@class=\"wrapper\"]//div[@class=\"modal fade in\"]//div[text()='Awesome']/ancestor::div[@class=\"text-center\"]");break;
            case  "LoginRecogPopupBtn" : LOCATOR_VALUE=By.xpath("//div[@aria-hidden=\"false\"]//button[@class=\"btn btn-info pull-right mb mr-sm\"]");break;
            case  "BirthdayAnnivarsaryPopup"  : LOCATOR_VALUE = By.xpath("//span[contains(text(), 'BIRTHDAY') or contains(text(),'ANNIVERSARY')]/ancestor::div[@role=\"dialog\"]//button[@class=\"close pull-right\"]");break;
            case  "AllFilterDropdownBtn": LOCATOR_VALUE =By.xpath("//span[@class=\"filterText p1\"]");break;
            case  "FilterApplyBtn": LOCATOR_VALUE=By.xpath("//button[contains(text(),\"Apply\")]");break;
            case  "ConfirmPopupBtn": LOCATOR_VALUE=By.xpath("//div[@class=\"modal-footer ng-star-inserted\"]//button[text()=\"Yes\"]");break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

    public static By getLocatorToSelectCriteriaStageLink(String CriteriaFor)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//*[text()='"+CriteriaFor+"']/following-sibling::div/a");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLoctorForActionButtonInConfig(String Attribute)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//table/tbody//td[text()=' "+Attribute+"']/ancestor::tr[1]//button");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLoctorForActionButtonValue(String AttributeDropdownValue)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("(//li[@role=\"menuitem\"]/a[contains(text(),'"+AttributeDropdownValue+"')])[1]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorForHomePageBannerOption(String BannerOption) {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//div[contains(text(),'"+BannerOption+"')]");
        return DYNAMIC_LOCATOR_VALUE;

    }
    public static By getLocatorForHomePageFilterOption(String filterOption) {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//div[contains(@class,\"mb-lg open\")]/ul//label[text()='"+filterOption+"']/ancestor::div[@class=\"checkbox\"]//input");
        return DYNAMIC_LOCATOR_VALUE;

    }
    public static By GetLocatorForTheConfigurationLink(String configLink) {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//a[contains(text(),'" + configLink + "')]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorForScopeRuleValue(String scopeValue) {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("(//ul[contains(@class,'dropdown-menu animated')])[last()]/li/a[contains(text(),'" + scopeValue + "')]  | (//ul[contains(@class,'dropdown-menu animated')])[2]/li/a[contains(text(),'" + scopeValue + "')]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By SearchCreatedComponentInList(String Comp_Name)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//div[contains(@class,\"discussion\")]//a[contains(text(),'"+Comp_Name+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }
}
