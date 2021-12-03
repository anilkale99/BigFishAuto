package com.bigfish.steps.campaignSteps;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Campaign.CampaignBasePage;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CampaignSteps extends CampaignBasePage {
    WebDriver driver;
    public static String randomNumber;
    public CampaignSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("User on create campaign  page add {string} banner image.")
    public void userOnCreateCampaignPageAddBannerImage(String BannerImage) {
        uploadADocument(By.id("fileCampaignBanner"),BannerImage);
    }

    @And("User on create campaign page add following details")
    public void userOnCreateCampaignPageAddFollowingDetails(DataTable tableObj) throws Exception {
        List<List<String>> campaignValue = tableObj.asLists();
    //Entering value in Campaign name field
        String CampaignName = campaignValue.get(0).get(1);
        randomNumber = getrandomnumber(4);
        WebElement CampName =driver.findElement(CampaignBasePage.getLocatorForFormTextField("name"));
        Thread.sleep(2000);
        CampName.clear();
        CampName.sendKeys(CampaignName+randomNumber);
    //Entering Value in Description field
        String Description = campaignValue.get(1).get(1);
        WebElement Desc =driver.findElement(CampaignBasePage.getLocatorForFormTextField("discription"));
        Desc.click();
        Desc.clear();
        Desc.sendKeys(Description+randomNumber);
    //Entering Value in Start date field
        Thread.sleep(2000);
        String StartDate = campaignValue.get(2).get(1);
        TypeDateInTxtField("startDate",StartDate);

    //Entering Value in End date field
        Thread.sleep(2000);
        String EndDate = campaignValue.get(3).get(1);
        TypeDateInTxtField("endDate",EndDate);
    }

    @And("User on Campaign page verify the Details added while creating.")
    public void userOnCampaignPageVerifyTheDetailsAddedWhileCreating(DataTable tableObj) {
        List<List<String>> campaignValue = tableObj.asLists();
        //Verify the campaign name value
        WebElement ele1 = driver.findElement(CampaignSteps.getLocatorForField("CampaignTitle"));
        String capName =ele1.getText();
        System.out.println(capName);
        String CampaignName = campaignValue.get(0).get(1);
        Assert.assertEquals(CampaignName+randomNumber,capName);

        //Verify the Description value
        WebElement ele2 = driver.findElement(CampaignSteps.getLocatorForField("CampaignDescription"));
        String discName =ele2.getText();
        System.out.println(discName);
        String DiscName = campaignValue.get(1).get(1);
        Assert.assertEquals(DiscName+randomNumber,discName);

        //Verify the start Date
        WebElement ele3 = driver.findElement(CampaignSteps.getLocatorForField("CampaignDate"));
        String actualStartDate =ele3.getText();
        System.out.println(actualStartDate);
        String expectedStartDate = campaignValue.get(2).get(1);
        List<String> expectedStartDateList = SplitString(actualStartDate,"-");
        Assert.assertTrue(actualStartDate.contains(expectedStartDateList.get(0)));

        //Verify the End Date
        WebElement ele4 = driver.findElement(CampaignSteps.getLocatorForField("CampaignDate"));
        String actualEndDate =ele4.getText();
        System.out.println(actualEndDate);
        String expectedEndDate = campaignValue.get(3).get(1);
        List<String> expectedEndDateList = SplitString(actualEndDate,"-");
        Assert.assertTrue(actualEndDate.contains(expectedEndDateList.get(1)));
    }

    @And("Search and click the campaign {string} in campaign list.")
    public void searchAndClickTheCampaignInCampaignList(String Camp_Name) throws InterruptedException {
        Thread.sleep(4000);
        WebElement CampaignName = driver.findElement(CommonLocators.SearchCreatedComponentInList(Camp_Name+randomNumber));
        Thread.sleep(2000);
        CampaignName.click();
    }
    @And("User click on {string} Button to participate in campaign.")
    public void userClickOnButtonToParticipateInCampaign(String ParticipateBtn) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(CampaignBasePage.ParticipateAndContributeBtnLoc(ParticipateBtn)).click();
        driver.findElement(CampaignBasePage.ParticipateAndContributeBtnLoc("CONTRIBUTE")).isDisplayed();
    }

    @Then("User click on {string} Button And contribute text {string} in Campaign post.")
    public void userClickOnButtonAndContributeTextInCampaignPost(String ContributeBtn, String TextData){
        driver.findElement(CampaignBasePage.ParticipateAndContributeBtnLoc(ContributeBtn)).click();
        WebElement ContributeTxtField =driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("contribute"));
        ContributeTxtField.sendKeys(TextData);
        driver.findElement(NominationsBasePage.getLocatorForField("SubmitButton")).click();
        driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
    }

    @Then("User click on {string} Button And contribute Image or Video {string} and Comment {string} in Campaign post.")
    public void userClickOnButtonAndContributeAndCommentInCampaignPost(String ContributeBtn, String ContributeFile, String TextData) throws InterruptedException {
        driver.findElement(CampaignBasePage.ParticipateAndContributeBtnLoc(ContributeBtn)).click();
        Thread.sleep(2000);

        uploadADocument(By.name("imageFile"),ContributeFile);
        WebDriverWait wait = new WebDriverWait(driver, 220);
        wait.until(ExpectedConditions.presenceOfElementLocated(BasePage.getlocatorForFieldsOnDetailpage("contribute")));
        WebElement ContributeTxtField =driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("contribute"));
        ContributeTxtField.sendKeys(TextData);
        driver.findElement(NominationsBasePage.getLocatorForField("SubmitButton")).click();
        driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
    }
    @And("User on Campaign Detail page click on {string} post and add {string} comment on it.")
    public void userOnCampaignDetailPageClickOnPostAndAddCommentOnIt(String TextValue, String CommentText) {
        driver.findElement(CampaignBasePage.getLocatorForTextPostOnCampaignDetailPage(TextValue)).click();
        driver.findElement(CampaignBasePage.getLocatorForField("AddCommentLoc")).sendKeys(CommentText);
        driver.findElement(CampaignBasePage.getLocatorForField("SendBtnLoc")).click();
        driver.findElement(CampaignBasePage.getLocatorForField("CloseBtn")).click();

    }

    @And("User on campaign detail page verify the text {string} added on the post.")
    public void userOnCampaignDetailPageVerifyTheCommentAddedOnThePost(String TextValue) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(CampaignBasePage.getLocatorForTextPostOnCampaignDetailPage(TextValue)).isDisplayed();
    }
}
