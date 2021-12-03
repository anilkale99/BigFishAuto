package com.bigfish.steps.nominationsSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VoteNominationSteps extends NominationsBasePage {
    WebDriver driver;
    public  VoteNominationSteps(ContextSteps contextSteps){
        super(contextSteps);
        driver= contextSteps.getDriver();

    }
    @And("User on Voting detail page select employee or team and click on button to vote.")
    public void UserOnVotingDetailPageSelectUserOrTeamAndVote(List<String> Employee_Name) throws InterruptedException {
        for(int i=0;i<Employee_Name.size();i++) {
            WebElement EmployeeList = driver.findElement(NominationsBasePage.Select_Employees_Checkbox(Employee_Name.get(i)));
           scrollToElement(EmployeeList,"click");
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
        driver.findElement(NominationsBasePage.getLocatorForField("VoteButton")).click();
        WebElement ValidationCommentField=  driver.findElement(NominationsBasePage.getLocatorForField("VotingCommentField"));
        ValidationCommentField.sendKeys("Automation Voting Comment added");
        WebElement ActionChoiceBtn = driver.findElement(NominationsBasePage.User_action_choice("VOTE"));
        scrollToElement(ActionChoiceBtn,"click");
        driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
        driver.navigate().refresh();
    }

    @And("User on voting stage select the set of employee and vote in nomination.")
    public void userOnVotingStageSelectTheSetOfEmployeeAndVoteInNomination(List<String> TeamLead_Name) throws InterruptedException {
        for(int i=0;i<TeamLead_Name.size();i++) {
            WebElement EmployeeList = driver.findElement(NominationsBasePage.getLocatorForCheckboxForSetOfEmp(TeamLead_Name.get(i)));
            scrollToElement(EmployeeList,"click");
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
        driver.findElement(NominationsBasePage.getLocatorForField("VoteButton")).click();
        WebElement ValidationCommentField=  driver.findElement(NominationsBasePage.getLocatorForField("VotingCommentField"));
        ValidationCommentField.sendKeys("Automation Voting Comment added");
        WebElement ActionChoiceBtn = driver.findElement(NominationsBasePage.User_action_choice("VOTE"));
        scrollToElement(ActionChoiceBtn,"click");
        driver.findElement(NominationsBasePage.getLocatorForField("MessageClosebtn")).click();
        driver.navigate().refresh();
    }
}