package com.bigfish.steps.surveysSteps;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.pages.Recognition.RecognitionBasePage;
import com.bigfish.pom.pages.Surveys.SurveyBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SurveySteps extends SurveyBasePage {
    WebDriver driver;
    public static String randomNumber;

    public SurveySteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("User adding Survey Title {string} and description {string} to create survey.")
    public void userAddingSurveyTitleAndDescriptionToCreateSurvey(String SurveyTitle, String SurveyDesc) throws InterruptedException {
        randomNumber = getrandomnumber(4);
        Thread.sleep(500);
        WebElement surveyTitle = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("surveyName"));
        surveyTitle.clear();
        surveyTitle.sendKeys( randomNumber+SurveyTitle );

        WebElement surveyDesc = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("surveyDescription"));
        surveyDesc.clear();
        surveyDesc.sendKeys( randomNumber+SurveyDesc);

    }

    @And("User adding the Single choice, Multiple choice,Dropdown or scale Question in survey.")
    public void userAddingTheSingleChoiceMultipleChoiceDropdownOrScaleQuestionInSurvey(DataTable tableObj) throws InterruptedException {
        List<List<String>> surveyQuestionDetail = tableObj.asLists();

        //getQuestionNumber
        String QuestionNo = surveyQuestionDetail.get(0).get(1);
        int QueNo = Integer.parseInt(QuestionNo);
        if (QueNo != 1) {
            Thread.sleep(2000);
            WebElement AddQueButton = driver.findElement(SurveyBasePage.getLocatorForField("AddQuestionBtn"));
            AddQueButton.click();
        }

        //getQuestionType
        Thread.sleep(2000);
        String QuestionType = surveyQuestionDetail.get(1).get(1);
        selectValue(SurveyBasePage.getLocatorForAddQuestionType(QuestionNo), QuestionType);

        //getQuestion
        Thread.sleep(2000);
        String Question = surveyQuestionDetail.get(2).get(1);
        WebElement SurveyQuestion = driver.findElement(SurveyBasePage.getLocatorForAddQuestion(QuestionNo));
        SurveyQuestion.clear();
        SurveyQuestion.sendKeys(Question);
        if (!QuestionType.equals("Scale Question")) {
            //getQuestionChoice
            String ChoiceOption = surveyQuestionDetail.get(3).get(1);
            List<String> ChoiceList = SplitString(ChoiceOption, ",");
            int j;
            int i;
            for (i = 1, j = 0; i <= ChoiceList.size(); i++, j++) {
                WebElement Options = driver.findElement(SurveyBasePage.getLocatorForAddChoice(QuestionNo, i));
                String Choice = ChoiceList.get(j);
                Options.clear();
                Options.sendKeys(Choice);
            }
        } else {
            System.out.println("the question is Scale question");
            String labelOption = surveyQuestionDetail.get(3).get(1);
            List<String> LabelList = SplitString(labelOption, ",");
            int j;
            int i;
            for (i = 1, j = 0; i <= LabelList.size(); i++, j++) {
                WebElement Label = driver.findElement(SurveyBasePage.getLocatorLabelForScalarQue(QuestionNo, i));
                String LabelValue = LabelList.get(j);
                Label.clear();
                Label.sendKeys(LabelValue);
            }
        }
    }

    @And("User adding the Simple Text Input,Long test Question or Net Promoter Score Question in survey.")
    public void userAddingTheSimpleTextInputLongTestQuestionOrNetPromoterScoreQuestionInSurvey(DataTable tableObj) throws InterruptedException {
        List<List<String>> surveyQuestionDetail = tableObj.asLists();
        //QuestionNumber
        String QuestionNo = surveyQuestionDetail.get(0).get(1);
        int QueNo = Integer.parseInt(QuestionNo);
        if (QueNo != 1) {
            Thread.sleep(2000);
            WebElement AddQueButton = driver.findElement(SurveyBasePage.getLocatorForField("AddQuestionBtn"));
            AddQueButton.click();
        }
        //getQuestionType
        Thread.sleep(500);
        String QuestionType = surveyQuestionDetail.get(1).get(1);
        selectValue(SurveyBasePage.getLocatorForAddQuestionType(QuestionNo), QuestionType);
        //getQuestion
        if (!QuestionType.equals("Net Promoter Score")) {
            Thread.sleep(2000);
            String Question = surveyQuestionDetail.get(2).get(1);
            WebElement surveyQuestion = driver.findElement(SurveyBasePage.getLocatorForAddQuestion(QuestionNo));
            surveyQuestion.clear();
            surveyQuestion.sendKeys(Question);
        } else {
            Thread.sleep(2000);
            String Question = surveyQuestionDetail.get(2).get(1);
            WebElement surveyQuestion = driver.findElement(SurveyBasePage.getLocatorForAddQuestionForNPQ(QuestionNo));
            surveyQuestion.clear();
            surveyQuestion.sendKeys(Question);

        }

    }

    @And("Add and edit Criteria in Survey while creating.")
    public void addAndEditCriteriaInSurveyWhileCreating(DataTable tableObj) throws InterruptedException {
        List<List<String>> CriteriaTable = tableObj.asLists();

        for (int i = 0; i < CriteriaTable.size(); i++) {
            //Get the second element of the list
            String Criteria = CriteriaTable.get(i).get(1);
            //Splitting the Variable into Array
            List<String> CriteriaList = SplitString(Criteria, ",");
            String Scope_rule_Value = CriteriaList.get(0);

            //clickn on Add rule in surveys
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement AddRuleLocator = wait.until(ExpectedConditions.elementToBeClickable(SurveyBasePage.getLocatorForField("SurveyAddRuleBtn")));
            AddRuleLocator.click();

            //Select rule from dropdown
            WebElement Value_Locator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class,'dropdown-menu animated')]/li/a[contains(text(),'" + Scope_rule_Value + "')]")));
            Value_Locator.click();
            //confirm Scope popup
            if (driver.findElements(SurveyBasePage.getLocatorForField("SurveyConfirmPopupBtn")).size() > 0) {
                WebElement Locator = wait.until(ExpectedConditions.elementToBeClickable(SurveyBasePage.getLocatorForField("SurveyConfirmPopupBtn")));
                Locator.click();
            }
            for (int j = 1; j < CriteriaList.size(); j++) {
                String Scope_search_value = CriteriaList.get(j);
                Thread.sleep(2000);
                WebElement Text_field = driver.findElement(SurveyBasePage.getLocatorForField("SurveyCriteriaSearchField"));
                WebDriverWait wait1 = new WebDriverWait(driver, 50);
                wait1.until(ExpectedConditions.elementToBeClickable(Text_field)).click();
                Text_field.sendKeys(Scope_search_value);
                Thread.sleep(2000);
                Text_field.sendKeys(Keys.ARROW_DOWN);
                Text_field.sendKeys(Keys.ENTER);
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement Locator = wait.until(ExpectedConditions.elementToBeClickable(SurveyBasePage.getLocatorForField("SurveyContinueBtn")));
        Locator.click();
    }

    @And("User adding Following settings in survey while creating.")
    public void userAddingFollowingSettingsInSurveyWhileCreating(DataTable tableObj) throws InterruptedException {
        List<List<String>> CriteriaTable = tableObj.asLists();
        if (CriteriaTable.size() > 1) {
            Thread.sleep(2000);
            String ResultTypeQues = CriteriaTable.get(0).get(0);
            String ResultTypeOption = CriteriaTable.get(0).get(1);
            WebElement ResultTypeOptionLocator = driver.findElement(SurveyBasePage.getLocatorToAddSettingsInSurvey(ResultTypeQues, ResultTypeOption));
            ResultTypeOptionLocator.click();

            Thread.sleep(2000);
            String ModeOfSurveyQues = CriteriaTable.get(1).get(0);
            String ModeOfSurveyOption = CriteriaTable.get(1).get(1);
            WebElement ModeOfSurveyOptionLocator = driver.findElement(SurveyBasePage.getLocatorToAddSettingsInSurvey(ModeOfSurveyQues, ModeOfSurveyOption));
            ModeOfSurveyOptionLocator.click();
        } else {
            Thread.sleep(2000);
            String ModeOfSurveyQues = CriteriaTable.get(0).get(0);
            String ModeOfSurveyOption = CriteriaTable.get(0).get(1);
            WebElement ModeOfSurveyOptionLocator = driver.findElement(SurveyBasePage.getLocatorToAddSettingsInSurvey(ModeOfSurveyQues, ModeOfSurveyOption));
            System.out.println(ModeOfSurveyOptionLocator);
            ModeOfSurveyOptionLocator.click();

        }
    }

    @And("user adding dates in Surveys while creating.")
    public void userAddingDatesInSurveysWhileCreating(DataTable tableObj) throws InterruptedException {
        List<List<String>> SurveyDate = tableObj.asLists();
        Thread.sleep(2000);
        String StartDate = SurveyDate.get(0).get(1);
        TypeDateInTxtField("startDate", StartDate);

        Thread.sleep(2000);
        String EndDate = SurveyDate.get(1).get(1);
        TypeDateInTxtField("endDate", EndDate);

    }

    @And("User click on the {string} button and confirm {string} to create Survey.")
    public void userClickOnTheButtonAndCreateSurvey(String ButtonAction,String ConfirmModalText) throws InterruptedException {
        {
            Thread.sleep(4000);
            WebElement CreateBtn = driver.findElement(SurveyBasePage.getLocatorForPublishOrSubmitSurvey(ButtonAction));
            CreateBtn.click();
            Thread.sleep(4000);
            WebElement ConfirmBtn = driver.findElement(RecognitionBasePage.getLocatorToSubmitAssignAward(ConfirmModalText));
            ConfirmBtn.click();

        }
    }

    @And("User on  details page {string} submitting by clicking on {string} button.")
    public void userOnSurveyDetailsPageTheCreatedSurvey(String SurveyTitle, String ActionValue) throws InterruptedException {
        Thread.sleep(4000);
        try {
            WebElement ActionBtnLoc = driver.findElement(SurveyBasePage.getLocatorForSurveyActionBtnLoc(randomNumber + SurveyTitle));
            ActionBtnLoc.click();
            WebElement ActionValueLoc = driver.findElement(SurveyBasePage.getLocatorForSurveyActionValueLoc(ActionValue));
            ActionValueLoc.click();
        }
        catch (Exception e){
            WebElement TakeSurveyBtnLoc = driver.findElement(By.xpath("(//td[contains(text(),'"+randomNumber+SurveyTitle+"')])[1]/ancestor::tr/td[6]//button"));
            TakeSurveyBtnLoc.click();

        }
    }

    @And("User on Submit survey page adding following choices.")
    public void userOnSubmitSurveyPageAddingFollowingChoices(DataTable tableObj) throws InterruptedException {
        List<List<String>> submitSurveyDetail = tableObj.asLists();

        WebElement StartSurveyBtn = driver.findElement(SurveyBasePage.getLocatorForField("StartSurveyBtn"));
        StartSurveyBtn.click();
        for (int i=0;i<submitSurveyDetail.size();i++) {
            String QuestionType = submitSurveyDetail.get(i).get(0);
            String SurveyQuestion = submitSurveyDetail.get(i).get(1);
            String SurveyChoices = submitSurveyDetail.get(i).get(2);
            switch (QuestionType) {

                case "Single Choice":
                    Thread.sleep(1000);
                    WebElement SinChoice_Que = driver.findElement(By.xpath("//label[contains(text(),'" + SurveyQuestion
                            + "')]/ancestor::div[@class=\"panel-body p\"]//label[contains(@class,\"radio-inline\")][contains(.,'"
                            + SurveyChoices + "')]/span"));
                    SinChoice_Que.click();
                    if (driver.findElements(By.xpath("//label[contains(text(),'" + SurveyQuestion + "')]/ancestor::div//button[text()='Next']")).size() != 0) {
                        Thread.sleep(1000);
                        driver.findElement(By.xpath("//label[contains(text(),'" + SurveyQuestion + "')]/ancestor::div//button[text()='Next']")).click();
                    } else {
                        System.out.println("Its A last Question");
                    }
                    break;

                case "Multi Choice":
                    Thread.sleep(1000);
                    if (SurveyChoices.contains(",")) {
                        List<String> SurveyChoiceList = SplitString(SurveyChoices, ",");
                        for (int j = 0; j < SurveyChoiceList.size(); j++) {
                            String SurveyChoice = SurveyChoiceList.get(j);
                            WebElement MulCh_Ques = driver.findElement(By.xpath("//label[contains(text(),'" + SurveyQuestion
                                    + "')]/ancestor::div[@class=\"panel-body p\"]//label[contains(@class,\"checkbox c-checkbox\")][text()='"
                                    + SurveyChoice + "']/span"));
                            MulCh_Ques.click();

                        }
                    } else{
                                WebElement MulCh_Ques = driver.findElement(By.xpath("//label[contains(text(),'" + SurveyQuestion
                                + "')]/ancestor::div[@class=\"panel-body p\"]//label[contains(@class,\"checkbox c-checkbox\")][text()='"
                                + SurveyChoices + "']/span"));
                                MulCh_Ques.click();
                          }
                        if (driver.findElements(By.xpath("//label[contains(text(),'" + SurveyQuestion + "')]/ancestor::div//button[text()='Next']")).size() != 0) {
                            driver.findElement(By.xpath("//label[contains(text(),'" + SurveyQuestion + "')]/ancestor::div//button[text()='Next']")).click();
                        } else {
                            System.out.println("Its A last Question");
                        }
                        break;

                case "Scale Question":
                    Thread.sleep(1000);
                    WebElement ScaleQues = driver.findElement(By.xpath("//label[contains(text(),'" +SurveyQuestion
                            + "')]/ancestor::div[@class=\"panel-body p\"]//span[text()='" + SurveyChoices
                            + "']/ancestor::label/span[1]"));
                    ScaleQues.click();
                    if(driver.findElements(By.xpath("//label[contains(text(),'" +SurveyQuestion+ "')]/ancestor::div//button[text()='Next']")).size()!= 0){
                        driver.findElement(By.xpath("//label[contains(text(),'" +SurveyQuestion+ "')]/ancestor::div//button[text()='Next']")).click();
                    }
                    else{
                        System.out.println("Its A last Question");
                    }
                    break;
                case "Text Input":
                    Thread.sleep(1000);
                    WebElement TextInput = driver.findElement(By.xpath("//label[contains(text(),'" +SurveyQuestion
                            + "')]/ancestor::div[@class=\"panel-body p\"]//textarea"));
                    TextInput.sendKeys(SurveyChoices);
                    if(driver.findElements(By.xpath("//label[contains(text(),'" +SurveyQuestion+ "')]/ancestor::div//button[text()='Next']")).size()!= 0){
                        driver.findElement(By.xpath("//label[contains(text(),'" +SurveyQuestion+ "')]/ancestor::div//button[text()='Next']")).click();
                    }
                    else{
                        System.out.println("Its A last Question");
                    }
                    break;
                case "Dropdown":
                    Thread.sleep(1000);
                    selectValue(By.xpath("//label[contains(text(),'" +SurveyQuestion + "')]/ancestor::div[@class=\"panel-body p\"]//select"),SurveyChoices);
                    if(driver.findElements(By.xpath("//label[contains(text(),'" +SurveyQuestion+ "')]/ancestor::div//button[text()='Next']")).size()!= 0){
                        driver.findElement(By.xpath("//label[contains(text(),'" +SurveyQuestion+ "')]/ancestor::div//button[text()='Next']")).click();
                    }
                    else{
                        System.out.println("Its A last Question");
                    }
                    break;
                default:
                    System.out.println("browser : " +SurveyQuestion+ "Question type is not provide or invalid...!! ");
                    break;
            }
        }

    }

}