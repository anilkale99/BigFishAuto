#########################################################
# Author     : Ratnakar Dubey
# Test Plane : VerifyIndividualNonMonetaryBadges.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Recognition
Feature: Verify/Give the Individual Non Monetary Badge feature
  Scenario Outline: Create Non Monetary Badge
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User click on Create button and select "Non Monetary Badge" to create.
    And  User on Badge details page add "<NonMonetaryBageName>" in Badge name field.
    And  User on Badge details page add "<Description>" in Description field.
    And  User on Badge detail page add "<RoleName>" in Who can give-Select roles field.
    And  User on Badge detail page add "<Status>" in Status field and Save.

    Examples:
      | NonMonetaryBageName           | Description                       | RoleName          | Status  |
      | Best Automation Individual Non Monetary Badge_| Created Award Through Automation_ | TEAM_ADMIN        | Active  |

  Scenario Outline: Give Individual Non Monetary Badge from Home Page
    When User Login to application with "RecognitionRoleUser" and "RecognitionRolePassword".
    And  User click on Recognition "NM_Salute" on the home Banner.
    And  User Click on the badge "<NonMonetaryBageName>" from Badge list of home page.
    And User on Award detail page add "<EmployeeName>" in field.
    And User on Award detail Page Add message "<Message>" in Message field
    And User on Award detail page Select company value "<CompanyValue>" in company value field.
    And User on Award detail page click on give "RECOGNISE" Button
    Examples:
      |NonMonetaryBageName                  |EmployeeName|Message|CompanyValue|
      |Best Automation Individual Non Monetary Badge_|Bigfish409 User409 |Congratulation Mate!!|*Comm!tment to Customer$*,*Cont!nuous Le@rning*|

  Scenario Outline: Verify Individual NonMonetary badge on HomePage.
    When User Login to application with "AdminUser" and "AdminPassword".
    Then  Apply Home page Filter with option "<FilterOption>".
    And  User on award Detail page verify "<NonMonetaryBageName>" and "<EmployeeName>" and "<Message>" and "<CompanyValue>".
    Examples:
      |FilterOption             | NonMonetaryBageName                  |EmployeeName|Message              |CompanyValue|
      |Recognitions,Team Awards |Best Automation Individual Non Monetary Badge_ |Bigfish409 |Congratulation Mate!!|*Comm!tment to Customer$*,*Cont!nuous Le@rning*|

  Scenario Outline: Making Created/Updated Non monetary badge  Inactive.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User on Award listing page  search recognition "Non Monetary Badges" click on "Edit" action of "Best Automation Individual Non Monetary Badge_".
    And User on Award detail page add "<Status>" in Status field and Save.
    Examples:
      | Status |
      | Inactive |