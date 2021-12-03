########################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateUpdateNonMonetaryBadge.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Recognition
Feature: Create and update Recognition Non Monetary Badge
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
    | Best Automation Non Monetary Badge_ | Created Non monetary badge Through Automation_ | TEAM_ADMIN        | Active  |

  Scenario: Verify the Create Details of the created Non Monetary badges.
    When User Login to application with "AdminUser" and "AdminPassword".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And Search and select "Best Automation Non Monetary Badge_" Badge from "Non Monetary Badges"  list.
    And Verify the created badge following details.
      |Badge Name|Best Automation Non Monetary Badge_|2|
      |Description|Created Non monetary badge Through Automation_|3|
      |Status|Active|4|

  Scenario Outline: Update Created Non Monetary Badge
    When User Login to application with "AdminUser" and "AdminPassword".
    And User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User on Badge listing page  search recognition "Non Monetary Badges" click on "Edit" action of "Best Automation Non Monetary Badge_".
    And User on Badge details page add "<NonMonetaryBageName>" in Badge name field.
    And User on Badge details page add "<Description>" in Description field.
    And User on Badge detail page add "<RoleName>" in Who can give-Select roles field.
    And User on Badge detail page add "<Status>" in Status field and Save.
    Examples:
  | NonMonetaryBageName           | Description                                      | RoleName                          | Status|
  | Best Automation Updated Non Monetary Badge_|Created Updated Non monetary badge Through Automation_|DISCUSSION ADMIN,ROLE_EVENT_ADMIN  | Active|

  Scenario: Verify the Updated Details of the created Non Monetary badges.
    When User Login to application with "AdminUser" and "AdminPassword".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And Search and select "Best Automation Updated Non Monetary Badge_" Badge from "Non Monetary Badges"  list.
    And Verify the created badge following details.
      |Badge Name|Best Automation Updated Non Monetary Badge_|2|
      |Description|Created Updated Non monetary badge Through Automation_|3|
      |Status|Active|4|

  Scenario Outline: Making Created/Updated Non monetary badge  Inactive.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User on Badge listing page  search recognition "Non Monetary Badges" click on "Edit" action of "Best Automation Updated Non Monetary Badge_".
    And User on Award detail page add "<Status>" in Status field and Save.
    Examples:
      | Status |
      | Inactive |
