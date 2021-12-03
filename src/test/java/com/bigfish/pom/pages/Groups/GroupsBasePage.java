package com.bigfish.pom.pages.Groups;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupsBasePage extends BasePage {
    WebDriver driver;
    public static int randomNumber;

    public GroupsBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public static By getLocatorForField(String fieldName) {
        By LOCATOR_VALUE = null;
        switch (fieldName) {
            case "GroupActionBtnLoc":
                LOCATOR_VALUE = By.xpath("//button[@class=\"btn dropdown-toggle btn-info\"]");
                break;
            case "GroupActioinDropdownValue":
                LOCATOR_VALUE = By.xpath("");
                break;
            case "GroupTitle":
                LOCATOR_VALUE = By.xpath("//div[@class=\"group_title\"]");
                break;
            case "GroupDescription":
                LOCATOR_VALUE = By.xpath("//div[@class=\"group_title\"]/following-sibling::div//span[@class=\"activity-desc line-breaker\"]");
                break;
            case "GroupOwnerName":
                LOCATOR_VALUE = By.xpath("(//div[@class=\"owner_name_cls\"])[1]");
                break;
            case "GroupCategory":
                LOCATOR_VALUE = By.xpath("//select[contains(@class,'ng-valid')]");
                break;
            case "CreateGroupBtn":
                LOCATOR_VALUE = By.xpath("(//button[contains(text(),\"DONE\")])[2]");
                break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }
}