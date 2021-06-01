package com.bigfish.pom.pages.Nomination;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.locators.CommonLocators;

import org.openqa.selenium.*;
import  com.bigfish.pom.common.*;
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
            case "NewNominationBtn":
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
            case   "NominationPageTitle":
                LOCATOR_VALUE=By.xpath("//*[text()='Nominations' or text()='NOMINATIONS']");
                break;
            case "LoadMoreBtn":
                LOCATOR_VALUE=By.xpath("//button[contains(text(),'Load More')]");
                break;
            case "NominationSearchTextField":
                LOCATOR_VALUE=By.xpath("//div[@aria-hidden=\"false\"]//input[contains(@placeholder, 'Search by Name')]");
                break;
            case "SearchTextField":
                LOCATOR_VALUE=By.xpath("//input[contains(@placeholder, 'Search by Name')]");
                break;
            case "SubmitButton":
                LOCATOR_VALUE=By.xpath("//button[contains(text(),'SUBMIT')]");
                break;
            case "SubmitMgsButton":
                LOCATOR_VALUE=By.xpath("//button[contains(text(),'Submit')]");
                break;
            case "MessageClosebtn":
                LOCATOR_VALUE=By.xpath("//div[@class=\"toast-close-button\"]");
                break;
            case "ConfirmMessageBtn":
                LOCATOR_VALUE=By.xpath("//div[@class=\"alert-box\"]//button[text()=\"Yes\"]");
                break;
            case "SearchInputTxtField":
                LOCATOR_VALUE=By.xpath("//input[@placeholder=\"Search by name or code\"]");
                break;
            case "ValidationCommentField":
                LOCATOR_VALUE=By.xpath("//textarea[not(contains(@placeholder, 'Add Your Voting Comment'))]");
                break;
            case "CloseButton":
                LOCATOR_VALUE=By.xpath("//td[@class=\"table-status-for-buttons\"]/button[contains(text(),'CLOSE')]");
                break;
            case "CloseStageButton":
                LOCATOR_VALUE=By.xpath("//div[@class=\"modal-footer\"]/button[contains(text(),'Close Stage')]");
                break;
            case "ConfirmButton":
                LOCATOR_VALUE=By.xpath("//button[text()=\"OK\"]");
                break;
            case "MoveNomineeButton":
                LOCATOR_VALUE=By.xpath("//span[text()=\"MOVE NOMINEE\"]");
                break;
            case "MoveAllMessageBtn":
                LOCATOR_VALUE=By.xpath("//button[text()='Move All']");
                break;
            case "InitiateButton":
                LOCATOR_VALUE=By.xpath("//button[contains(text(),'INITIATE')]");
                break;
            case "InitiateMsgButton":
                LOCATOR_VALUE=By.xpath("//button[contains(text(),'Initiate')]");
                break;
            case "VoteButton":
                LOCATOR_VALUE=By.xpath("(//button[normalize-space(text())=\"VOTE\"])[1]");
                break;
            case "VotingCommentField":
                LOCATOR_VALUE=By.xpath("//textarea[not(contains(@placeholder, 'Add Your Validation Comment'))]");
                break;
            case "GiveAwardButton":
                LOCATOR_VALUE=By.xpath("//td[@class=\"table-status-for-buttons\"]/button[contains(text(),'GIVE AWARD')]");
                break;

            default:
                System.out.println("Invalid case value: " + fieldName);   //textarea[not(contains(@placeholder, 'Add Your Validation Comment'))]
        }
        return LOCATOR_VALUE;
    }
