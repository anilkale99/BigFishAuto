package com.bigfish.pom.common;

import com.bigfish.pom.locators.CommonLocators;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.bigfish.pom.pages.Nomination.*;
import org.openqa.selenium.interactions.internal.BaseAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePage extends com.bigfish.pom.common.BaseAction{
	 WebDriver driver;

	    public BasePage(ContextSteps contextSteps) {
	        super(contextSteps);
	        driver = contextSteps.getDriver();
	    }


	

}


