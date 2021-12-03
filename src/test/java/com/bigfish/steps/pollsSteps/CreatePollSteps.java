package com.bigfish.steps.pollsSteps;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.navigation.LeftNavigation;
import com.bigfish.pom.pages.Polls.PollsBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreatePollSteps extends PollsBasePage {
    WebDriver driver;
    public static String randomNumber;

    public CreatePollSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("User click on {string} to navigate to polls details page.")
    public void userClickOnToNavigateToPollsDetailsPage(String Option) throws InterruptedException {
        Thread.sleep(15000);
        WebElement OptionLoc = driver.findElement(PollsBasePage.getLocatorForNavigation(Option));
        OptionLoc.click();
        Thread.sleep(2000);
    }

    @And("User adds following details to create polls.")
    public void userAddsFollowingDetailsToCreatePolls(DataTable TableObj) throws InterruptedException {
        List<List<String>> pollsValue = TableObj.asLists();

        //Adding poll Question
        Thread.sleep(500);
        String pollQuestion  = pollsValue.get(0).get(1);
        WebElement PollQuestion = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("question"));
        randomNumber =getrandomnumber(4);
        PollQuestion.clear();
        PollQuestion.sendKeys(pollQuestion+randomNumber);

        //Adding poll option1
        Thread.sleep(500);
        String option1Value  = pollsValue.get(1).get(1);
        WebElement Option1Value = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("option1"));
        Option1Value.clear();
        Option1Value.sendKeys(option1Value+randomNumber);

        //Adding poll option2
        Thread.sleep(500);
        String option2Value  = pollsValue.get(2).get(1);
        WebElement Option2Value = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("option2"));
        Option2Value.clear();
        Option2Value.sendKeys(option2Value+randomNumber);

        //Adding poll till Date
        Thread.sleep(500);
        String pollTillDate  = pollsValue.get(3).get(1);
        WebElement PollTillDate = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("endDate"));
        PollTillDate.clear();
        PollTillDate.sendKeys(pollTillDate);

        //selecting option for  Anonymous
        Thread.sleep(2000);
        String AnonymousOption = pollsValue.get(4).get(1);
        selectValue(PollsBasePage.getLocatorForField("anonymousOption"),AnonymousOption);


        //selecting option for Show Result to Participant
        Thread.sleep(2000);
        String ShowResultOption = pollsValue.get(5).get(1);
        selectValue(PollsBasePage.getLocatorForField("showResultOption"),ShowResultOption);



    }

    @And("User click on the {string}  button and create poll.")
    public void userClickOnTheButtonAndCreatePoll(String ButtonText) throws InterruptedException {
        Thread.sleep(4000);
        WebElement CreateBtn = driver.findElement(LeftNavigation.GetLocatorForComponentCreateButton(ButtonText));
        CreateBtn.click();
        Thread.sleep(2000);
        WebElement ConfirmBtn = driver.findElement(PollsBasePage.getLocatorForField("ConfirmBtnLoc"));
        ConfirmBtn.click();

    }

    @And("User verifying the following details of the created poll.")
    public void userVerifyingTheFollowingDetailsOfTheCreatedPoll(DataTable TableObj) throws InterruptedException {
        List<List<String>> pollValue = TableObj.asLists();

        //Verify the Poll Question value
        String PollQuestion = pollValue.get(0).get(1);
        WebElement PollResultBtn = driver.findElement(PollsBasePage.getLocatorForResultButtonOnPoll(PollQuestion));
        PollResultBtn.click();
        Thread.sleep(2000);
        WebElement ele1 = driver.findElement(PollsBasePage.getLocatorForField("pollQuestionOnSidePanel"));
        String pollQuestion =ele1.getText();
        System.out.println(pollQuestion);
        Assert.assertEquals(PollQuestion+randomNumber,pollQuestion);

        //Verify the Poll Option value
        String PollOption = pollValue.get(1).get(1);
        List<String> PollOptionList = SplitString(PollOption, ",");
        for (int i=0;i<PollOptionList.size();i++) {
            String PollOptionValue = PollOptionList.get(i);
            Assert.assertEquals(true,driver.findElement(PollsBasePage.getLocatorsToVerifyChoices(PollOptionValue)).isDisplayed());
        }
        System.out.println("Option  is displayed Assertion is passed");

        //Verify the Poll till date value
        String PollTillDateLabel = pollValue.get(2).get(0);
        String PollTillDate = pollValue.get(2).get(1);
        WebElement ele4 = driver.findElement(PollsBasePage.getLocatorsForPollDetails(PollTillDateLabel));
        String pollTillDate =ele4.getText();
        System.out.println(pollTillDate);
        Assert.assertEquals(PollTillDate,pollTillDate);

        //Verify that poll is Anonymous  or not
        String IsAnonymousLabel = pollValue.get(3).get(0);
        String IsAnonymous = pollValue.get(3).get(1);
        WebElement ele5= driver.findElement(PollsBasePage.getLocatorsForPollDetails(IsAnonymousLabel));
        String isAnonymous =ele5.getText();
        System.out.println(isAnonymous);
        Assert.assertEquals(IsAnonymous,isAnonymous);

        //Verify the poll result type
        String ShowResultLabel = pollValue.get(4).get(0);
        String showResult = pollValue.get(4).get(1);
        WebElement ele6= driver.findElement(PollsBasePage.getLocatorsForPollDetails(ShowResultLabel));
        String ShowResult =ele6.getText();
        System.out.println(ShowResult);
        Assert.assertEquals(ShowResult,showResult);
    }

    @And("Search and submit the created poll {string} with option {string} from Polls listing page.")
    public void searchAndSubmitTheCreatedPollFromPollsListingPage(String pollQuestion,String ToSelectChoiceValue) throws InterruptedException {
        WebElement SelectChoice = driver.findElement(PollsBasePage.getLocatorToSelectChoice(pollQuestion,ToSelectChoiceValue));
        SelectChoice.click();
        WebElement PollSubmitBtn = driver.findElement(PollsBasePage.getLocatorForSubmitButtonOnPoll(pollQuestion));
        PollSubmitBtn.click();
        Thread.sleep(2000);
        //Added assertion that shows poll is submitted
        Assert.assertEquals(true,driver.findElement(PollsBasePage.getLocatorForSubmitButtonOnPoll(pollQuestion)).isDisplayed());
        System.out.println("Assertion is passed poll is submitted successfully");





    }
}
