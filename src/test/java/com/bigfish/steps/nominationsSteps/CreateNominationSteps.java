package com.bigfish.steps.nominationsSteps;

import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.*;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class CreateNominationSteps extends NominationsBasePage {

	WebDriver driver;
	public static int randomNumber;

	public CreateNominationSteps(ContextSteps contextSteps) {
		super(contextSteps);
		driver = contextSteps.getDriver();
	}

	//Creation steps
	@When("User on Nominations clicks on new {string} field")
	public void User_on_nominations_clicks_on_new_nominations_field(String fieldName) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		clickElement(NominationsBasePage.getLocatorForField(fieldName));
	}

	@And("User on nomination form enter {string} in title field")
	public void User_on_nomination_form_enters_title(String Nomination_Process_Name) {
		randomNumber = getrandomnumber();
		driver.findElement(NominationsBasePage.getLocatorForField("title")).clear();
		enterValue(NominationsBasePage.getLocatorForField("title"), Nomination_Process_Name + randomNumber, "title");
		System.out.println("Nomination_Process_Name+randomNumber");
	}

	@And("User on nomination form enter {string} in nomination for field")
	public void User_on_nomination_form_enters_Nominationfor(String Nomination_for) throws InterruptedException {
		Thread.sleep(6000);
		WebElement Nomination_for_dropdown = driver.findElement(NominationsBasePage.getLocatorForField("awardName"));
		NGAngularSearchAndSelectDropdown(Nomination_for_dropdown, Nomination_for);
	}

	@And("User on nomination form enter {string} in description field")
	public void User_on_nomination_form_enters_description(String Nomination_guidelines) {
		driver.findElement(NominationsBasePage.getLocatorForField("description")).clear();
		enterValue(NominationsBasePage.getLocatorForField("description"), Nomination_guidelines + randomNumber, "description");
	}

	@And("User on nomination form enter {string} in award for field")
	public void User_on_nomination_form_enters_Award_for(String Award_For) throws InterruptedException {
		WebElement Award_for_dropdown = driver.findElement(NominationsBasePage.getLocatorForField("awardType"));
		NGAngularSearchAndSelectDropdown(Award_for_dropdown, Award_For);
	}

	@And("User on nomination form enter {string} in Max employee in a set field")
	public void User_on_nomination_form_enters_Max_employee_in_a_set(String Max_Emp_In_Set)
			throws InterruptedException {
		WebElement Max_employee_in_set_dropdown = driver
				.findElement(NominationsBasePage.getLocatorForField("noOfEmployees"));
		NGAngularSearchAndSelectDropdown(Max_employee_in_set_dropdown, Max_Emp_In_Set);

	}

	@And("User on nomination form enter {string} and {string} and {string} in Criteria field")
	public void User_on_nomination_form_click_on_criteria_link_and_add_scope(String Scope_rule_Value, String RuleBtnIndex, String RuleValueIndex, List<String> Scope_search_value_List)
			throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(CommonLocators.getLocatorForField("Select_Criteria_Link")).click();
		SelectRuleFromDropdown(Scope_rule_Value,RuleBtnIndex,RuleValueIndex);
		for (int i = 0; i < Scope_search_value_List.size(); i++) {
			String Scope_search_value = Scope_search_value_List.get(i);
			Setaudiencescope(Scope_rule_Value, Scope_search_value);
		}
		driver.findElement(By.xpath("(//div[@aria-labelledby='mySmallModalLabel']//button[text()='Save Criteria'])["+RuleBtnIndex+"]")).click();
	}

	@And("User on nomination form enter {string} in Self Nomination Setting field")
	public void User_on_nomination_form_enters_Self_nomi_setting(String Self_Nomination_Setting)
			throws InterruptedException {
		WebElement Nomi_Setting_dropdown = driver.findElement(NominationsBasePage.getLocatorForField("selfNomination"));
		NGAngularSearchAndSelectDropdown(Nomi_Setting_dropdown, Self_Nomination_Setting);
	}

	@And("User on nomination form enter {string} in Max Nominations field")
	public void User_on_nomination_form_enters_Max_nomination(String Max_Nominations) throws InterruptedException {
		WebElement MaxNomi_Setting_dropdown = driver
				.findElement(NominationsBasePage.getLocatorForField("noOfNominations"));
		NGAngularSearchAndSelectDropdown(MaxNomi_Setting_dropdown, Max_Nominations);
	}

	@And("User on nominations form clicks on {string} button")
	public void User_on_nominations_clicks_on_Save_and_Define_Workflow_button(String fieldName)
			throws InterruptedException {
		driver.findElement(NominationsBasePage.getLocatorForField("SaveDefButton")).click();
		driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
	}

	@And("User on nomination Stage I workflow part of form enters {string} and {string} and {string} in Criteria field")
	public void User_on_nomination_form_click_on_criteria_link_and_add_scope_for_stageI(String Scope_rule_Value_Stage1,
																						 String RuleBtnIndex, String RuleValueIndex,List<String> Scope_search_value_List)
			throws InterruptedException {
		scrollToElement(NominationsBasePage.getLocatorForField("NominationPageTitle"), "No_click");
		Thread.sleep(3000);
		driver.findElement(CommonLocators.getLocatorForField("Select_Criteria_Link1")).click();
		SelectRuleFromDropdown(Scope_rule_Value_Stage1,RuleBtnIndex,RuleValueIndex);
		for (int i = 0; i < Scope_search_value_List.size(); i++) {
			String Scope_search_value_Stage1 = Scope_search_value_List.get(i);
			Thread.sleep(2000);
			Setaudiencescope(Scope_rule_Value_Stage1, Scope_search_value_Stage1);
		}
		driver.findElement(By.xpath("(//div[@aria-labelledby='mySmallModalLabel']//button[text()='Save Criteria'])["+RuleBtnIndex+"]")).click();
	}

	@And("User on nomination Stage II workflow part of form enters {string} and {string} and {string} in Criteria field")
	public void User_on_nomination_form_click_on_criteria_link_and_add_scope_for_stageII(String Scope_rule_Value_Stage2,
																						  String RuleBtnIndex, String RuleValueIndex,List<String> Scope_search_value_List)
			throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(CommonLocators.getLocatorForField("Select_Criteria_Link2")).click();
		SelectRuleFromDropdown(Scope_rule_Value_Stage2,RuleBtnIndex,RuleValueIndex);
		for (int i = 0; i < Scope_search_value_List.size(); i++) {
			String Scope_search_value_Stage2 = Scope_search_value_List.get(i);
			Setaudiencescope(Scope_rule_Value_Stage2, Scope_search_value_Stage2);
		}
		driver.findElement(By.xpath("(//div[@aria-labelledby='mySmallModalLabel']//button[text()='Save Criteria'])["+RuleBtnIndex+"]")).click();
	}

	@And("User on nomination Stage III workflow part of form enters {string} and {string} and {string} in Criteria field")
	public void User_on_nomination_form_click_on_criteria_link_and_add_scope_for_stageIII(
			String Scope_rule_Value_Stage3, String RuleBtnIndex, String RuleValueIndex, List<String> Scope_search_value_List) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(CommonLocators.getLocatorForField("Select_Criteria_Link3")).click();
		SelectRuleFromDropdown(Scope_rule_Value_Stage3,RuleBtnIndex,RuleValueIndex);
		for (int i = 0; i < Scope_search_value_List.size(); i++) {
			String Scope_search_value_Stage3 = Scope_search_value_List.get(i);
			Setaudiencescope(Scope_rule_Value_Stage3, Scope_search_value_Stage3);
		}
		driver.findElement(By.xpath("(//div[@aria-labelledby='mySmallModalLabel']//button[text()='Save Criteria'])["+RuleBtnIndex+"]")).click();
	}

	@And("User on nomination form clicks on {string} button to publish nomination.")
	public void User_on_nomination_form_clicks_on_publish_button_to_publish_nomination(String fieldName)
			throws InterruptedException {
		WebElement Publish_Btn = driver.findElement(NominationsBasePage.getLocatorForField(fieldName));
		WaitAndClick(Publish_Btn);
		driver.switchTo().activeElement();
		scrollToElement(NominationsBasePage.getLocatorForField("PriviewPublishButton"), "click");
		Thread.sleep(3000);
		WaitAndClick(driver.findElement(NominationsBasePage.getLocatorForField("ConfirmMessageBtn")));
		driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();


	}

	//Verification Steps
	@And("User on Nominations list page searching {string} nomination and clicks on {string}.")
	public void Searching_created_nomination(String Nomination_Title, String Action) throws InterruptedException {
		WebElement Nomination_Title_Link = driver.findElement(NominationsBasePage.getLocatorForField("NominationPageTitle"));
		WaitForElementToBeVisible(Nomination_Title_Link);
		try {
			WebElement Action_button = driver.findElement(Loc_for_nomination_name_in_list(Nomination_Title+randomNumber, Action));
			WaitAndClick(Action_button);
		} catch (NoSuchElementException e) {
			WebElement Action_button = driver.findElement(Loc_for_nomination_name_in_list(Nomination_Title+randomNumber, Action));
			scrollToElement("LoadMoreBtn", "click");
			WaitAndClick(Action_button);
		}

	}

	@And("Verify the nomination title field {string} of the created nomination.")
	public void Verify_the_nomination_title_field_of_the_created_nomination(String Nominationtitle) {

	}

	@And("Verify the nomination for field {string} of the created nomination.")
	public void Verify_the_nomination_For_field_of_the_created_nomination(String NominationFor) {
		verifyTextDisplayed(NominationFor + randomNumber);
	}

	@And("Verify the nomination guideline field {string} of the created nomination.")
	public void Verify_the_nomination_guideline_of_the_created_nomination() {

	}

	@And("Verify the award for field {string} of the created nomination.")
	public void Verify_the_award_For_of_the_created_nomination(String AwardFor) {
		verifyTextDisplayed(AwardFor);
	}

	@And("Verify the Max Employees In A Set field {string} of the created nomination.")
	public void Verify_the_max_employees_in_a_set_field_of_the_created_nomination() {

	}

	@And("Verify the Self Nomination Setting field {string} of the created nomination.")
	public void Verify_the_max_nominations_submitted_field_of_the_created_nomination(String MaxNomSetting) {
		verifyTextDisplayed(MaxNomSetting);
	}

	@And("Verify the Max Nominations Submitted field {string} of created nomination.")
	public void Verify_the_max_nomination_submitted_field_of_the_created_nomination() {

	}

	@And("Verify the scope of the created nomination")
	public void Verify_the_scope_of_the_created_nomination() {

	}

}