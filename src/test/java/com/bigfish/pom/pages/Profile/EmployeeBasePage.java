package com.bigfish.pom.pages.Profile;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeBasePage extends BasePage {
    WebDriver driver;

    public EmployeeBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public static By getLocatorForField(String fieldName) {
        By LOCATOR_VALUE = null;
        switch (fieldName) {
            case "EmployeeStatus":
                LOCATOR_VALUE = By.xpath("//select[@formcontrolname=\"status\"]/option[text()='Active']");
                break;
            case "IsPeopleManagerCheckBox":
                LOCATOR_VALUE = By.xpath("//span[@class=\"fa fa-check\"]");
                break;
            case "SubmitButtonText":
                LOCATOR_VALUE = By.xpath("//div[contains(@class,\"scoll-employeeform\")]/following-sibling::div//button[text()=\"Save\"]");
                break;
            case "employeeGender":
                LOCATOR_VALUE = By.xpath("//*[@formcontrolname=\"employeeGender\"]/div");
                break;
            case "UploadImgBtn":
                LOCATOR_VALUE = By.xpath("//button[text()=\"Upload Image\"]");
                break;
            case "ActionBtnLoc":
                LOCATOR_VALUE = By.xpath("//button[contains(@class,\"btn dropdown-toggle\")][contains(text(),\"Actions\")]");
                break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }


    //Dynamic Locator

    public static By getLocatorToVerifyDetailsInSearchList(String Tr_Value, String ColoumNo) {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//th[text()='" + Tr_Value + "']/ancestor::table[@class=\"table table-striped\"]/tbody/tr/td["+ColoumNo+"]");
        return DYNAMIC_LOCATOR_VALUE;

    }
}