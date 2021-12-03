package com.bigfish.steps.nominationsSteps;
import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.pages.Announcement.AnnouncementBasePage;
import com.bigfish.pom.pages.Discussion.DiscussionBasePage;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.hu.De;
import org.junit.Assert;
import org.openqa.selenium.*;
import com.bigfish.pom.common.ContextSteps;
import io.cucumber.java.en.And;
import io.cucumber.datatable.DataTable;


import java.util.List;

public class CreateNominationSteps extends NominationsBasePage {

	WebDriver driver;
	public static String randomNumber;

	public CreateNominationSteps(ContextSteps contextSteps) {
		super(contextSteps);
		driver = contextSteps.getDriver();
	}


	//Creation steps
	@And("User on Nominations clicks on new {string} field")
	public void UserOnNominationsClicksOnNewNominationsField(String fieldName) throws InterruptedException {
		Thread.sleep(6000);
		WebElement CreateNomiBtn = driver.findElement(NominationsBasePage.getLocatorForField(fieldName));
		WaitForElementToBeVisible(CreateNomiBtn);
		CreateNomiBtn.click();
	}

	@Then("User create nomination Adding Values.")
	public void userCreateNominationAddingValues(DataTable tableObj) throws Throwable {
		List<List<String>> NominationValue = tableObj.asLists();

//  Enter value in nomination title
		String Nomination_Process_Name = NominationValue.get(0).get(1);
		randomNumber = getrandomnumber(4);
		driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("title")).clear();
		enterValue(BasePage.getlocatorForFieldsOnDetailpage("title"), Nomination_Process_Name + randomNumber, "title");


//   Enter value in nomination for field
		String Nomination_for = NominationValue.get(1).get(1);
		Thread.sleep(6000);
		WebElement Nomination_for_dropdown = driver.findElement(NominationsBasePage.getLocatorForField("awardName"));
		NGAngularSearchAndSelectDropdown(Nomination_for_dropdown, Nomination_for);


//   Enter value in description field
		String Nomination_guidelines = NominationValue.get(2).get(1);
		driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("description")).clear();
		enterValue(BasePage.getlocatorForFieldsOnDetailpage("description"), Nomination_guidelines + randomNumber, "description");


//   Enter value in award for field.
		String Awardfor = NominationValue.get(3).get(1);
		WebElement Award_for_dropdown = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("awardType"));
		NGAngularSearchAndSelectDropdown(Award_for_dropdown, Awardfor);

//   Enter value in	Self Nomination Setting field
		if (!Awardfor.equals("Predefined Team")) {
			String Self_Nomination_Setting = NominationValue.get(4).get(1);
			WebElement Nomi_Setting_dropdown = driver.findElement(NominationsBasePage.getLocatorForField("selfNomination"));
			NGAngularSearchAndSelectDropdown(Nomi_Setting_dropdown, Self_Nomination_Setting);
		}
//	  Enter Value in Max Nominations field
		String Max_Nominations = NominationValue.get(5).get(1);
		WebElement MaxNomi_Setting_dropdown = driver
				.findElement(BasePage.getlocatorForFieldsOnDetailpage("noOfNominations"));
		NGAngularSearchAndSelectDropdown(MaxNomi_Setting_dropdown, Max_Nominations);

//Enter max employee in a set
		if (Awardfor.equals("Set of Employees")) {
			String Max_Emp_In_Set = NominationValue.get(6).get(1);
			WebElement Max_employee_in_set_dropdown = driver
					.findElement(NominationsBasePage.getLocatorForField("Max Employees"));
			NGAngularSearchAndSelectDropdown(Max_employee_in_set_dropdown, Max_Emp_In_Set);
		}
	}
	//User click on save and defined button
	@And("User on nominations form clicks on save and defined button")
	public void UserOnNominationsClicksOnSaveAndDefineWorkflowButton()
			throws InterruptedException {
		driver.findElement(NominationsBasePage.getLocatorForField("SaveDefButton")).click();
		driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
	}

	@And("User on nomination form clicks on Publish button to publish nomination.")
	public void UserOnNominationFormClicksOnPublishButtonToPublishNomination()
			throws InterruptedException {
		WebElement Publish_Btn = driver.findElement(NominationsBasePage.getLocatorForField("PublishOrSaveButton"));
		Publish_Btn.click();
		driver.switchTo().activeElement();
		WebElement PriviewBtn = driver.findElement(NominationsBasePage.getLocatorForField("PriviewPublishButton"));
		scrollToElement(PriviewBtn, "click");
		Thread.sleep(3000);
		WaitAndClick(driver.findElement(NominationsBasePage.getLocatorForField("ConfirmMessageBtn")));
		driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
	}

	@Then("User Update nomination Adding Values.")
	public void userUpdateNominationAddingValues(DataTable tableObj) throws Throwable {
		List<List<String>> NominationUpdatedValue = tableObj.asLists();
		Thread.sleep(2000);
		driver.findElement(NominationsBasePage.User_action_choice("EDIT")).click();
//   Clear and Update value in description field
		Thread.sleep(15000);
		String Nomination_guidelines = NominationUpdatedValue.get(0).get(1);
		WebElement Desc = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("description"));
		Desc.clear();
		Desc.sendKeys(Nomination_guidelines+randomNumber);

