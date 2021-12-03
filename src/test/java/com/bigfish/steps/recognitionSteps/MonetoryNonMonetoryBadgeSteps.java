package com.bigfish.steps.recognitionSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Profile.EmployeeBasePage;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import com.bigfish.pom.pages.Recognition.RecognitionBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class MonetoryNonMonetoryBadgeSteps extends RecognitionBasePage {
    WebDriver driver;
    public static String randomNumber;
    public MonetoryNonMonetoryBadgeSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }
    @And("User on Badge details page add {string} in Badge name field.")
    public void userOnBadgeDetailsPageAddInAwardNameField(String badgeName) throws InterruptedException {
        Thread.sleep(2000);
        randomNumber = getrandomnumber(4);
        enterValue(RecognitionBasePage.getlocatorForFieldsOnDetailpage("badgeName"),badgeName+randomNumber,"Title");
    }
    @And("User on Badge details page add {string} in Description field.")
    public void userOnBadgeDetailsPageAddInDescriptionField(String Desc) throws InterruptedException {
        Thread.sleep(2000);
        enterValue(RecognitionBasePage.getlocatorForFieldsOnDetailpage("description"),Desc+randomNumber,"Description");
    }
    @And("User on Badge detail page add {string} in Who can give-Select roles field.")
    public void userOnBadgeDetailPageAddInWhoCanGiveSelectRolesField(String RoleName) throws InterruptedException {
        WebElement RoleNameLoc =driver.findElement(RecognitionBasePage.getlocatorForFieldsOnDetailpage("badgeSpecifier"));
        SearchAndSelect(RoleNameLoc,RoleName);
    }
    @And("User on Badge detail page add {string} in Points field.")
    public void userOnBadgeDetailPageAddInPointsField(String Points) {
        driver.findElement(RecognitionBasePage.getlocatorForFieldsOnDetailpage("bigfishPoint")).clear();
        enterValue(RecognitionBasePage.getlocatorForFieldsOnDetailpage("bigfishPoint"),Points,"Title");
    }
    @And("User on Badge detail page add {string} in criteria field")
    public void userOnBadgeDetailPageAddInCriteriaField(String CriteriaText) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(RecognitionBasePage.getLocatorForField("MonetoryBadgeCriteriaLink")).click();
        driver.findElement(RecognitionBasePage.getlocatorForFieldsOnDetailpage("paramName")).sendKeys(CriteriaText);
    }

    @And("User on Badge detail page add {string} in Status field and Save.")
    public void userOnBadgeDetailPageAddInStatusFieldAndSave(String Status) throws InterruptedException {
        selectValue(RecognitionBasePage.getlocatorForFieldsOnDetailpage("status"),Status);
        Thread.sleep(2000);
        driver.findElement(NominationsBasePage.getLocatorForField("PublishOrSaveButton")).click();
    }

    @And("User on Badge listing page  search recognition {string} click on {string} action of {string}.")
    public void userOnAwardListingPageSelectRecognitionClickOnAction(String RecognitionValue, String Option, String AttributeName) throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(RecognitionBasePage.getLocatorForField("RecognitionDropdownToggle")).click();
        driver.findElement(RecognitionBasePage.getLocatorForRecognitionDropdownToggle(RecognitionValue)).click();
        Thread.sleep(4000);
        driver.findElement(NominationsBasePage.getLocatorForField("SearchInputTxtField")).sendKeys(AttributeName + randomNumber);
        driver.findElement(NominationsBasePage.getLocatorForField("PublishOrSaveButton")).click();
        driver.findElement(CommonLocators.getLoctorForActionButtonInConfig(AttributeName + randomNumber)).click();
        driver.findElement(CommonLocators.getLoctorForActionButtonValue(Option)).click();

    }
    @And("User Click on the badge {string} from Badge list of home page.")
    public void userClickOnTheBadgeFromBadgeListOfHomePage(String NMBadgeName) {
        WebElement BadgeName =driver.findElement(RecognitionBasePage.getLocatorToSelectBadgeFromNonMonetaryListOnHomepage(NMBadgeName+randomNumber));
        BadgeName.click();
    }
    @And("Verify the created badge following details.")
    public void verifyTheCreatedAwardFollowingDetails(DataTable tableObj) {
        List<List<String>> badgeDetails = tableObj.asLists();

        String ColoumLabel1 = badgeDetails.get(0).get(0);
        String badgeName = badgeDetails.get(0).get(1);
        String ColNo1 = badgeDetails.get(0).get(2);
        WebElement ele1 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColoumLabel1,ColNo1));
        String BadgeName = ele1.getText();
        System.out.println(BadgeName);
        Assert.assertEquals(badgeName+randomNumber, BadgeName);

        String ColoumLabel2 = badgeDetails.get(1).get(0);
        String badgeDesc = badgeDetails.get(1).get(1);
        String ColNo2 = badgeDetails.get(1).get(2);
        WebElement ele2 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColoumLabel2,ColNo2));
        String BadgeDesc = ele2.getText();
        System.out.println(BadgeDesc);
        Assert.assertEquals(badgeDesc+randomNumber, BadgeDesc);

        String ColoumLabel3 = badgeDetails.get(2).get(0);
        String badgeStatus = badgeDetails.get(2).get(1);
        String ColNo3 = badgeDetails.get(2).get(2);
        WebElement ele3 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColoumLabel3,ColNo3));
        String BadgeStatus = ele3.getText();
        System.out.println(BadgeStatus);
        Assert.assertEquals(badgeStatus, BadgeStatus);

        if (badgeDetails.size()>=4){
            String ColoumLabel4 = badgeDetails.get(3).get(0);
            String badgePoints = badgeDetails.get(3).get(1);
            String ColNo4 = badgeDetails.get(3).get(2);
            WebElement ele4 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColoumLabel4,ColNo4));
            String BadgePoints = ele4.getText();
            System.out.println(BadgePoints);
            Assert.assertEquals(badgePoints, BadgePoints);
        }


    }


    @And("Search and select {string} Badge from {string}  list.")
    public void searchAndSelectBadgeFromList(String BadgeName ,String RecognitionValue) throws InterruptedException {
            Thread.sleep(10000);
            driver.findElement(RecognitionBasePage.getLocatorForField("RecognitionDropdownToggle")).click();
            driver.findElement(RecognitionBasePage.getLocatorForRecognitionDropdownToggle(RecognitionValue)).click();
            Thread.sleep(15000);
            WebElement SearchIntTxt = driver.findElement(NominationsBasePage.getLocatorForField("SearchInputTxtField"));
            SearchIntTxt.click();
            Thread.sleep(2000);
            SearchIntTxt.sendKeys(BadgeName+randomNumber);
            driver.findElement(NominationsBasePage.getLocatorForField("PublishOrSaveButton")).click();
        }

    }
