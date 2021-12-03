package com.bigfish.steps.nominationsSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SubmitNominationSteps extends NominationsBasePage {

    WebDriver driver;

    public SubmitNominationSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("User on submit nomination form search and select employee or Team employee to nominate.")
    public void searchAndSelectEmployeeOrTeamToNominate(List<String> Names) throws InterruptedException {
        for (int i = 0; i < Names.size(); i++) {
            String Name = Names.get(i);
            WebElement Text_Loc = driver.findElement(NominationsBasePage.getLocatorForField("SearchTextField"));
            Thread.sleep(4000);
            SearchAndSelect(Text_Loc, Name);
            Thread.sleep(4000);
            WebElement Parameter_Text_Field = driver.findElement(By.xpath("//textarea[contains(@placeholder,'Write your comments here')]"));
            WaitAndClick(Parameter_Text_Field);

            Parameter_Text_Field.sendKeys("Nomination user through automation hard coded Value in comment field");
            WebElement Submit_Button = driver.findElement(NominationsBasePage.getLocatorForField("SubmitButton"));
            WaitAndClick(Submit_Button);
            verifyTextDisplayed("Once submitted, the nomination cannot be withdrawn. Do you want to submit the nomination?");
            WebElement Submit_Button_Loc = driver.findElement(NominationsBasePage.getLocatorForField("SubmitMgsButton"));
            WaitAndClick(Submit_Button_Loc);
            driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
        }
    }

    @And("User on submit nomination form Search and select employee in Set to nominate.")
    public void searchSelectEmployeeInSetToNominate(List<String> Employees_Names) throws InterruptedException {
        for (int i = 0; i < Employees_Names.size(); i++) {
            String Name = Employees_Names.get(i);
            WebElement Text_Loc = driver.findElement(NominationsBasePage.getLocatorForField("SearchTextField"));
            Thread.sleep(4000);
            SearchAndSelect(Text_Loc, Name);
        }
        WebElement TeamLeadOption = driver.findElement(NominationsBasePage.Select_Teamlead_Radio_Btn(Employees_Names.get(0)));
        WaitAndClick(TeamLeadOption);

        WebElement Parameter_Text_Field = driver.findElement(By.xpath("//textarea[contains(@placeholder,'Write your comments here')]"));
        WaitAndClick(Parameter_Text_Field);

        Parameter_Text_Field.sendKeys("Nomination user through automation hard coded Value in comment field");
        WebElement Submit_Button = driver.findElement(NominationsBasePage.getLocatorForField("SubmitButton"));
        WaitAndClick(Submit_Button);
        verifyTextDisplayed("Once submitted, the nomination cannot be withdrawn. Do you want to submit the nomination?");
        WebElement Submit_Button_Loc = driver.findElement(NominationsBasePage.getLocatorForField("SubmitMgsButton"));
        WaitAndClick(Submit_Button_Loc);
        driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
        Thread.sleep(2000);
    }


@And("User Click on Close stage button and close the nomination {string} stage.")
public void userClickOnCloseButtonAndCloseTheStage(String StageName) throws InterruptedException {   //Close the Stage
    Thread.sleep(4000);
    try {
        WebElement StageNameBtn = driver.findElement(NominationsBasePage.Stage_Header_Button(StageName));
        scrollToElement(StageNameBtn, "click");
    }
    catch (Exception e) {
        System.out.println("Header is already selected.");
    }
    WebElement Close_Btn = driver.findElement(NominationsBasePage.getLocatorForField("CloseButton"));
    WaitAndClick(Close_Btn);

    WebElement Mgs_Close_Btn = driver.findElement(NominationsBasePage.getLocatorForField("CloseStageButton"));
    WaitAndClick(Mgs_Close_Btn);

    WebElement Confirm_Button = driver.findElement(NominationsBasePage.getLocatorForField("ConfirmButton"));
    WaitAndClick(Confirm_Button);
   }

    @And("User clicks on move nominee button and select option {string} and move nominees")
    public void closeAndMoveTheUsersToAnotherStage(String Move_Nominee_Option, List<String> Employees_Names) throws InterruptedException
{   //Close the Stage

        //Select the User to be MoveForword or move all
        WebElement Move_Nominee_Btn = driver.findElement(NominationsBasePage.getLocatorForField("MoveNomineeButton"));
        WaitAndClick(Move_Nominee_Btn);

        if (Move_Nominee_Option.equals("MOVE ALL")) {
            Thread.sleep(2000);
            WebElement Move_All_Value = driver.findElement(NominationsBasePage.Move_Nominee_Options(Move_Nominee_Option));
            WaitAndClick(Move_All_Value);

            WebElement Move_All_Msg_Btn = driver.findElement(NominationsBasePage.getLocatorForField("MoveAllMessageBtn"));
            WaitAndClick(Move_All_Msg_Btn);

            WebElement Success_Msg_Btn = driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn"));
            WaitAndClick(Success_Msg_Btn);
        } else {
            if (Move_Nominee_Option.equals("MOVE FORWORD")) {
                for (int i = 0; i<Employees_Names.size();i++) {
                    String Employee_Name = Employees_Names.get(i);
                    //Need to Add loop for multiple employee
                    WebElement Select_Employee_Choice = driver.findElement(NominationsBasePage.Select_Employees_Checkbox(Employee_Name));
                    WaitAndClick(Select_Employee_Choice);

                    WebElement Move_Forward_Value = driver.findElement(NominationsBasePage.Move_Nominee_Options(Move_Nominee_Option));
                    WaitAndClick(Move_Forward_Value);
                }
            }

        }

    }
    @And("User click on Give Award button of the Nomination award.")
    public void userClickOnGiveAwardButtonAndGiveAwayTheNominationAward(List<String> Employees_Names) {
        for (int i = 0; i < Employees_Names.size(); i++) {
            String Employee_Name = Employees_Names.get(i);
            WebElement Select_Employee_Choice = driver.findElement(NominationsBasePage.Select_Employees_Checkbox(Employee_Name));
            WaitAndClick(Select_Employee_Choice);
        }
            WebElement Give_Award_Button = driver.findElement(NominationsBasePage.getLocatorForField("GiveAwardButton"));
            WaitAndClick(Give_Award_Button);

    }

}




