package com.bigfish.pom.pages.Surveys;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SurveyBasePage extends BasePage {
    WebDriver driver;
    public static String randomNumber;
    public SurveyBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    public static By getLocatorForField(String fieldName) {
        By LOCATOR_VALUE = null;
        switch (fieldName) {
            case "AddQuestionBtn":
                LOCATOR_VALUE = By.xpath("//button[text()=\"Add Question\"]");
                break;
            case "SurveyCriteriaSearchField":
                LOCATOR_VALUE=By.xpath("(//input[@aria-expanded=\"false\"][contains(@placeholder, 'Search by Name')])[2]");
                break;
            case "SurveyConfirmPopupBtn":
                LOCATOR_VALUE=By.xpath("(//div[contains(@class,\"modal-footer\")]//button[@type=\"button\"][text()=\"Yes\"])[2]");
                break;
            case "SurveyContinueBtn":
                LOCATOR_VALUE=By.xpath("(//div[@class=\"modal-body p ng-star-inserted\"]//button[text()=\"Continue\"])[2]");
                break;
            case "SurveyAddRuleBtn":
                LOCATOR_VALUE=By.xpath("(//span[@class=\"filterText\"])[2]");
                break;
            case "ConfirmModalBtn":
                LOCATOR_VALUE = By.xpath("ConfirmModalText=\"Publish Now\"]");
                break;
            case "StartSurveyBtn":
                LOCATOR_VALUE = By.xpath("//button[text()='Start Survey']");
                break;

            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }

//Dynamic Locator

    public static By getLocatorForAddQuestion(String QuestionNo){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("(//textarea[@placeholder=\"Add your question.\"])["+QuestionNo+"]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorForAddChoice(String QuestionNo, int ChoiceNo){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("((//textarea[@placeholder=\"Add your question.\"])["+QuestionNo+"]/ancestor::div[@class=\"form-group\"]//input[@placeholder=\"Choice\"])["+ChoiceNo+"]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorForAddQuestionType(String QuestionNo){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("(//label[text()=\"Question Type\"]/following-sibling::select)["+QuestionNo+"]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorForAddQuestionForNPQ(String QuestionNo){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("(//label[text()=\"Question Type\"]/following-sibling::select)["+QuestionNo+"]/ancestor::div[@class=\"form-group\"]/following-sibling::div//textarea");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorLabelForScalarQue(String QuestionNo, int LabelNO){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("((//textarea[@placeholder=\"Add your question.\"])["+QuestionNo+"]/ancestor::div[@class=\"form-group\"]//label[text()=\"Labels\"]/ancestor::div[@class=\"row mt\"]//input)["+LabelNO+"]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorToAddSettingsInSurvey(String ResultTypeQues,String OptionValue){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//label[contains(text(),'"+ResultTypeQues+"')]/following-sibling::div/label[contains(text(),'"+OptionValue+"')]/span");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorForSurveyActionBtnLoc(String SurveyTitle){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("(//td[contains(text(),'"+SurveyTitle+"')])[1]/ancestor::tr/td[8]//button");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorForSurveyActionValueLoc(String SurveyValue){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//button[@aria-expanded=\"true\"]/following-sibling::ul/li/a[contains(text(),'"+SurveyValue+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public static By getLocatorForPublishOrSubmitSurvey(String ActionValue){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("(//button[contains(text(),'"+ActionValue+"')])[1]");
        return DYNAMIC_LOCATOR_VALUE;
    }
}


