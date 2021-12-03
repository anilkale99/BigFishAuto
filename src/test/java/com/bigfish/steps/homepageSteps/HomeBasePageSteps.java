package com.bigfish.steps.homepageSteps;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Homepage.HomeBaseBage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomeBasePageSteps extends HomeBaseBage {
    WebDriver driver;

    public HomeBasePageSteps(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    @Then("Apply Home page Filter with option {string}.")
    public void applyHomePageFilterWithOption(String filterOption) throws InterruptedException {
        Thread.sleep(15000);
        driver.findElement(CommonLocators.getLocatorForField("AllFilterDropdownBtn")).click();
        List<String> Option = SplitString(filterOption,",");
        for (int i = 0; i < Option.size(); i++) {
            driver.findElement(CommonLocators.getLocatorForHomePageFilterOption(Option.get(i))).click();
        }
        driver.findElement(CommonLocators.getLocatorForField("FilterApplyBtn")).click();
    }

}