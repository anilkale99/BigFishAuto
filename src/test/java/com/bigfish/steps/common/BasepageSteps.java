package com.bigfish.steps.common;

import com.bigfish.pom.common.*;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Campaign.CampaignBasePage;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.NoSuchElementException;

public class BasepageSteps extends BasePage {
    WebDriver driver;

    public BasepageSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @And("Add Criteria in Components while creating.")
    public void addCriteriaInComponentsWhileCreating(DataTable tableObj) throws Throwable {
        List<List<String>> CriteriaTable = tableObj.asLists();

        for (int i = 0; i < CriteriaTable.size(); i++) {
            String ViewOrSetCriteriaLink = CriteriaTable.get(i).get(0);

            //Get the second element of the list
            String Criteria = CriteriaTable.get(i).get(1);
            //Splitting the Variable into Array
            List<String> CriteriaList = SplitString(Criteria, ",");
            String Scope_rule_Value = CriteriaList.get(0);
            Thread.sleep(2000);
            //Try catch block is added for scrolling the page up in nomination
            try {
                if (driver.findElements(NominationsBasePage.getLocatorForField("NominationPageTitle")).size() > 0) {
                    WebElement NominationTitle = driver.findElement(NominationsBasePage.getLocatorForField("NominationPageTitle"));
                    scrollToElement(NominationTitle, "No_click");
                }
            } catch (NoSuchElementException e) {
                System.out.println("Criteria is for :" + ViewOrSetCriteriaLink);
            }
            try {
                WebElement CriteriaLink = driver.findElement(CommonLocators.getLocatorToSelectCriteriaStageLink(ViewOrSetCriteriaLink));
                CriteriaLink.click();
            } catch (Exception e) {
            }

            SelectRuleFromDropdown(Scope_rule_Value);
            for (int j = 1; j < CriteriaList.size(); j++) {
                String Scope_search_value = CriteriaList.get(j);
                SetAudienceScope(Scope_rule_Value, Scope_search_value);
            }
            for (int k = 1; k <= 4; k++) {
                try {
                    WebDriverWait wait = new WebDriverWait(driver, 1);
                    WebElement Locator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@aria-labelledby='mySmallModalLabel']//button[contains(., 'Save Criteria') or contains(., 'Apply')])[" + k + "]")));
                    Locator.click();
                    break;
                } catch (Exception e) {
                }
            }
        }
    }

    @And("User click on action button and select {string} from dropdown.")
    public void userClickOnActionButtonAndSelectFromDropdown(String Action_Value) throws InterruptedException {
        Thread.sleep(4000);
        WaitAndClick(driver.findElement(CampaignBasePage.getLocatorForField("ActionBtnLoc")));
        WaitAndClick(driver.findElement(CampaignBasePage.ActionButtonLoc(Action_Value)));
        Thread.sleep(2000);
        if (driver.findElement(By.xpath("//div[contains(@class,\"modal-footer\")]//button[@type=\"button\"][text()=\"Yes\"]")).isDisplayed()) {
            driver.findElement(By.xpath("//div[contains(@class,\"modal-footer\")]//button[@type=\"button\"][text()=\"Yes\"]")).click();
        }

    }
}