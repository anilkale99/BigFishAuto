package com.bigfish.steps.common;

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
//		driver.findElement(By.xpath("//button[@id='details-button']")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
    } 
 
    @After
    public void afterScenario() throws InterruptedException{
        System.out.println("This will run after the Scenario");
//        try{
//            Thread.sleep(2000);
//            WebElement ele = driver.findElement(By.linkText("Sign out"));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
//            Thread.sleep(2000);
//            ele.click();
//        } catch (Exception e) {
//            Thread.sleep(2000);
//            driver.navigate().refresh();
//            WebElement ele = driver.findElement(By.linkText("Sign out"));
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
//            Thread.sleep(2000);
//            ele.click();
//        }
//        Thread.sleep(1000);
        driver.quit();
        ContextSteps.initialized=false;
    }

}
