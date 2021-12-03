package com.bigfish.pom.pages.Discussion;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DiscussionBasePage extends BasePage {
    WebDriver driver;

    public DiscussionBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public static By getLocatorForField(String fieldName) {
        By LOCATOR_VALUE = null;
        switch (fieldName) {
            case "DiscussionTitle":
                LOCATOR_VALUE = By.xpath("//div[contains(@class,\"discussion-title line-breaker\")]");
                break;
            case "DiscussionQuestion":
                LOCATOR_VALUE = By.xpath("//div[contains(@class,\"discussion-title line-breaker\")]/following-sibling::div[1]");
                break;
            case "EditDiscussionTitle":
                LOCATOR_VALUE = By.xpath("//div[@class=\"input-group\"]/input");
                break;
            case "EditDiscussionDesc":
                LOCATOR_VALUE = By.xpath("//div[contains(@class,\"form-control custom-box\")]");
                break;

            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }
}
