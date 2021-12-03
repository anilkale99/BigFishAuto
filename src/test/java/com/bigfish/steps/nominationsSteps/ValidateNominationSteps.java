package com.bigfish.steps.nominationsSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.java.en.And;
import io.cucumber.java.mk_latn.No;
import org.openqa.selenium.*;

import java.util.List;

public class ValidateNominationSteps extends NominationsBasePage {
    WebDriver driver;

    public ValidateNominationSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("User click on initiate button to initiate {string} process.")
    public void UserClickOnInitiateButtonToInitiateProcess(String StageHeaderName) throws InterruptedException {
        Thread.sleep(2000);
        WebElement StageHeaderBtn = driver.findElement(NominationsBasePage.Stage_Header_Button(StageHeaderName));
        scrollToElement(StageHeaderBtn, "click");
        Thread.sleep(2000);
        WebElement InitiateBtn = driver.findElement(NominationsBasePage.getLocatorForField("InitiateButton"));
        WaitAndClick(InitiateBtn);
        Thread.sleep(2000);
        WebElement InitiateMsgBtn = driver.findElement(NominationsBasePage.getLocatorForField("InitiateMsgButton"));
        WaitAndClick(InitiateMsgBtn);
    }
    @And("User click on view details link and validated employee by {string} the {string} Nomination process.")
    public void UserOnValidateDetailPageValidateTheUserInList(String Action,String Award_for,List<String> Employees_Names) throws InterruptedException {
        for (int i = 0; i<Employees_Names.size();i++) {
            String Employee_Name= Employees_Names.get(i);
            Thread.sleep(2000);
            WebElement SearchIntTxt = driver.findElement(NominationsBasePage.getLocatorForField("SearchInputTxtField"));
            WaitAndClick(SearchIntTxt);
            Thread.sleep(2000);
            SearchIntTxt.sendKeys(Employee_Name);
            driver.findElement(NominationsBasePage.getLocatorForField("PublishOrSaveButton")).click();

            WebElement ViewDetailsLinks = driver.findElement(NominationsBasePage.Validation_View_Details_Link(Employee_Name));
            WaitAndClick(ViewDetailsLinks);
            verifyTextDisplayed("LIST OF NOMINATIONS RECEIVED");
            WebElement ValidationViewLink = driver.findElement(NominationsBasePage.Validation_View_Details_Link2(Employee_Name));
            scrollToElement(ValidationViewLink, "click");

            WebElement UserActionChoice = driver.findElement(NominationsBasePage.User_action_choice(Action));
            UserActionChoice.click();
            WebElement ValidationCommentfield = driver.findElement(NominationsBasePage.getLocatorForField("ValidationCommentField"));
            ValidationCommentfield.sendKeys("Automation Validation Comment added");
            WebElement ActionBtn =  driver.findElement(NominationsBasePage.User_action_choice(Action));
            scrollToElement(ActionBtn, "click");
            driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
            Thread.sleep(2000);
            driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
            driver.navigate().refresh();
        }
    }


    @And("User on validation detail page {string} the Set of employee with team leader {string}.")
    public void userOnValidationDetailPageValidateTheSetOfEmployeeWithTeamLeader(String Action,String TeamLeaderName) throws InterruptedException {
        Thread.sleep(2000);
        WebElement ViewDetailLink = driver.findElement(NominationsBasePage.getLocatorForViewDetailLinkForSetOfEmp(TeamLeaderName));
        ViewDetailLink.click();
        Thread.sleep(2000);
        driver.findElement(NominationsBasePage.getLocatorForField("ViewDetailLink")).click();
        Thread.sleep(2000);
        WebElement UserActionChoice = driver.findElement(NominationsBasePage.User_action_choice(Action));
        UserActionChoice.click();
        WebElement ValidationCommentField = driver.findElement(NominationsBasePage.getLocatorForField("ValidationCommentField"));
        ValidationCommentField.sendKeys("Automation Validation Comment added");
        WebElement ActionBtn =  driver.findElement(NominationsBasePage.User_action_choice(Action));
        scrollToElement(ActionBtn, "click");
        driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.tagName("body")).sendKeys(Keys.HOME);
        driver.navigate().refresh();


    }
}