//Dynamic_Locators
  public static By Loc_for_nomination_name_in_list(String Nomi_Name ,String Action){
      By DYNAMIC_LOCATOR_VALUE = null;
      DYNAMIC_LOCATOR_VALUE=By.xpath("//div[normalize-space(text())='"+Nomi_Name+"']/ancestor::div[@class=\"media-box\"]//button[text()='"+Action+"']");
      return DYNAMIC_LOCATOR_VALUE;
  }
  public static By Set_criteria_Button(String Criteria_Button)
  {
      By DYNAMIC_LOCATOR_VALUE = null;
      DYNAMIC_LOCATOR_VALUE=By.xpath("(//div/button[text()='Save Criteria'])['"+Criteria_Button+"']");
      return DYNAMIC_LOCATOR_VALUE;

  }
  public static By User_action_choice(String Action)
  {
      By DYNAMIC_LOCATOR_VALUE = null;
      DYNAMIC_LOCATOR_VALUE=By.xpath("//button[text()='"+Action+"']");
      return DYNAMIC_LOCATOR_VALUE;
  }
  public static By Validation_View_Details_Link(String Employee_Name)
         {
          By DYNAMIC_LOCATOR_VALUE = null;
          DYNAMIC_LOCATOR_VALUE = By.xpath("//td[contains(text(),'" + Employee_Name + "')]/ancestor::tbody/tr/td/a[text()='View Details']");
          return DYNAMIC_LOCATOR_VALUE;
        }
    public static By Validation_View_Details_Link2(String Employee_Name)
        {
          By DYNAMIC_LOC_VALUE = null;
          DYNAMIC_LOC_VALUE = By.xpath("//h4[contains(text(),'" + Employee_Name + "')]/ancestor::div[@class=\"panel-body\"]//tbody//a[contains(text(),'View Details')]");
          return DYNAMIC_LOC_VALUE;
        }

    public static By Move_Nominee_Options(String MoveNomineeOptions)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//div[@class=\"btn-group open\"]/ul/li/a[text()='"+MoveNomineeOptions+"']");
        return DYNAMIC_LOCATOR_VALUE;
    }

    public static By Select_Employees_Checkbox(String EmployesName)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//td[3][contains(text(),'"+EmployesName+"')]/ancestor::tr//div[@class=\"checkbox c-checkbox\"]");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public static By Stage_Header_Button(String Stage_Name)
    {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE=By.xpath("//a[contains(@class,'nav-link')][text()='"+Stage_Name+"']");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public static By Breadcrumb_Navigation_Link(String LinkLoc) {
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//div[@class=\"content-wrapper\"]//li/a[contains(text(),'" + LinkLoc + "')]");
        return DYNAMIC_LOCATOR_VALUE;
    }
    public  static By Select_Teamlead_Radio_Btn(String Employee_name){
        By DYNAMIC_LOCATOR_VALUE = null;
        DYNAMIC_LOCATOR_VALUE = By.xpath("//div[contains(@class,\" row nominee-box\")]/div//h5[contains(text(),'"+Employee_name+"')]/ancestor::div[3]/div[2]/div/input");
        return DYNAMIC_LOCATOR_VALUE;

    }

//Methods
   public void SelectRuleFromDropdown( String value, String Rule_btn_Active_index, String Rule_value_Active_index) throws InterruptedException {
		driver.switchTo().activeElement();
		Thread.sleep(2000);
		
		WebElement Locator = driver.findElement(By.xpath("(//div[@aria-labelledby='mySmallModalLabel']//button/span[text()='Add Rules'])[" + Rule_btn_Active_index + "]"));
		Locator.click();
		
		WebElement Value_Locator = driver.findElement(By.xpath("(//ul[@class='dropdown-menu animated'])[" + Rule_value_Active_index + "]/li/a[contains(text(),'"+value+"')]"));
		 Actions builder = new Actions(driver);                            
	     builder.moveToElement( Value_Locator ).click( Value_Locator );
	     builder.perform();
    }
    
    public void Setaudiencescope(String Rule_value, String Search_value) throws InterruptedException {
        if (!"SKIP".equals(Search_value)){
            Thread.sleep(1000);
 			WebElement Text_field = driver.findElement(NominationsBasePage.getLocatorForField("NominationSearchTextField"));
 			WebDriverWait wait = new WebDriverWait(driver,50);
 			wait.until(ExpectedConditions.elementToBeClickable(Text_field)).click();
 			
 			Text_field.sendKeys(Search_value);
 			Thread.sleep(2000);
 			
 			Text_field.sendKeys(Keys.ARROW_DOWN);
 			Text_field.sendKeys(Keys.ENTER);

 		}
 		else {
 			System.out.println("The Audience Scope" + Rule_value + "is selected");
 		}

 	}


    public void Verifyaddedscope() {

	}
    

}
