package com.bigfish.steps.storeSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Store.StoreBasePage;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import com.bigfish.utilities.ExcelReader;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;

public class StoreSteps extends StoreBasePage {
    WebDriver driver;
    public StoreSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("confirming the error code after login need to remove after issue resolved")
    public void confirmingTheErrorCodeAfterLoginNeedToRemoveAfterIssueBFIssueResolved() throws InterruptedException
    {
        //Adding below two lines for error message conformation need to remove once issue BF-1897.
        Thread.sleep(4000);
        WebElement SubmitErrorBtn = driver.findElement(StoreBasePage.getLocatorForField("ConfirmPopupOKLoc"));
        SubmitErrorBtn.click();
    }

    @And("Search and Select Vendor name {string} from the vendor list and Select action value {string}.")
    public void searchAndSelectVendorNameFromTheVendorList(String VendorName, String vendorActionValue) throws InterruptedException {
        Thread.sleep(4000);
        WebElement SearchTextField = driver.findElement(StoreBasePage.getLocatorForField("VendorSearchField"));
        SearchTextField.sendKeys(VendorName);
        WebElement SubmitSearchBtn = driver.findElement(CommonLocators.getLocatorForField("Login"));
        SubmitSearchBtn.click();
        WebElement VendorActionBtn = driver.findElement(StoreBasePage.getLocatorForField("VendorActionBtn"));
        VendorActionBtn.click();
        WebElement VendorActionValue = driver.findElement(StoreBasePage.getLocatorForVendorNameActionValue(vendorActionValue));
        VendorActionValue.click();
    }

    @And("Super User adding Voucher code {int} of vendor {string} in file {string} with success message{string}.")
    public void superUserAddingVoucherCodeVendorColumnNoInFileWithSuccessMessage(int ColumnNumber,String VendorName, String Filename, String S_Message) throws IOException, InterruptedException {
        ExcelReader excelRead = new ExcelReader();
        ArrayList<String> VoucherCode = excelRead.ReadExcelData(ColumnNumber,Filename);
        System.out.println(VoucherCode.size());

        for (int i = 0; i < VoucherCode.size(); i++) {
            Thread.sleep(2000);
            driver.switchTo().activeElement();
            WebElement VoucherCodeTxtField = driver.findElement(StoreBasePage.getLocatorForField("VendorVoucherTextField"));
            VoucherCodeTxtField.sendKeys(VoucherCode.get(i));
            WebElement SubmitVoucherBtn = driver.findElement(NominationsBasePage.getLocatorForField("SubmitMgsButton"));
            SubmitVoucherBtn.click();

           Thread.sleep(4000);
            WebElement SuccessMessage = driver.findElement(StoreBasePage.getLocatorForField("successMessage"));
            String SMessage = SuccessMessage.getText();
            Assert.assertEquals(SMessage, S_Message);
           WebElement ConfirmSuccessMessageBtn = driver.findElement(StoreBasePage.getLocatorForField("ConfirmPopupOKLoc"));
           ConfirmSuccessMessageBtn.click();
           System.out.println("column Number" + i + "Respective vendor code" + VoucherCode.get(i));
            driver.navigate().to(driver.getCurrentUrl());
            confirmingTheErrorCodeAfterLoginNeedToRemoveAfterIssueBFIssueResolved();
            Thread.sleep(4000);
            searchAndSelectVendorNameFromTheVendorList(VendorName,"Resend Voucher");
        }


    }
}