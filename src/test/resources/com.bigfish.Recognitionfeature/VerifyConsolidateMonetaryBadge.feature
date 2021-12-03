########################################################
# Author     : Ratnakar Dubey
# Test Plane : VerifyConsolidateMonetaryBadge.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Recognition
Feature: Verify/Give the consolidate Monetary Badge feature
Scenario Outline: Create Monetary Badge
When User Login to application with "AdminUser" and "AdminPassword".
And  User on left side bar navigate to "Configuration".
And  User on configuration navigate to link "Badges and Awards Management".
And  User click on Create button and select "Monetary Badge" to create.
And User on Badge details page add "<MonetaryBadgeName>" in Badge name field.
And User on Badge details page add "<Description>" in Description field.
And User on Badge detail page add "<RoleName>" in Who can give-Select roles field.
And User on Badge detail page add "<Points>" in Points field.
And User on Badge detail page add "<Criteria>" in criteria field
And User on Badge detail page add "<Status>" in Status field and Save.

Examples:
|MonetaryBadgeName| Description                               |RoleName| Points |Criteria| Status   |
|Best Automation Monetary Badge For Consolidate_| Created Monetary Badge Through Automation_ |TEAM_ADMIN | 100    |Should have completed 6 month in Org|Active   |

  Scenario Outline: Give Consolidate Monetary Badge from Home Page
    When User Login to application with "RecognitionRoleUser" and "RecognitionRolePassword".
    And  User click on Recognition "M_Salute" on the home Banner.
    And User on Award detail page add "<EmployeeName>" in field.
    And User on Assign Award detail Page Select award "<BadgeName>" for the list.
    And User on Award detail Page Add message "<Message>" in Message field
    And User on Award detail page Select company value "<CompanyValue>" in company value field.
    And User on Award detail page click on give "RECOGNISE" Button
    Examples:
      |EmployeeName                               |BadgeName               |Message                                 |CompanyValue                                   |
      |Bigfish951 User951,Bigfish269 User269,Bigfish710 User710|Best Automation Monetary Badge For Consolidate_|Successfully Given Individual Automation|*Comm!tment to Customer$*,*Cont!nuous Le@rning*|

  Scenario Outline: Verify Consolidated Award on HomePage.
    When User Login to application with "AdminUser" and "AdminPassword".
    Then  Apply Home page Filter with option "<FilterOption>".
    And  User on home page search"<EmployeeName>" And select "<BadgeName>" the award post in Feed.
    And  User on award Detail page verify "<BadgeName>" and "<EmployeeName>" and "<Message>" and "<CompanyValue>".
    Examples:
      |FilterOption           |EmployeeName|BadgeName               |Message                                 |CompanyValue                                   |
      |Recognitions,Team Award|Bigfish951,Bigfish269,Bigfish710|Best Automation Monetary Badge For Consolidate _|Successfully Given Individual Automation|*Comm!tment to Customer$*,*Cont!nuous Le@rning*|

  Scenario Outline: Making Created/Updated Award  Inactive.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User on Badge listing page  search recognition "Monetary Badges" click on "Edit" action of "Best Automation Monetary Badge For Consolidate _".
    And User on Award detail page add "<Status>" in Status field and Save.
    Examples:
      | Status |
      | Inactive |