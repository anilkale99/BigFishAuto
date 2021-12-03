package com.bigfish.pom.pages.Announcement;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AnnouncementBasePage extends BasePage {
    WebDriver driver;

    public AnnouncementBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public static By getLocatorForField(String fieldName) {
        By LOCATOR_VALUE = null;
        switch (fieldName) {
            case "AnnouncementDesc":
                LOCATOR_VALUE = By.xpath("//div[contains(@class,\"ql-editor\")]");
                break;
            case "AnnouncementDescLoc":
                LOCATOR_VALUE = By.xpath(" //div[@class=\"mb\"]/p");
                break;
            case "DotButtonLoc":
                LOCATOR_VALUE = By.xpath("//div[@class=\"three-dot-circle\"]");
                break;
            case "AnnouncementTitle":
                LOCATOR_VALUE = By.xpath("//div[@class=\"discussion-title mt-lg\"]");
                break;
            case "AnnouncementCategory":
                LOCATOR_VALUE = By.xpath("//span[contains(@class,\"tag\")]");
                break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

//Dynamic Value

    public static By getLocatorForAnnouncementDropdownValue(String Action_Btn)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//ul[contains(@class,\"dropdown-menu animated\")]/li/a[text()='"+Action_Btn+"']");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By GetLocatorForAnnouncementCreateButton(String CreateBtn){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//button[contains(text(),'"+CreateBtn+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }
}
