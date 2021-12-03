package com.bigfish.pom.common;

import com.bigfish.pom.locators.CommonLocators;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage extends com.bigfish.pom.common.BaseAction {
	WebDriver driver;

	public BasePage(ContextSteps contextSteps) {
		super(contextSteps);
		driver = contextSteps.getDriver();
	}

//	//Methods

	public void SelectRuleFromDropdown(String value) throws InterruptedException {
		driver.switchTo().activeElement();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		for (int i = 1; i <= 4; i++) {
			try {
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@aria-labelledby='mySmallModalLabel']//button/span[text()='Add Rules'])[" + i + "]")));
				element.click();
				break;
			} catch (Exception e) { }
		}
		for (int i = 1; i <= 3; i++)
		{
			try {
				WebElement Value_Locator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[contains(@class,'dropdown-menu animated')])[" + i + "]/li/a[contains(text(),'" + value + "')]")));
				Actions builder = new Actions(driver);
				builder.moveToElement(Value_Locator).click(Value_Locator);
				builder.perform();
				break;
			}
			catch (Exception e){ }
		}
		//Handle the Popup message for All employee an All reporting manager
		if(driver.findElements(CommonLocators.getLocatorForField("ConfirmPopupBtn")).size() > 0)
		{
			for (int k = 1; k <= 4; k++) {
				try {
					WebElement Locator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,\"modal-footer\")]//button[@type=\"button\"][text()=\"Yes\"])[" + k +"]")));
					Locator.click();
					break;
				}
				catch (Exception e){ }
			}
			}

		}



	public void SetAudienceScope(String Rule_value, String Search_value) throws InterruptedException {
		    Thread.sleep(2000);
			WebElement Text_field = driver.findElement(NominationsBasePage.getLocatorForField("NominationSearchTextField"));

			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(Text_field)).click();

			Text_field.sendKeys(Search_value);
			Thread.sleep(2000);

			Text_field.sendKeys(Keys.ARROW_DOWN);
			Text_field.sendKeys(Keys.ENTER);
	}
//Locators
		public static By getlocatorForFieldsOnDetailpage (String FieldName){
			By DYNAMIC_LOCATOR_VALUE = null;
			DYNAMIC_LOCATOR_VALUE = By.xpath("//*[@formcontrolname='" + FieldName + "']");
			return DYNAMIC_LOCATOR_VALUE;
	    }
	}



