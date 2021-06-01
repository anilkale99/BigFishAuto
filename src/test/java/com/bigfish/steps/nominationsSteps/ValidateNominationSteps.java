package com.bigfish.steps.nominationsSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ValidateNominationSteps extends NominationsBasePage {
    WebDriver driver;

    public ValidateNominationSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("User click on initiate button to initiate {string} process.")
    public void User_click_on_initiate_button_to_initiate_process(String StageHeaderName) throws InterruptedException {
        scrollToElement(NominationsBasePage.Stage_Header_Button(StageHeaderName), "click");
        Thread.sleep(2000);
        WebElement InitiateBtn = driver.findElement(NominationsBasePage.getLocatorForField("InitiateButton"));
        WaitAndClick(InitiateBtn);
        Thread.sleep(2000);
        WebElement InitiateMsgBtn = driver.findElement(NominationsBasePage.getLocatorForField("InitiateMsgButton"));
        WaitAndClick(InitiateMsgBtn);
    }
    @And("User click on view details link and validated employee by {string} the {string} Nomination process.")
    public void User_on_validate_detail_page_validate_the_user_in_list(String Action,String Award_for,List<String> Employees_Names) throws InterruptedException {
        for (int i = 0; i<Employees_Names.size();i++) {
            String Employee_Name= Employees_Names.get(i);
            Thread.sleep(2000);
            WebElement SearchIntTxt = driver.findElement(NominationsBasePage.getLocatorForField("SearchInputTxtField"));
            WaitAndClick(SearchIntTxt);
            Thread.sleep(2000);
            SearchIntTxt.sendKeys(Employee_Name);
            driver.findElement(NominationsBasePage.getLocatorForField("PublishButton")).click();

            WebElement ViewDetailsLinks = driver.findElement(NominationsBasePage.Validation_View_Details_Link(Employee_Name));
            WaitAndClick(ViewDetailsLinks);
            verifyTextDisplayed("LIST OF NOMINATIONS RECEIVED");
            scrollToElement(NominationsBasePage.Validation_View_Details_Link2(Employee_Name), "click");

            WebElement UserActionChoice = driver.findElement(NominationsBasePage.User_action_choice(Action));
            UserActionChoice.click();
            WebElement ValidationCommentfield = driver.findElement(NominationsBasePage.getLocatorForField("ValidationCommentField"));
            ValidationCommentfield.sendKeys("Automation Validation Comment added");
            scrollToElement(NominationsBasePage.User_action_choice(Action), "click");
            driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
            Thread.sleep(2000);
            driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
            driver.navigate().refresh();
        }
    }


}