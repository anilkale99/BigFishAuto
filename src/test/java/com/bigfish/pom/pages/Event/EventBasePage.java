package com.bigfish.pom.pages.Event;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EventBasePage extends BasePage {
    WebDriver driver;

    public EventBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public static By getLocatorForField(String fieldName)
    {
        By LOCATOR_VALUE = null;
        switch (fieldName) {
            case "EventTitle":
                LOCATOR_VALUE = By.xpath("//div[@class=\"event-title pull-left\"]");
                break;
            case "EventDescription":
                LOCATOR_VALUE = By.xpath("//div[contains(@class,\"event-title\")]/following-sibling::div//div[contains(@class,\"activity-desc\")]");
                break;
            case "EventLocation":
                LOCATOR_VALUE = By.xpath("//label[text()=\"Location\"]/following-sibling::div/p");
                break;
            case "EventStartDate":
                LOCATOR_VALUE = By.xpath("//label[text()=\"From\"]/following-sibling::div/p");
                break;
            case "EvenEndDate":
                LOCATOR_VALUE = By.xpath("//label[text()=\"Till\"]/following-sibling::div/p");
                break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

//dynamic Locator
        public static By getLocatorForHoursInDates (String DateHH)
        {
            By DYNAMIC_LOCATOR_VALUE = null;
            DYNAMIC_LOCATOR_VALUE = By.xpath("//div[contains(text(),'"+DateHH+"')]/following-sibling::*//tr/td/input[@placeholder=\"HH\"]");
            return DYNAMIC_LOCATOR_VALUE;
        }

        public static By getLocatorForMinutesInDates (String DateMM)
        {
            By DYNAMIC_LOCATOR_VALUE = null;
            DYNAMIC_LOCATOR_VALUE = By.xpath("//div[contains(text(),'"+DateMM+"')]/following-sibling::*//tr/td/input[@placeholder=\"MM\"]");
            return DYNAMIC_LOCATOR_VALUE;
        }

    }
