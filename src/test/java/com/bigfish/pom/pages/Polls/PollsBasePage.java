package com.bigfish.pom.pages.Polls;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PollsBasePage extends BasePage {
    WebDriver driver;

    public PollsBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }


    public static By getLocatorForField(String fieldName){
        By LOCATOR_VALUE = null;
        switch(fieldName) {
            case "anonymousOption":
                LOCATOR_VALUE = By.xpath("//span[@class=\"text-muted\"]/ancestor::div[@class=\"form-group\"]/select");
            break;
            case "showResultOption":
                LOCATOR_VALUE = By.xpath("//span[@class=\"text-muted\"]/ancestor::div[@class=\"form-group\"]/following-sibling::div/select");
                break;
            case "ConfirmBtnLoc":
                LOCATOR_VALUE = By.xpath("//div[@class=\"modal-footer\"]/button[text()=\"YES, PUBLISH\"]");
                break;
            case "pollQuestionOnSidePanel":
                LOCATOR_VALUE = By.xpath("//div[contains(@class,\"modal-body\")]//div[@class=\"rectangle-header\"]");
                break;
            case "Option1value":
                LOCATOR_VALUE = By.xpath("(//div[@class=\"radio c-radio p0\"]//input)[1]");
                break;
            case "Option2value":
                LOCATOR_VALUE = By.xpath("(//div[@class=\"radio c-radio p0\"]//input)[2]");
                break;
            case "PollTillDate":
                LOCATOR_VALUE = By.xpath("");
                break;

            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }
//DynamicLocator
    public static By getLocatorForNavigation(String Option)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//span[text()='"+Option+"']");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorForResultButtonOnPoll(String pollQuestion)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//div[contains(text(),'"+pollQuestion+"')]/ancestor::div[contains(@id,\"rectangle\")]//*[contains(text(),\"Result\")]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorForSubmitButtonOnPoll(String pollQuestion)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//div[contains(text(),'"+pollQuestion+"')]/ancestor::div[contains(@id,\"rectangle\")]//*[contains(text(),\"Submit\")]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorToSelectChoice(String pollQuestion,String SelectChoice)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//div[contains(text(),'"+pollQuestion+"')]/ancestor::div[@class=\"p-20\"]//label[contains(text(),'"+SelectChoice+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public static By getLocatorsForPollDetails(String pollDetails)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//div[@class=\"modal-body pt0\"]//*[contains(text(),'"+pollDetails+"')]/ancestor::div[contains(@class,\"row\")]//div[2]");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By getLocatorsToVerifyChoices(String pollOptionText)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//label[text()=\"Total Responses \"]/ancestor::div[@class=\"row \"]/following-sibling::div/div[contains(text(),'"+pollOptionText+"')]");
        return DYNAMIC_LOCATOR_VALUE;
    }

}