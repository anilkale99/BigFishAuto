package com.bigfish.steps.recognitionSteps;

import com.bigfish.pom.common.*;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Profile.EmployeeBasePage;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import com.bigfish.pom.pages.Recognition.RecognitionBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static org.junit.Assert.assertEquals;


public class AwardSteps extends RecognitionBasePage {

    WebDriver driver;
    public static String randomNumber;

    public AwardSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }
/*CREATE AWARD  FROM CONFIGURATION STEPS */

    @And("User click on Create button and select {string} to create.")
    public void userClickOnCreateButtonAndSelectToCreate(String Option) throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button/strong[contains(text(),'Create')]")).click();
        Thread.sleep(2000);
        WebElement RecognitionCreateOpt =driver.findElement(RecognitionBasePage.getlocatorforRecognitioncreateoption(Option));
        scrollToElement(RecognitionCreateOpt, "click");
    }
    @And("User on Award detail  page add {string} image.")
    public void userOnAwardDetailPageAddImage(String RecognitionImageIcon) {
        uploadADocument(By.xpath("//button[@class=\"btn btn-link\"]"), RecognitionImageIcon);
    }

    @And("User on Award details page add {string} in award name field.")
    public void userOnAwardDetailsPageAddInAwardNameField(String awardName) throws InterruptedException {
        Thread.sleep(2000);
        randomNumber = getrandomnumber(4);
        enterValue(BasePage.getlocatorForFieldsOnDetailpage("badgeName"), awardName + randomNumber, "Title");
        System.out.println(awardName + randomNumber);
    }
    @And("User on Award details page add {string} in Description field.")
    public void userOnAwardDetailsPageAddInDescriptionField(String Desc) throws InterruptedException {
        Thread.sleep(2000);
        enterValue(BasePage.getlocatorForFieldsOnDetailpage("description"), Desc + randomNumber, "Description");
    }

    @And("User on Award detail page Select {string} in Fund field.")
    public void userOnAwardDetailPageSelectInFundField(String FundName) throws InterruptedException {
        WebElement fundName = driver.findElement(RecognitionBasePage.getLocatorForField("FundNameTextBoxLoc"));
        NGAngularSearchAndSelectDropdown(fundName, FundName);
    }

    @And("User on Award detail page add {string} in field.")
    public void userOnAwardDetailPageAddInWhoCanGiveField(String EmployeeNames) throws InterruptedException {
        List<String> CriteriaList = SplitString(EmployeeNames,",");
        for (int i = 0; i < CriteriaList.size(); i++) {
            String EmployeeName = CriteriaList.get(i);
            WebElement UsernameLoc = driver.findElement(NominationsBasePage.getLocatorForField("SearchTextField"));
            SearchAndSelect(UsernameLoc, EmployeeName);
            Thread.sleep(4000);
        }
    }

    @And("User on Award detail page add {string} in Who can give-Select roles field.")
    public void userOnAwardDetailPageAddInWhoCanGiveSelectRoleField(String RoleName) throws InterruptedException {
        WebElement RoleLoc = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("badgeSpecifier"));
        SearchAndSelect(RoleLoc, RoleName);
    }

    @And("User on Award detail page add {string} in Points field.")
    public void userOnAwardDetailPageAddInPointsField(String Points) {

        driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("bigfishPoint")).clear();
        enterValue(BasePage.getlocatorForFieldsOnDetailpage("bigfishPoint"), Points, "Title");
    }

    @And("User on Award detail page add {string} in Status field and Save.")
    public void userOnAwardDetailPageAddInStatusField(String Status) throws InterruptedException {
        Thread.sleep(4000);
        selectValue(BasePage.getlocatorForFieldsOnDetailpage("status"), Status);
        Thread.sleep(4000);
        driver.findElement(NominationsBasePage.getLocatorForField("PublishOrSaveButton")).click();
        driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn"));
    }

    @And("User on Award listing page  search recognition {string} click on {string} action of {string}.")
    public void userOnAwardListingPageSelectRecognitionClickOnAction(String RecognitionValue, String Option, String AttibuteName) throws InterruptedException {
        searchAndSelectAwardFromAwardList(AttibuteName,RecognitionValue);
        driver.findElement(CommonLocators.getLoctorForActionButtonInConfig(AttibuteName + randomNumber)).click();
        driver.findElement(CommonLocators.getLoctorForActionButtonValue(Option)).click();

    }
