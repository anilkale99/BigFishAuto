package com.bigfish.steps.common;

import com.bigfish.pom.locators.CommonLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.bigfish.pom.common.ContextSteps;
import com.bigfish.utilities.PropertiesOperation;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebElement;

public class Hooks {
	private ContextSteps contextSteps;
	WebDriver driver;
	
	public Hooks(ContextSteps contextSteps) throws Exception {
		contextSteps.setUp();
		driver = contextSteps.getDriver();
		
	}
	@Before
    public void beforeScenario() throws InterruptedException{
        System.out.println("This will run before the Scenario");
        driver.get(PropertiesOperation.getRadicalValueBykey("url"));
 }
 
    @After
    public void afterScenario() throws InterruptedException{
        System.out.println("This will run after the Scenario");
        Thread.sleep(1000);
       //driver.quit();
        ContextSteps.initialized=false;
    }

}
