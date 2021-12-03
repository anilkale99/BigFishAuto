package com.bigfish.steps.eventSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Campaign.CampaignBasePage;
import com.bigfish.pom.pages.Event.EventBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EventSteps extends EventBasePage {
    WebDriver driver;
    public static String randomNumber;
    public EventSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("User on create event  page add {string} banner image.")
    public void userOnCreateEventPageAddBannerImage(String BannerImage) {
        uploadADocument(By.id("file2"), BannerImage);
    }

    @And("User on create event page add following details")
    public void userOnCreateEventPageAddFollowingDetails(DataTable tableObj) throws InterruptedException {
        List<List<String>> eventValue = tableObj.asLists();

        //Entering value in event name field
        String EventName = eventValue.get(0).get(1);
        randomNumber = getrandomnumber(4);
        WebElement eventName =driver.findElement(CampaignBasePage.getLocatorForFormTextField("eventName"));
        Thread.sleep(2000);
        eventName.clear();
        eventName.sendKeys(EventName+randomNumber);

        //Entering Value in Description field
        String Description = eventValue.get(1).get(1);
        WebElement Desc =driver.findElement(CampaignBasePage.getLocatorForFormTextField("eventContent"));
        Desc.clear();
        Desc.sendKeys(Description+randomNumber);

        //select Category from the dropdown
        String eventCategory = eventValue.get(2).get(1);
        selectValue(eventCategory,"eventCategory");

        //Entering Value in Start date HH And MM field
        Thread.sleep(2000);
        String StartDate = eventValue.get(3).get(1);
        String Hours = eventValue.get(4).get(1);
        String Minutes = eventValue.get(5).get(1);
        TypeDateInTxtField("startDate",StartDate);
        Thread.sleep(2000);
        WebElement S_Hours = driver.findElement(EventBasePage.getLocatorForHoursInDates("Start Date"));
        S_Hours.clear();
        S_Hours.sendKeys(Hours);
        Thread.sleep(2000);
        WebElement S_Minutes =  driver.findElement(EventBasePage.getLocatorForMinutesInDates("Start Date"));
        S_Minutes.clear();
        S_Minutes.sendKeys(Minutes);

        //Entering Value in End date HH And MM field
        Thread.sleep(2000);
        String EndDate = eventValue.get(6).get(1);
        String Hrs = eventValue.get(7).get(1);
        String Mins = eventValue.get(8).get(1);
        TypeDateInTxtField("endDate",EndDate);
        WebElement E_Hrs = driver.findElement(EventBasePage.getLocatorForHoursInDates("End Date"));
        E_Hrs.clear();
        E_Hrs.sendKeys(Hrs);
        WebElement E_Mins = driver.findElement(EventBasePage.getLocatorForMinutesInDates("End Date"));
        E_Mins.clear();
        E_Mins.sendKeys(Mins);

        //Entering Value in Location field
        String Location = eventValue.get(9).get(1);
        WebElement location =driver.findElement(CampaignBasePage.getLocatorForFormTextField("locationField"));
        location.clear();
        location.sendKeys(Location);

    }

    @And("User verifying the added details on the following event details")
    public void userVerifyingTheAddedDetailsOnTheFollowingEventDetails(DataTable tableObj) {
        List<List<String>> eventValue = tableObj.asLists();
        //Verify the Event name value
        WebElement ele1 = driver.findElement(EventSteps.getLocatorForField("EventTitle"));
        String eventName =ele1.getText();
        System.out.println(eventName);
        String EventName = eventValue.get(0).get(1);
        Assert.assertEquals(EventName+randomNumber,eventName);

        //Verify the Description value
        WebElement ele2 = driver.findElement(EventSteps.getLocatorForField("EventDescription"));
        String discName =ele2.getText();
        System.out.println(discName);
        String DiscName = eventValue.get(1).get(1);
        Assert.assertEquals(DiscName+randomNumber,discName);

        //Verify the Location value
        WebElement ele3 = driver.findElement(EventSteps.getLocatorForField("EventLocation"));
        String eventLoc =ele3.getText();
        System.out.println(eventLoc);
        String EventLoc= eventValue.get(2).get(1);
        Assert.assertEquals(EventLoc,eventLoc);

    }
    @And("Search and click the Event {string} in Event list.")
    public void searchAndClickTheCampaignInCampaignList(String Camp_Name) throws InterruptedException {
        Thread.sleep(2000);
        WebElement CampaignName = driver.findElement(CommonLocators.SearchCreatedComponentInList(Camp_Name + randomNumber));
        Thread.sleep(2000);
        CampaignName.click();
    }
}