/*ASSIGN AWARD FORM HOME PAGE STEPS.*/

    @And("User click on Recognition {string} on the home Banner.")
    public void userClickOnRecognitionOnTheHomeBanner(String BannerOption) throws InterruptedException {
        Thread.sleep(15000);
        WebElement BannerCard = driver.findElement(CommonLocators.getLocatorForHomePageBannerOption(BannerOption));
        WaitAndClick(BannerCard);
    }


    @And("User on Award detail page select {string} Award type")
    public void userOnAwardDetailPageSelectAwardType(String AwardTypeOption ) throws InterruptedException {
        Thread.sleep(4000);
        if( driver.findElement(RecognitionBasePage.getLocatorForAwardTypeRadioButton(AwardTypeOption)).isSelected()) {
            System.out.println("Radio button is already selected");
        }
        else {
            WebElement awardTypeOption = driver.findElement(RecognitionBasePage.getLocatorForAwardTypeRadioButton(AwardTypeOption));
            WaitAndClick(awardTypeOption);
        }
    }

    @And("User on Award detail Page Add message {string} in Message field")
    public void userOnAwardDetailPageAddMessageInMessageField(String Message) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("awardMessage")).sendKeys(Message);
    }
    @And("User on Award detail page Select company value {string} in company value field.")
    public void userOnAwardDetailPageSelectCompanyValueInCompanyValueField(String CompanyValue)
    {
        List<String> CompanyValueList = SplitString(CompanyValue,",");
        for (int i=0;i<CompanyValueList.size();i++) {
            String Value = CompanyValueList.get(i);
            WebElement CompValue = driver.findElement(RecognitionBasePage.getLocatorToSelectCompanyValue(Value));
            WaitAndClick(CompValue);
        }
    }
    @And("User on Award detail page click on give {string} Button")
    public void userOnAwardDetailPageClickOnAwardButton(String SubmitType)
    {
        driver.findElement(RecognitionBasePage.getLocatorToSubmitAssignAward(SubmitType)).click();
    }

    @And("User on home page search{string} And select {string} the award post in Feed.")
    public void userOnHomePageSearchAndSelectTheAwardPostInFeed(String EmployeeName,String AwardTitle) throws InterruptedException {
        List<String> employeeNameList = SplitString(EmployeeName,",");
        int i=0;
            String EName = employeeNameList.get(i);
        Thread.sleep(2000);
        WebElement awardPost = driver.findElement(RecognitionBasePage.getLocatorToSearchAwardPostInActivityFeed(EName, AwardTitle+randomNumber));
        awardPost.click();
    }
    @And("User on award Detail page verify {string} and {string} and {string} and {string}.")
    public void userOnAwardDetailPageVerifyAndAndAndAnd(String AwardTitle,String employeeName,String Message,String companyValue) throws InterruptedException {
        Thread.sleep(2000);

        verifyTextDisplayed(AwardTitle+randomNumber);

        List<String> employeeNameList = SplitString(employeeName,",");
        for (int i = 0; i < employeeNameList.size(); i++) {
            String Value = employeeNameList.get(i);
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,\"award-member\")]//span[contains(text(), '" + Value + "')]")));
        }

        verifyTextDisplayed(Message);

        List<String> CompanyValueList = SplitString(companyValue,",");
        for (int i = 0; i < CompanyValueList.size(); i++) {
            String Value = CompanyValueList.get(i);
            verifyTextDisplayed(Value);
        }


    }

    @And("Verify Award Details {string} and {string} and {string} and {string} and {string} on Edit award page.")
    public void verifyAwardDetailOnAwardPage(String ActualAwardName, String description, String fundName, String points, String status) throws InterruptedException {

 //   WebElement AwardName = driver.findElement(RecognitionBasePage.getlocatorforawardFieldsOnDetailpage("badgeName"));
        WebElement AwardName = driver.findElement(By.xpath("//input[@formcontrolname=\"badgeName\"]"));
        Thread.sleep(5000);
        String ExpectedAwardName = AwardName.getAttribute("value");
        System.out.println("value" + ExpectedAwardName);
        assertEquals(ExpectedAwardName, ActualAwardName + randomNumber);

        WebElement Description = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("description"));
        assertEquals(Description, description + randomNumber);

        WebElement FundName = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("FundNameTextBoxLoc"));
        assertEquals(FundName, fundName);

        WebElement Points = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("bigfishPoint"));
        assertEquals(Points, points);

        WebElement Status = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("status"));
        assertEquals(Status, status);

    }

    @And("Verify the {string} name or Employee {string} on the Award Edit page")
    public void verifyTheRoleNameOrEmployeeOnTheAwardEditPage(String scopeType, String scopeName) {

        List<String> SName = SplitString(scopeName,",");
        if (scopeType.equals("role")) {
            //for select Role
            WebElement ScopeName = driver.findElement(RecognitionBasePage.getLocatorToVerifySelectRoleOnAwardPage(scopeName));
            assertEquals(ScopeName, SName);
        } else {
            //for Select user
            WebElement ScopeName = driver.findElement(RecognitionBasePage.getLocatorToVerifySelectEmployeeOnAwardPage(scopeName));
            assertEquals(ScopeName, SName);
        }
    }

    @And("User on Assign Award detail Page Select award {string} for the list.")
    public void userOnAwardDetailPageSelectAwardForTheList(String AwardName) throws InterruptedException {
        while (true) {
            if (isElementVisible(RecognitionBasePage.getLocatorToSelectAwardInCarusel(AwardName + randomNumber))) {
                WebElement AwardCard = driver.findElement(RecognitionBasePage.getLocatorToSelectAwardInCarusel(AwardName + randomNumber));
                AwardCard.click();
                break;
            } else {    //As there are multiple awards created on env Temp adding click for multiple time
                    for(int i=0;i<=5;i++){
                        if (isElementVisible(RecognitionBasePage.getLocatorForField("CaurosalRightArrowBtn")))
                        {
                            Thread.sleep(500);
                            WebElement RightArrow = driver.findElement(RecognitionBasePage.getLocatorForField("CaurosalRightArrowBtn"));
                            RightArrow.click();
                        }
                        else
                        {
                            break;
                        }
                    }
                }

            }

        }


    @And("Search and select {string} Recognition {string} from list.")
    public void searchAndSelectAwardFromAwardList(String AwardName ,String RecognitionValue) throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(RecognitionBasePage.getLocatorForField("RecognitionDropdownToggle")).click();
        driver.findElement(RecognitionBasePage.getLocatorForRecognitionDropdownToggle(RecognitionValue)).click();
        Thread.sleep(15000);
        WebElement SearchIntTxt = driver.findElement(NominationsBasePage.getLocatorForField("SearchInputTxtField"));
        SearchIntTxt.click();
        Thread.sleep(2000);
        SearchIntTxt.sendKeys(AwardName+randomNumber);
        driver.findElement(NominationsBasePage.getLocatorForField("PublishOrSaveButton")).click();
    }

    @And("Verify the created Award following details.")
    public void verifyTheCreatedAwardFollowingDetails(DataTable tableObj) {
        List<List<String>> awardDetails = tableObj.asLists();

        String ColoumLabel1 = awardDetails.get(0).get(0);
        String awardName = awardDetails.get(0).get(1);
        String ColNo1 = awardDetails.get(0).get(2);
        WebElement ele1 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColoumLabel1,ColNo1));
        String AwardName = ele1.getText();
        System.out.println(AwardName);
        Assert.assertEquals(awardName+randomNumber, AwardName);

        String ColoumLabel2 = awardDetails.get(1).get(0);
        String awardDesc = awardDetails.get(1).get(1);
        String ColNo2 = awardDetails.get(1).get(2);
        WebElement ele2 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColoumLabel2,ColNo2));
        String AwardDesc = ele2.getText();
        System.out.println(AwardName);
        Assert.assertEquals(awardDesc+randomNumber,AwardDesc);

        String ColoumLabel3 = awardDetails.get(2).get(0);
        String awardStatus = awardDetails.get(2).get(1);
        String ColNo3 = awardDetails.get(2).get(2);
        WebElement ele3 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColoumLabel3,ColNo3));
        String AwardStatus = ele3.getText();
        System.out.println(AwardStatus);
        Assert.assertEquals(awardStatus, AwardStatus);

        String ColoumLabel4 = awardDetails.get(3).get(0);
        String awardPoints = awardDetails.get(3).get(1);
        String ColNo4 = awardDetails.get(3).get(2);
        WebElement ele4 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColoumLabel4,ColNo4));
        String AwardPoints = ele4.getText();
        System.out.println(AwardPoints);
        Assert.assertEquals(awardPoints, AwardPoints);


    }


}




