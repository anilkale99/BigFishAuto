package com.bigfish.steps.profileSteps;

import com.bigfish.pom.common.BasePage;
import com.bigfish.pom.common.ContextSteps;
import com.bigfish.pom.pages.Profile.EmployeeBasePage;
import com.bigfish.pom.pages.Campaign.CampaignBasePage;
import com.bigfish.pom.pages.Nomination.NominationsBasePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CreateAndUpdateEmployeeSteps extends EmployeeBasePage {
        WebDriver driver;
        public static String randomNumber;

        public CreateAndUpdateEmployeeSteps(ContextSteps contextSteps)
        {
                super(contextSteps);
                driver = contextSteps.getDriver();
        }
        @And("User on create Employee  page add {string} Profile image.")
        public void userOnCreateEmployeePageAddProfileImage(String ProfileImage) throws InterruptedException {
                Thread.sleep(2000);
                uploadADocument(By.id("image-input"), ProfileImage);
                Thread.sleep(2000);
                WebElement UploadBtn = driver.findElement(EmployeeBasePage.getLocatorForField("UploadImgBtn"));
                UploadBtn.click();
                Thread.sleep(2000);

        }
        @And("User on on employee creation page add {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} details.")
        public void userOnEmployeeCreationPageAddDetails(String firstname, String lastname, String designation, String department, String employeeCode, String pinCode, String country, String state, String city, String gender, String report_to, String alternate_manager, String IsPeopleManager, String dob, String doj, String email, String mob_no, String Adds, String street_adds, String adds_line2, String entity_type, String employee_cat, String function, String region, String cluster, String area, String territory, String grade,String store,String status ) throws Throwable
        {
                Thread.sleep(4000);
                WebElement Firstname = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("firstName"));
                randomNumber =getrandomnumber(4);
                Firstname.clear();
                Firstname.sendKeys(firstname+randomNumber);

                WebElement Lastname = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("lastName"));
                Lastname.clear();
                Lastname.sendKeys(lastname+randomNumber);

                WebElement Designation = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("designation"));
                Thread.sleep(2000);
                Designation.clear();
                SearchAndSelect(Designation, designation);

                WebElement Department = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("department"));
                Thread.sleep(2000);
                Department.clear();
                SearchAndSelect(Department, department);

                WebElement Employee_Code = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("employeeCode"));
                Thread.sleep(2000);
                Employee_Code.clear();
                Employee_Code.sendKeys(employeeCode+randomNumber);

                WebElement PinCode = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("pinCode"));
                Thread.sleep(2000);
                PinCode.clear();
                PinCode.sendKeys(pinCode);

                WebElement Country = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("country"));
                Thread.sleep(2000);
                Country.clear();
                SearchAndSelect(Country, country);

                WebElement State = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("state"));
                Thread.sleep(2000);
                State.clear();
                SearchAndSelect(State, state);

                WebElement City = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("city"));
                Thread.sleep(2000);
                City.clear();
                SearchAndSelect(City, city);

                WebElement Gender = driver.findElement(EmployeeBasePage.getLocatorForField("employeeGender"));
                Thread.sleep(2000);
                NGAngularSearchAndSelectDropdown(Gender, gender);

                WebElement Report_To = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("manager"));
                Thread.sleep(2000);
                Report_To.clear();
                SearchAndSelect(Report_To,report_to);

                WebElement Alternate_Manager = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("alternatemanager"));
                Thread.sleep(2000);
                Alternate_Manager.clear();
                SearchAndSelect(Alternate_Manager,alternate_manager);


                WebElement Is_People_Manager = driver.findElement(EmployeeBasePage.getLocatorForField("IsPeopleManagerCheckBox"));
                Thread.sleep(4000);
                System.out.println(IsPeopleManager);
                if (IsPeopleManager.equals("True")) {
                        Thread.sleep(2000);
                        Is_People_Manager.click();
                }

                WebElement Birth_Date = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("dateOfBirth"));
                Thread.sleep(2000);
                Birth_Date.clear();
                Birth_Date.sendKeys(dob);

                WebElement Date_Of_Joining = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("dateOfJoining"));
                Thread.sleep(2000);
                Date_Of_Joining.clear();
                Date_Of_Joining.sendKeys(doj);

                WebElement Email = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("email"));
                Thread.sleep(2000);
                Email.clear();
                Email.sendKeys(email+randomNumber+"@bftest.com");

                WebElement Mobile_Number = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("mobileNo"));
                Thread.sleep(2000);
                Mobile_Number.clear();
                Mobile_Number.sendKeys(mob_no+randomNumber);

                WebElement Address = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("add1"));
                Thread.sleep(2000);
                Address.clear();
                Address.sendKeys(Adds);

                WebElement Street_Address = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("add2"));
                Thread.sleep(2000);
                Street_Address.clear();
                Street_Address.sendKeys(street_adds);

                WebElement Address_Line_2 = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("add3"));
                Thread.sleep(2000);
                Address_Line_2.clear();
                Address_Line_2.sendKeys(adds_line2);

                WebElement Entity_Type = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("entityName"));
                Thread.sleep(2000);
                Entity_Type.clear();
                SearchAndSelect(Entity_Type, entity_type);

                WebElement Employee_Category = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("employeeCategory"));
                Thread.sleep(2000);
                Employee_Category.clear();
                SearchAndSelect(Employee_Category, employee_cat);

                WebElement Function = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("function"));
                Thread.sleep(2000);
                Function.clear();
                SearchAndSelect(Function, function);

                WebElement Region = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("region"));
                Thread.sleep(2000);
                Region.clear();
                SearchAndSelect(Region, region);

                WebElement Cluster = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("cluster"));
                Thread.sleep(2000);
                Cluster.clear();
                SearchAndSelect(Cluster, cluster);

                WebElement Area = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("area"));
                Thread.sleep(2000);
                Area.clear();
                SearchAndSelect(Area, area);

                WebElement Territory = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("territory"));
                Thread.sleep(2000);
                Territory.clear();
                SearchAndSelect(Territory, territory);

                WebElement Grade = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("grade"));
                Thread.sleep(2000);
                Grade.clear();
                SearchAndSelect(Grade, grade);


                WebElement Store = driver.findElement(BasePage.getlocatorForFieldsOnDetailpage("store"));
                Thread.sleep(3000);
                Store.clear();
                SearchAndSelect(Store, store);

                Thread.sleep(2000);
                selectValue(BasePage.getlocatorForFieldsOnDetailpage("status"), status);

                WebElement CreateBtn = driver.findElement(EmployeeBasePage.getLocatorForField("SubmitButtonText"));
                Thread.sleep(2000);
                CreateBtn.click();
        }


        @And("Search and select Employee {string} from employee list.")
        public void searchAndSelectEmployeeFromEmployeeList(String EmployeeName) throws InterruptedException {
                Thread.sleep(2000);
                WebElement SearchIntTxt = driver.findElement(NominationsBasePage.getLocatorForField("SearchInputTxtField"));
                SearchIntTxt.click();
                Thread.sleep(2000);
                SearchIntTxt.sendKeys(EmployeeName+randomNumber);
                driver.findElement(NominationsBasePage.getLocatorForField("PublishOrSaveButton")).click();



        }

        @And("Verify the created employee following details")
        public void verifyTheCreatedEmployeeFollowingDetails(DataTable tableObj) {
                {
                        List<List<String>> employeeDetails = tableObj.asLists();
                        //Verify the Employee Code value
                        String ColoumName1 = employeeDetails.get(0).get(0);
                        String employeeCode = employeeDetails.get(0).get(1);
                        String ColNo1 = employeeDetails.get(0).get(2);
                        WebElement ele1 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColoumName1,ColNo1));
                       System.out.println(ele1);
                        String EmployeeCode = ele1.getText();
                        System.out.println(EmployeeCode);
                        Assert.assertEquals(employeeCode+randomNumber, EmployeeCode);

                        //Verify the Employee Name value
                        String ColumnName2 = employeeDetails.get(1).get(0);
                        String FirstName = employeeDetails.get(1).get(1);
                        String ColNo2 = employeeDetails.get(1).get(2);
                        String LastName = employeeDetails.get(2).get(1);
                        String employeeName = FirstName+randomNumber+" "+LastName+randomNumber;
                        System.out.println(employeeName);
                        WebElement ele2 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColumnName2,ColNo2));
                        String EmployeeName = ele2.getText();
                        System.out.println(EmployeeName);
                        Assert.assertEquals(employeeName, EmployeeName);

                        //Verify the Employee Designation value
                        String ColumnName3 = employeeDetails.get(3).get(0);
                        String employeeDesignation = employeeDetails.get(3).get(1);
                        String ColNo3 = employeeDetails.get(3).get(2);
                        WebElement ele3 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColumnName3,ColNo3));
                        String EmployeeDesignation = ele3.getText();
                        System.out.println(employeeDesignation);
                        Assert.assertEquals(employeeDesignation, EmployeeDesignation);

                        //Verify the Employee City value
                        String ColumnName4 = employeeDetails.get(4).get(0);
                        String employeeCity = employeeDetails.get(4).get(1);
                        String ColNo4 = employeeDetails.get(4).get(2);
                        WebElement ele4 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColumnName4,ColNo4));
                        String EmployeeCity = ele4.getText();
                        System.out.println(employeeDesignation);
                        Assert.assertEquals(employeeCity, EmployeeCity);

                        //Verify the Employee Department value
                        String ColumnName5 = employeeDetails.get(5).get(0);
                        String employeeDepartment = employeeDetails.get(5).get(1);
                        String ColNo5 = employeeDetails.get(5).get(2);
                        WebElement ele5 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColumnName5,ColNo5));
                        String EmployeeDepartment = ele5.getText();
                        System.out.println(EmployeeDepartment);
                        Assert.assertEquals(employeeDepartment, EmployeeDepartment);

                        //Verify the Employee Employee Manager value
                        String ColumnName6 = employeeDetails.get(6).get(0);
                        String employeeManager = employeeDetails.get(6).get(1);
                        String ColNo6 = employeeDetails.get(6).get(2);
                        WebElement ele6 = driver.findElement(EmployeeBasePage.getLocatorToVerifyDetailsInSearchList(ColumnName6,ColNo6));
                        String EmployeeManager = ele6.getText();
                        System.out.println(EmployeeManager);
                        Assert.assertEquals(employeeManager, EmployeeManager);

                }
        }


    @And("User click on action button and select {string} from dropdown for employee edit.")
    public void userClickOnActionButtonAndSelectFromDropdownForEmployeeEdit(String ActionValue) {

            WebElement ActionBtn = driver.findElement(EmployeeBasePage.getLocatorForField("ActionBtnLoc"));
            ActionBtn.click();
            WaitAndClick(driver.findElement(CampaignBasePage.ActionButtonLoc(ActionValue)));


    }
}
