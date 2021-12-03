package com.bigfish.pom.pages.Store;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;

public class StoreBasePage extends BasePage {
    public StoreBasePage(ContextSteps contextSteps) {
        super(contextSteps);
    }

    public static By getLocatorForField(String fieldName) {
        By LOCATOR_VALUE = null;
        switch (fieldName) {
            case "VendorSearchField":
                LOCATOR_VALUE = By.xpath("//input[@name=\"term\"]");
                break;
            case "VendorActionBtn":
                LOCATOR_VALUE = By.xpath("//div[@class=\"table-responsive\"]//tr/td[5]/div");
                break;
            case "VendorVoucherTextField":
                LOCATOR_VALUE = By.xpath("(//input[@type=\"text\"])[2]");

                break;
            case "successMessage":
                LOCATOR_VALUE = By.xpath("//div[@class=\"swal-title\"]");
                break;
            case "ConfirmPopupOKLoc" :
                LOCATOR_VALUE = By.xpath("//button[@class=\"swal-button swal-button--confirm\"]");
                break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;

    }
//dynamic_Locator

    public static By getLocatorForVendorNameActionValue(String Action_Value)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//li[@role=\"menuitem\"]/a[contains(text(),'"+Action_Value+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }

}