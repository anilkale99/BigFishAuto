package com.bigfish.steps.nominationsSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubmitNominationSteps extends NominationsBasePage {

    WebDriver driver;

    public SubmitNominationSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("User on submit nomination form search and select employee {string} to nominate.")
    public void search_and_select_employee_or_team_to_nominate(String Name) {
        WebElement Text_Loc=driver.findElement(NominationsBasePage.getLocatorForField("search_text_field"));
        SearchAndSelect(Text_Loc,Name);
        WebElement Parameter_Text_Field=driver.findElement(By.xpath("//textarea[contains(@placeholder,'Write your comments here')]"));
        WaitAndClick(Parameter_Text_Field);
        Parameter_Text_Field.sendKeys("Nomination user through automation hardcoaded");
        WebElement Submit_Button= driver.findElement(NominationsBasePage.getLocatorForField("search_text_field"));
        WaitAndClick(Submit_Button);
        WebElement Submit_Button_Loc= driver.findElement(NominationsBasePage.getLocatorForField("search_text_field"));
        WaitAndClick(Submit_Button_Loc);

    }




}
