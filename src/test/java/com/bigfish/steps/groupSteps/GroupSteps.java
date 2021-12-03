package com.bigfish.steps.groupSteps;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Announcement.AnnouncementBasePage;
import com.bigfish.pom.pages.Groups.GroupsBasePage;
import com.bigfish.pom.pages.Campaign.CampaignBasePage;
import com.bigfish.steps.eventSteps.EventSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class GroupSteps extends GroupsBasePage {
    WebDriver driver;
    public static String randomNumber;
    public GroupSteps(ContextSteps contextSteps)
    {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("User on create Group page add following details.")
    public void userOnCreateGroupPageAddFollowingDetails(DataTable tableObj) throws InterruptedException {
        List<List<String>> GroupValue = tableObj.asLists();

        //Entering value in Group Title field
        String GroupName = GroupValue.get(0).get(1);
        randomNumber = getrandomnumber(4);
        WebElement groupName =driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("groupName"));
        Thread.sleep(2000);
        groupName.clear();
        groupName.sendKeys(GroupName+randomNumber);

        //Entering Value in Description field
        String Description = GroupValue.get(1).get(1);
        WebElement Desc =driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("discription"));
        Desc.click();
        Desc.clear();
        Desc.sendKeys(Description+randomNumber);

        //select Category from the dropdown
        String GroupCategory = GroupValue.get(2).get(1);
        selectValue(GroupCategory,"category");
        //add Group Image
        String GroupImage = GroupValue.get(3).get(1);
        Thread.sleep(2000);
        uploadADocument(By.id("file2"), GroupImage);
    }

    @And("User on Update Group page add following details.")
    public void userOnUpdateGroupPageAddFollowingDetails(DataTable tableObj) throws InterruptedException {
        List<List<String>> UP_GroupValue = tableObj.asLists();
        //Entering value in Group Title field
        String GroupName = UP_GroupValue.get(0).get(1);
        randomNumber = getrandomnumber(4);
        WebElement groupName =driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("groupName"));
        Thread.sleep(2000);
        groupName.clear();
        groupName.sendKeys(GroupName+randomNumber);

        //Entering Value in Description field
        String Description = UP_GroupValue.get(1).get(1);
        WebElement Desc =driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("discription"));
        Desc.click();
        Desc.clear();
        Desc.sendKeys(Description+randomNumber);

        //select Category from the dropdown
        String GroupCategory = UP_GroupValue.get(2).get(1);
        selectValue(GroupsBasePage.getLocatorForField("GroupCategory"),GroupCategory);

        //update Group image
        String Up_GroupImage = UP_GroupValue.get(3).get(1);
        Thread.sleep(2000);
        uploadADocument((By.xpath("(//input[@id=\"file2\"])[2]")), Up_GroupImage);

    }
    @And("Search and Select Created group {string} from the Group list.")
    public void searchAndSelectCreatedGroupFromTheGroupList(String GroupTitle) throws InterruptedException {
        Thread.sleep(2000);
        WebElement groupTitle = driver.findElement(CommonLocators.SearchCreatedComponentInList(GroupTitle + randomNumber));
        Thread.sleep(2000);
        groupTitle.click();
    }

    @And("User click on group action button and select {string} from dropdown.")
    public void userClickOnGroupActionButtonAndSelectFromDropdown(String ActionValue) throws InterruptedException {
        Thread.sleep(4000);
        WaitAndClick(driver.findElement(GroupsBasePage.getLocatorForField("GroupActionBtnLoc")));
        WaitAndClick(driver.findElement(CampaignBasePage.ActionButtonLoc(ActionValue)));
    }

    @And("User on  Group page verify following details")
    public void userOnGroupPageVerifyFollowingDetails(DataTable tableObj) throws InterruptedException {
        List<List<String>> groupValue = tableObj.asLists();

        //Verify the Group Title value
        Thread.sleep(4000);
        WebElement ele1 = driver.findElement(GroupsBasePage.getLocatorForField("GroupTitle"));
        String groupName =ele1.getText();
        System.out.println(groupName);
        String GroupName = groupValue.get(0).get(1);
        Assert.assertEquals(GroupName+randomNumber,groupName);

        //Verify the Group Description value
        WebElement ele2 = driver.findElement(GroupsBasePage.getLocatorForField("GroupDescription"));
        String groupDiscName =ele2.getText();
        System.out.println(groupDiscName);
        String GroupDiscName = groupValue.get(1).get(1);
        Assert.assertEquals(GroupDiscName+randomNumber,groupDiscName);

        //Verify The Category Value
        WebElement ele3 = driver.findElement(AnnouncementBasePage.getLocatorForField("AnnouncementCategory"));
        String GroupCategoryName =ele3.getText();
        System.out.println(GroupCategoryName);
        String groupCategoryName = groupValue.get(2).get(1);
        Assert.assertEquals(GroupCategoryName,groupCategoryName);

        //Verifying the owner name of the Group on the detail page.
        WebElement ele4 = driver.findElement(GroupsBasePage.getLocatorForField("GroupOwnerName"));
        String GroupOwnerName =ele4.getText();
        System.out.println(GroupCategoryName);
        String groupOwnerName = groupValue.get(3).get(1);
        Assert.assertEquals(GroupOwnerName,groupOwnerName);
    }

    @And("User click on the Done button and create and update Group.")
    public void userClickOnTheButtonAndCreateAndUpdateGroup() throws InterruptedException {
        Thread.sleep(2000);
        WebElement CreateBtn = driver.findElement(GroupsBasePage.getLocatorForField("CreateGroupBtn"));
        WaitAndClick(CreateBtn);

}


    }
