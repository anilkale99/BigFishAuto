package com.bigfish.steps.discussionSteps;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Announcement.AnnouncementBasePage;
import com.bigfish.pom.pages.Discussion.DiscussionBasePage;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DiscussionSteps extends DiscussionBasePage{
    WebDriver driver;
    public static String randomNumber;
    public DiscussionSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }
    @And("User on create Discussion page add following details")
    public void userOnCreateDiscussionPageAddFollowingDetails(DataTable tableObj) throws InterruptedException {
        List<List<String>> discussionValue = tableObj.asLists();

        //select Category from the dropdown
        String eventCategory = discussionValue.get(0).get(1);
        selectValue(eventCategory,"category");

        //Entering value in Discussion name field
        String DiscussionName = discussionValue.get(1).get(1);
        randomNumber = getrandomnumber(4);
        WebElement CampName =driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("title"));
        Thread.sleep(2000);
        CampName.sendKeys(DiscussionName+randomNumber);

        //Entering Value in Discussion Question field
        String Description = discussionValue.get(2).get(1);
        WebElement Ques =driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("discussion"));
        Ques.click();
        Ques.sendKeys(Description+randomNumber);
    }

    @And("Search and click the Discussion {string} in discussion list.")
    public void searchAndClickTheDiscussionInDiscussionList(String Discussion_Name) throws InterruptedException {
        Thread.sleep(2000);
        WebElement DiscussionName = driver.findElement(CommonLocators.SearchCreatedComponentInList(Discussion_Name + randomNumber));
        Thread.sleep(2000);
        DiscussionName.click();
    }
    @And("User on Update Discussion page add following details")
    public void userOnUpdateDiscussionPageAddFollowingDetails(DataTable tableObj) throws InterruptedException {
        List<List<String>> discussionValue = tableObj.asLists();

        //Entering value in Discussion name field
        String DiscussionName = discussionValue.get(0).get(1);
        randomNumber = getrandomnumber(4);
        Thread.sleep(2000);
        WebElement discussionName =driver.findElement(DiscussionBasePage.getLocatorForField("EditDiscussionTitle"));
        discussionName.clear();
        discussionName.sendKeys(DiscussionName+randomNumber);

        //Entering Value in Discussion Question field
        String Description = discussionValue.get(1).get(1);
        WebElement Ques =driver.findElement(DiscussionBasePage.getLocatorForField("EditDiscussionDesc"));
        Ques.clear();
        Ques.sendKeys(Description+randomNumber);
        discussionName.click();     //Done button seen disable so clicking on discussion name.
    }
    @And("User on  Discussion page verify following details")
    public void userOnDiscussionPageVerifyFollowingDetails(DataTable tableObj) throws InterruptedException {
        List<List<String>> eventValue = tableObj.asLists();
        //Verify the Discussion name value
        Thread.sleep(2000);
        WebElement ele1 = driver.findElement(DiscussionBasePage.getLocatorForField("DiscussionTitle"));
        String discussionName =ele1.getText();
        System.out.println(discussionName);
        String DiscussionName = eventValue.get(0).get(1);
        Assert.assertEquals(DiscussionName+randomNumber,discussionName);

        //Verify the Description value
        WebElement ele2 = driver.findElement(DiscussionBasePage.getLocatorForField("DiscussionQuestion"));
        String dicussionQues =ele2.getText();
        System.out.println(dicussionQues);
        String DiscussionQues = eventValue.get(1).get(1);
        Assert.assertEquals(DiscussionQues+randomNumber,dicussionQues);

        //Verify The Category Value
        WebElement ele3 = driver.findElement(AnnouncementBasePage.getLocatorForField("AnnouncementCategory"));
        String CategoryName =ele3.getText();
        System.out.println(CategoryName);
        String categoryName = eventValue.get(2).get(1);
        Assert.assertEquals(CategoryName,categoryName);

    }

}
