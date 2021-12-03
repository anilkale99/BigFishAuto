package com.bigfish.pom.pages.Campaign;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CampaignBasePage extends BasePage {
    WebDriver driver;

    public CampaignBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }
    public static By getLocatorForField(String fieldName) {
        By LOCATOR_VALUE = null;
        switch (fieldName) {
            case "ActionBtnLoc":
                LOCATOR_VALUE = By.xpath("//div[contains(@class,\"btn-group edit-button\")]/button");
                break;
            case "AddCommentLoc":
                LOCATOR_VALUE = By.xpath("//input[@placeholder=\"Add comment\"]");
                break;
            case "SendBtnLoc":
                LOCATOR_VALUE = By.xpath("//button[text()=\" SEND \"]");
                break;
            case "CloseBtn":
                LOCATOR_VALUE = By.xpath("//button[contains(@class,\"close-button-mt\")]");
                break;
            case "CampaignTitle":
                LOCATOR_VALUE = By.xpath("//div[@class=\"pull-left board-title ng-star-inserted\"]");
                break;
            case "CampaignDescription":
                LOCATOR_VALUE = By.xpath("//span[@class=\"activity-desc\"]");
                break;
            case "CampaignDate":
                LOCATOR_VALUE = By.xpath("//div[@class=\"paticipant-text ng-star-inserted\"]");
                break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }
//dynamic Locator
        public static By getLocatorForFormTextField(String TxtFieldName)
        {
            By DYNAMIC_LOCATOR_VALUE = null;
            DYNAMIC_LOCATOR_VALUE=By.xpath("//*[@formcontrolname='"+TxtFieldName+"']");
            return DYNAMIC_LOCATOR_VALUE;
        }

    public static By ActionButtonLoc(String Action_Btn)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//ul[contains(@class,\"dropdown\")]/li/a[text()='"+Action_Btn+"']");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By ParticipateAndContributeBtnLoc(String ActionBtn)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//button[contains(@class,\"btn btn-lg participate-btn ng-star-inserted\")][contains(text(),'"+ActionBtn+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public static By getLocatorForTextPostOnCampaignDetailPage(String TextValue )
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//div[contains(@class,\"clickable campaign-text\")]//span[contains(text(),'"+TextValue+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }

}