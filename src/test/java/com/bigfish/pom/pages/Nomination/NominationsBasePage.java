package com.bigfish.pom.pages.Nomination;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import  com.bigfish.pom.common.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.BaseAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class NominationsBasePage extends BasePage{
    WebDriver driver;

    public NominationsBasePage(ContextSteps contextSteps) {
        super(contextSteps);
        driver = contextSteps.getDriver();
    }

    //Locators
    public static By getLocatorForField(String fieldName) {
        By LOCATOR_VALUE = null;
        switch (fieldName) {
            case "NEW_NOMINATION_BTN":
                LOCATOR_VALUE = By.xpath("//button[@class=\"btn btn-info\"]");
                break;
            case "title":
                LOCATOR_VALUE = By.xpath("//input[@formcontrolname='"+fieldName+"']");
                break;
            case "awardName":
                LOCATOR_VALUE = By.xpath("//div[@class=\"ui-select-container dropdown open\"]//span[text()=\"No award selected\"]");
                break;
            case "description":
                LOCATOR_VALUE = By.xpath("//textarea[@formcontrolname='"+fieldName+"']");
                break;
            case "awardType":
                LOCATOR_VALUE = By.xpath("//ng-select[@formcontrolname='"+fieldName+"']");
                break;
            case "selfNomination":
                LOCATOR_VALUE = By.xpath("//ng-select[@formcontrolname='"+fieldName+"']");
                break;
            case "noOfNominations":
                LOCATOR_VALUE = By.xpath("//ng-select[@formcontrolname='"+fieldName+"']");
                break;
            case "noOfEmployees":
                LOCATOR_VALUE= By.xpath("//ng-select[@formcontrolname=\"noOfEmployees\"]//span[contains(@class,'ui-select-toggle')]");
                break;
             case "SaveDefButton":
                LOCATOR_VALUE = By.xpath("//div[@class=\"pt-lg\"]/button[text()='Save & Define Workflow']");
                break;
            case "PublishButton":
                LOCATOR_VALUE = By.xpath("//button[@type=\"submit\"]");
                break;
            case  "PriviewPublishButton":
            	LOCATOR_VALUE= By.xpath("//div[@class=\"alert-box\"]/div[3]/button[text()='Publish']");
            	break;
            case   "NominationOpenBtnLoc":
                LOCATOR_VALUE=By.xpath("//div[@class=\"btn-group header-margin\"]/span[1]");
                break;
            case "load_more_btn":
                LOCATOR_VALUE=By.xpath("//button[contains(text(),'Load More')]");
                break;
            case "search_text_field":
                LOCATOR_VALUE=By.xpath("");
            case "Submit_button":
                LOCATOR_VALUE=By.xpath("//button[contains(text(),'SUBMIT')]");
                break;
            case "MessageClosebtn":
                LOCATOR_VALUE=By.xpath("//div[@class=\"toast-close-button\"]");
                break;
            default:
                System.out.println("Invalid case value: " + fieldName);
        }
        return LOCATOR_VALUE;
    }
//Dynamic_Locators
  public static By Loc_for_nomination_name_in_list(String Nomi_Name ,String Action){
      By DYNAMIC_LOCATOR_VALUE = null;
      DYNAMIC_LOCATOR_VALUE=By.xpath("//div[contains(text(),'"+Nomi_Name+"')]/ancestor::div[@class=\"media-box\"]//button[text()='"+Action+"']");
      return DYNAMIC_LOCATOR_VALUE;
  }


//Methods
   public void SelectRuleFromDropdown( String value, int Rule_btn_Active_index, int Rule_value_Active_index) throws InterruptedException {
		driver.switchTo().activeElement();
		Thread.sleep(2000);
		
		WebElement Locator = driver.findElement(By.xpath("(//div[@aria-labelledby='mySmallModalLabel']//button/span[text()='Add Rules'])[" + Rule_btn_Active_index + "]"));
		Locator.click();
		
		WebElement Value_Locator = driver.findElement(By.xpath("(//ul[@class='dropdown-menu animated'])[" + Rule_value_Active_index + "]/li/a[contains(text(),'"+value+"')]"));
		 Actions builder = new Actions(driver);                            
	     builder.moveToElement( Value_Locator ).click( Value_Locator );
	     builder.perform();
    }
    
    public void Setaudiencescope(String Rule_value, String Search_value, int ActiveIndex,int ValueIndex,int Txtfield_index) throws InterruptedException {

 	   SelectRuleFromDropdown(Rule_value,ActiveIndex,ValueIndex);
        if (!"SKIP".equals(Search_value)){
            Thread.sleep(1000);
 			WebElement Text_field = driver.findElement(By.xpath("(//input[contains(@placeholder, 'Search by Name')])["+Txtfield_index+"]"));
 			WebDriverWait wait = new WebDriverWait(driver,50);
 			wait.until(ExpectedConditions.elementToBeClickable(Text_field)).click();
 			
 			Text_field.sendKeys(Search_value);
 			Thread.sleep(2000);
 			
 			Text_field.sendKeys(Keys.ARROW_DOWN);
 			Text_field.sendKeys(Keys.ENTER);
 			driver.findElement(By.xpath("(//div[@aria-labelledby='mySmallModalLabel']//button[text()='Save Criteria'])["+ActiveIndex+"]")).click();
 		}
 		else {
 			System.out.println("The Audience Scope" + Rule_value + "is selected");
            driver.findElement(By.xpath("(//div[@aria-labelledby='mySmallModalLabel']//button[text()='Save Criteria'])["+ActiveIndex+"]")).click();
 		}

 	}
    
    
    public void Verifyaddedscope() {

	}
    

}
