package com.bigfish.pom.common;

import com.bigfish.utilities.DateSelector;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.bigfish.pom.locators.CommonLocators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

public class BaseAction {
	
	WebDriver driver;

	public BaseAction(ContextSteps contextSteps) {
		driver = contextSteps.getDriver();
	}

	public void clickElement(String fieldName) {
		driver.findElement(CommonLocators.getLocatorForField(fieldName)).click();
	}

	public void enterValue(String value, String fieldName) {
		System.out.println("Entering value: " + value + " in field: " + fieldName);
		WebElement field = driver.findElement(CommonLocators.getLocatorForField(fieldName));
		field.clear();
		field.sendKeys(value);
	}

	public void enterValue(By locator, String value, String fieldName) {
		System.out.println("Entering value: " + value + " in field: " + fieldName);
		WebElement field = driver.findElement(locator);
		field.clear();
		field.sendKeys(value);
	}

	public void clickElement(By locator) throws InterruptedException {
		scrollToElement(locator, "click");
		//driver.findElement(locator).click();
	}

	public void scrollToElement(String element, String action) throws InterruptedException {
		WebElement ele = driver.findElement(CommonLocators.getLocatorForField(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(1000);
		if (action.equals("click")){
			ele.click();
		}
	}

	public void scrollToLinkAndNavigate(By locator) throws InterruptedException {
		Thread.sleep(1000);
		WebElement ele = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(1000);
		driver.navigate().to(ele.getAttribute("href"));
	}


	public void scrollToElement(By locator, String action) throws InterruptedException {
		Thread.sleep(1000);
		WebElement ele = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(1000);
		if (action.equals("click")){
			ele.click();
		}
	}

	public void selectValue(String value, String dropdownName){
		System.out.println("Selecting value: " + value + " from dropdown: " + dropdownName);
		Select dd = new Select(driver.findElement(CommonLocators.getLocatorForField(dropdownName)));
		dd.selectByVisibleText(value);
	}

	public void selectValue(By locator, String value){
		System.out.println("Selecting value: " + value);
		Select dd = new Select(driver.findElement(locator));
		dd.selectByVisibleText(value);
	}

	public void uploadADocument(By locator, String filename){
		File f = new File("src/test/resources/documents/"+filename);
		String absolutePath = f.getAbsolutePath();
		System.out.println("Absolute  path: "  + absolutePath);
		driver.findElement(locator).sendKeys(absolutePath);
	}

	public void verifyTextDisplayed(String textOnPage){
		//WebElement ele = driver.findElement(By.xpath("//*[contains(text(), '"+opportunityName+"')]"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), '"+textOnPage+"')]")));
	}

	public void clickByLinkText(String linkText) throws InterruptedException {
		//driver.findElement(By.linkText(linkText)).click();
		scrollToLinkAndNavigate(By.linkText(linkText));
	}

	public void clickByPartialLinkText(String linkText) throws InterruptedException {
		//driver.findElement(By.linkText(linkText)).click();
		scrollToElement(By.partialLinkText(linkText), "click");
	}

	public void validateSubMenuOptions(List<String> subMenuOptions) throws InterruptedException {
		Thread.sleep(1000);
		for (String optionName: subMenuOptions) {
			try {
				List<WebElement> list = driver.findElements(By.xpath("//*[text()='" + optionName + "']"));
				Assert.assertTrue("Not found option: "+optionName, list.size() == 1);
			} catch (AssertionError e) {
				driver.findElement(By.linkText(optionName));
			}
		}
	}

	public void enterValue(String value, By locator) {
		WebElement field = driver.findElement(locator);
		field.clear();
		field.sendKeys(value);
	}

	public void scrollPageDown(int numberOfPages) throws InterruptedException {
		int page = 400;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + page*numberOfPages +")");
		Thread.sleep(2000);
	}

	public void selectDateFromDatePicker(String date, String datePicker) throws Exception {
		DateSelector.selectDate(driver, date, datePicker);
	}

}
