########################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateUpdateMonetaryBadges.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Recognition
Feature: Create and update Recognition Monetary badge feature
  Scenario Outline: Create Monetary Badge
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User click on Create button and select "Monetary Badge" to create.
    And  User on Badge details page add "<MonetaryBadgeName>" in Badge name field.
    And  User on Badge details page add "<Description>" in Description field.
    And  User on Badge detail page add "<RoleName>" in Who can give-Select roles field.
    And  User on Badge detail page add "<Points>" in Points field.
    And  User on Badge detail page add "<Criteria>" in criteria field
    And  User on Badge detail page add "<Status>" in Status field and Save.
 Examples:
      | MonetaryBadgeName| Description                               |RoleName| Points |Criteria| Status   |
      | Best Automation Badge_| Created Monetary Badge Through Automation_ |TEAM_ADMIN | 100    |Should have completed 6 month in Org|Active   |
  Scenario: Verify the Create Details of the created Monetary badges.
    When User Login to application with "AdminUser" and "AdminPassword".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And Search and select "Best Automation Badge_" Badge from "Monetary Badges"  list.
    And Verify the created badge following details.
      |Badge Name|Best Automation Badge_|2|
      |Description|Created Monetary Badge Through Automation_|3|
      |Status|Active|4                                |
      |Points|100|5                                     |

  Scenario Outline: Update Created Monetary Badge
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User on Badge listing page  search recognition "Monetary Badges" click on "Edit" action of "Best Automation Badge_".
    And User on Badge details page add "<MonetaryBadgeName>" in Badge name field.
    And User on Badge details page add "<Description>" in Description field.
    And User on Badge detail page add "<RoleName>" in Who can give-Select roles field.
    And User on Badge detail page add "<Points>" in Points field.
    And User on Badge detail page add "<Criteria>" in criteria field
    And User on Badge detail page add "<Status>" in Status field and Save.
    Examples:
      | MonetaryBadgeName      | Description                                |  RoleName                 | Points |Criteria                                      | Status   |
      |Best Update Automation Monetary Badge_| Update Monetary Badge Through Automation_|TEAM_ADMIN,DISCUSSION ADMIN| 250    |Should have not received any award for quarter| Active |

  Scenario: Verify the Updated Details of the created Monetary badges.
    When User Login to application with "AdminUser" and "AdminPassword".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And Search and select "Best Update Automation Monetary Badge_" Badge from "Monetary Badges"  list.
    And Verify the created badge following details.
      |Badge Name|Best Update Automation Monetary Badge_|2|
      |Description|Update Monetary Badge Through Automation_|3|
      |Status|Active|4|
      |Points|250|5|

  Scenario Outline: Making Created/Updated Monetary Badges  Inactive.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User on Badge listing page  search recognition "Monetary Badges" click on "Edit" action of "Best Update Automation Monetary Badge_".
    And User on Award detail page add "<Status>" in Status field and Save.
    Examples:
      | Status |
      | Inactive |
