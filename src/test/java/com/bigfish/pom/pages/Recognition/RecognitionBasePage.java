package com.bigfish.pom.pages.Recognition;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecognitionBasePage extends BasePage {

    WebDriver driver;

    public RecognitionBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    //Locators
    public static By getLocatorForField(String fieldName) {
        By LOCATOR_VALUE = null;
        switch (fieldName) {
            case "MonetoryBadgeCriteriaLink":
                LOCATOR_VALUE = By.xpath("//a[@class=\"link-unstyled\"]/span");
                break;
            case "RecognitionDropdownToggle":
                LOCATOR_VALUE = By.xpath("//div[@class=\"mb-lg clearfix\"]/div[4]/button");
                break;
            case "FundNameTextBoxLoc":
                LOCATOR_VALUE = By.xpath("//label[text()='Fund']/ancestor::div[@class=\"form-group\"]//span[contains(@class,'ui-select-toggle')]");
                break;
            case "CaurosalRightArrowBtn":
                LOCATOR_VALUE = By.xpath("//button[contains(@class,\"right-button\")]/span[contains(@class,\"chevron-right\")]");
                break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

    public static By getlocatorforRecognitioncreateoption(String Option)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//span[contains(@class,'title')][text()='"+Option+"']/ancestor::div[contains(@class,\"col-md-4 text-center\")]/img");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorForRecognitionDropdownToggle(String Value) {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//ul[contains(@class,\"dropdown-menu animated\")]/li/a[text()='"+Value+"']");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public static By getLocatorForAwardTypeRadioButton(String AwardTypeOps){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//label[text()='"+AwardTypeOps+"']");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public static By getLocatorToSelectAwardInCarusel(String AwardTypeOps){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//div[@class=\"ngucarousel-items\"]/ngu-tile//div[contains(text(),'"+AwardTypeOps+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public static By getLocatorToSelectCompanyValue(String CompanyValue){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//div[contains(@class,\"beforeSelect\")][contains(text(),'"+CompanyValue+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorToSearchAwardPostInActivityFeed(String EmployeeName, String AwardTitle) {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//span [contains(text(), '"+EmployeeName+"')]/ancestor::div[@class=\"list-group\"]//*[contains(text(),'"+AwardTitle+"')]");
        return DYNAMIC_LOCATOR_VALUE;

    }
    public static By getLocatorToVerifySelectRoleOnAwardPage(String roleName)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//span[@class=\"ui-select-match\"]//span[contains(text(),'"+roleName+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public static By getLocatorToVerifySelectEmployeeOnAwardPage(String employeename)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//*[@class=\"badge-tag\"]/text()[contains(.,'"+employeename+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorToSubmitAssignAward(String SubmitText)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//button[text()='"+SubmitText+"']");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public static By getLocatorToSelectBadgeFromNonMonetaryListOnHomepage(String NMBadgeName)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//div[contains(@class,\"popover-content popover-body\")]//div[text()='"+NMBadgeName+"']//preceding-sibling::a/img");
        return DYNAMIC_LOCATOR_VALUE;
    }


}