//   Clear and Update value in	Self Nomination Setting field
		String AwardFor = NominationUpdatedValue.get(2).get(1);
		if (!AwardFor.equals("Predefined Team")) {
			String Self_Nomination_Setting = NominationUpdatedValue.get(1).get(1);
			Thread.sleep(4000);
			WebElement Nomi_Setting_dropdown = driver.findElement(NominationsBasePage.getLocatorForField("selfNomination"));
			NGAngularSearchAndSelectDropdown(Nomi_Setting_dropdown, Self_Nomination_Setting);
		}
//	  Clear and Update value in Max Nominations field
		String Max_Nominations = NominationUpdatedValue.get(2).get(1);
		WebElement MaxNomi_Setting_dropdown = driver
				.findElement(NominationsBasePage.getLocatorForField("Max Nomination"));
		NGAngularSearchAndSelectDropdown(MaxNomi_Setting_dropdown, Max_Nominations);

//   Clear and Update value in max employee in a set
		if (AwardFor.equals("Set of Employees")) {
			String Max_Emp_In_Set = NominationUpdatedValue.get(4).get(1);
			WebElement Max_employee_in_set_dropdown = driver
					.findElement(NominationsBasePage.getLocatorForField("Max Employees"));
			NGAngularSearchAndSelectDropdown(Max_employee_in_set_dropdown, Max_Emp_In_Set);
		}

	}

	//Verification Steps
	@And("User on Nominations list page searching {string} nomination and clicks on {string}.")
	public void SearchingCreatedNominationInList(String Nomination_Title, String Action) throws InterruptedException {
		WebElement Nomination_Title_Link = driver.findElement(NominationsBasePage.getLocatorForField("NominationPageTitle"));
		WaitForElementToBeVisible(Nomination_Title_Link);
		try {
			WebElement Action_button = driver.findElement(Loc_for_nomination_name_in_list(Nomination_Title, Action));
			WaitAndClick(Action_button);
		} catch (NoSuchElementException e) {
			WebElement Action_button = driver.findElement(Loc_for_nomination_name_in_list(Nomination_Title, Action));
			scrollToElement("LoadMoreBtn", "click");
			WaitAndClick(Action_button);
		}

	}

	@And("User on  Nomination details page verify the created nomination details")
	public void userOnNominationDetailsPageVerifyTheCreatedNominationDetails(DataTable tableObj) throws InterruptedException {
		List<List<String>> eventValue = tableObj.asLists();
		//Verify the Nomination nameTitle value
		Thread.sleep(2000);
		WebElement ele1 = driver.findElement(CreateNominationSteps.getLocatorForField("getNominationTitle"));
		String nominationTitle = ele1.getText();
		System.out.println(nominationTitle);
		String NominationTitle = eventValue.get(0).get(1);
		Assert.assertEquals(NominationTitle+randomNumber, nominationTitle);

		//Verify the Nomination Description value
		WebElement ele2 = driver.findElement(CreateNominationSteps.getLocatorForField("NominationDesc"));
		String nominationDesc = ele2.getText();
		System.out.println(nominationDesc);
		String NominationDesc = eventValue.get(1).get(1);
		Assert.assertEquals(NominationDesc+randomNumber, nominationDesc);

		//Verify The Award Name Value
		WebElement ele3 = driver.findElement(CreateNominationSteps.getLocatorForField("AwardName"));
		String awardName = ele3.getText();
		System.out.println(awardName);
		String AwardName = eventValue.get(2).get(1);
		Assert.assertEquals(AwardName, awardName);

		//Verify The Award For Value
		WebElement ele4 = driver.findElement(CreateNominationSteps.getLocatorForField("AwardFor"));
		String awardFor = ele4.getText();
		System.out.println(awardName);
		String AwardFor = eventValue.get(3).get(1);
		Assert.assertEquals(AwardFor, awardFor);

	}
}

