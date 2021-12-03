package com.bigfish.steps.announcementSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Announcement.AnnouncementBasePage;
import com.bigfish.pom.pages.Campaign.CampaignBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AnnouncementSteps extends AnnouncementBasePage {
    WebDriver driver;
    public static String randomNumber;
    public AnnouncementSteps(ContextSteps contextSteps)  {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }
    @And("User on create Announcement page add {string} banner image.")
    public void userOnCreateAnnouncementPageAddBannerImage(String BannerImage) throws InterruptedException {
        Thread.sleep(4000);
        uploadADocument(By.id("file4"), BannerImage);
    }

    @And("User adding following attachment while creating")
    public void userAddingFollowingAttachmentWhileCreating(DataTable tableObj) throws InterruptedException {
        List<List<String>> AttachmentFileValue = tableObj.asLists();
            //Get the element from the list
            String AttachmentFiles = AttachmentFileValue.get(0).get(1);
            //Splitting the Variable into Array
            List<String> AttachmentFilesList = SplitString(AttachmentFiles, ",");
        for (int i = 0; i < AttachmentFilesList.size(); i++) {
            String AttachmentFile = AttachmentFilesList.get(i);
            Thread.sleep(2000);
            uploadADocument(By.id("file2"), AttachmentFile);
        }
    }

    @And("User on create Announcement page add following details")
    public void userOnCreateCampaignPageAddFollowingDetails(DataTable tableObj) throws Exception {
        List<List<String>> announcementValue = tableObj.asLists();
        //Entering value in Announcement name field
        String AnnouncementName = announcementValue.get(0).get(1);
        randomNumber = getrandomnumber(4);
        WebElement announcementName =driver.findElement(CampaignBasePage.getLocatorForFormTextField("title"));
        Thread.sleep(2000);
        announcementName.clear();
        announcementName.sendKeys(AnnouncementName+randomNumber);

        //Entering Value in Description field
        String Description = announcementValue.get(1).get(1);
        WebElement Desc =driver.findElement(AnnouncementBasePage.getLocatorForField("AnnouncementDesc"));
        Desc.click();
        Desc.clear();
        Desc.sendKeys(Description+randomNumber);

        //select Category from the dropdown
        String announcementCategory = announcementValue.get(2).get(1);
        selectValue(announcementCategory,"category");
    }

    @And("Search and click the Announcement {string} in Announcement list.")
    public void searchAndClickTheAnnouncementInAnnouncementList(String Announcement_Name) throws InterruptedException {
        Thread.sleep(2000);
        WebElement AnnouncementName = driver.findElement(CommonLocators.SearchCreatedComponentInList(Announcement_Name+randomNumber));
        Thread.sleep(2000);
        AnnouncementName.click();
    }


    @And("User click on circle dot button and select {string} from dropdown.")
    public void userClickOnCircleDotButtonAndSelectFromDropdown(String DropdownValue) throws InterruptedException {
        Thread.sleep(2000);
        WebElement CircularDotButton = driver.findElement(AnnouncementBasePage.getLocatorForField("DotButtonLoc"));
        CircularDotButton.click();
        WebElement AnnouncementDropdownValue = driver.findElement(AnnouncementBasePage.getLocatorForAnnouncementDropdownValue(DropdownValue));
        AnnouncementDropdownValue.click();
    }

    @And("User on  Announcement page verify following details")
    public void userOnAnnouncementPageVerifyFollowingDetails(DataTable tableObj) throws InterruptedException {
        List<List<String>> announcementValue = tableObj.asLists();
        //Verify the Announcement name value
        Thread.sleep(2000);
        WebElement ele1 = driver.findElement(AnnouncementBasePage.getLocatorForField("AnnouncementTitle"));
        String announcementName =ele1.getText();
        System.out.println(announcementName);
        String AnnouncementName = announcementValue.get(0).get(1);
        Assert.assertEquals(AnnouncementName+randomNumber,announcementName);

        //Verify the Description value
        WebElement ele2 = driver.findElement(AnnouncementBasePage.getLocatorForField("AnnouncementDescLoc"));
        String discName =ele2.getText();
        System.out.println(discName);
        String DiscName = announcementValue.get(1).get(1);
        Assert.assertEquals(DiscName+randomNumber,discName);

        //Verify The Category Value
        WebElement ele3 = driver.findElement(AnnouncementBasePage.getLocatorForField("AnnouncementCategory"));
        String CategoryName =ele3.getText();
        System.out.println(CategoryName);
        String categoryName = announcementValue.get(2).get(1);
        Assert.assertEquals(CategoryName,categoryName);
    }

    @And("User click on the {string} button to create announcement.")
    public void userClickOnTheButtonToCreateAnnouncement(String ButtonText) throws InterruptedException {
        Thread.sleep(4000);
        WebElement CreateBtn = driver.findElement(AnnouncementBasePage.GetLocatorForAnnouncementCreateButton(ButtonText));
        CreateBtn.click();
        Thread.sleep(4000);
    }

}
