#########################################################
# Author     : Ratnakar Dubey
# Test Plane : VerifyIndividualAward.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Recognition
Feature:Verify/Give the Individual Award feature
Scenario Outline: Create award.
When User Login to application with "AdminUser" and "AdminPassword".
And  User on left side bar navigate to "Configuration".
And  User on configuration navigate to link "Badges and Awards Management".
And  User click on Create button and select "Award" to create.
And User on Award details page add "<AwardName>" in award name field.
And User on Award details page add "<Description>" in Description field.
And User on Award detail page Select "<FundName>" in Fund field.
And User on Award detail page add "<RoleName>" in Who can give-Select roles field.
And User on Award detail page add "<Points>" in Points field.
And User on Award detail page add "<Status>" in Status field and Save.

Examples:
|AwardName       | Description                      | FundName   | RoleName | Points | Status |
|Best Automation Individual Award_| Created Award Through Automation_ |Automation Fund Do not delete/edit| Employee | 100    | Active |

Scenario Outline: Give Individual Award from Home Page
When User Login to application with "RecognitionRoleUser" and "RecognitionRolePassword".
And  User click on Recognition "AWARD" on the home Banner.
And User on Award detail page select "<AwardType>" Award type
And User on Award detail page add "<EmployeeName>" in field.
And User on Assign Award detail Page Select award "<AwardName>" for the list.
And User on Award detail Page Add message "<Message>" in Message field
And User on Award detail page Select company value "<CompanyValue>" in company value field.
And User on Award detail page click on give "AWARD" Button
Examples:
|AwardType       |EmployeeName   |AwardName               |Message                                 |CompanyValue                                   |
|Individual Award|adit daneil    |Best Automation Individual Award_|Successfully Given Individual Automation|*Comm!tment to Customer$*,*Cont!nuous Le@rning*|

Scenario Outline: Verify Individual Award on HomePage.
When User Login to application with "AdminUser" and "AdminPassword".
Then  Apply Home page Filter with option "<FilterOption>".
And  User on home page search"<EmployeeName>" And select "<AwardName>" the award post in Feed.
And  User on award Detail page verify "<AwardName>" and "<EmployeeName>" and "<Message>" and "<CompanyValue>".
Examples:
|FilterOption           |EmployeeName|AwardName               |Message                                 |CompanyValue                                   |
|Recognitions,Team Awards|adit|Best Automation Individual Award_|Successfully Given Individual Automation|*Comm!tment to Customer$*,*Cont!nuous Le@rning*|

  Scenario Outline: Making Created/Updated Award  Inactive.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User on Award listing page  search recognition "Awards" click on "Edit" action of "Best Automation Individual Award_".
    And User on Award detail page add "<Status>" in Status field and Save.
    Examples:
      | Status |
      | Inactive |