####################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateUpdateGroup.feature
# Test ID    :
# Test case  :
#####################################################
@Regression
@Groups
Feature: Create and Update Group
Scenario: Create Groups with provided details
  When User Login to application with "GroupAdminRoleUser" and "GroupAdminRolePassword".
  And  User on left side bar navigate to "Groups".
  And  User click on the "NEW GROUP"  button and create.
  And User on create Group page add following details.
    |Group Title|Group Created through Automation_|
    |Description|Description Added for Created Group through Automation_|
    |Category|Don't Delete Automation Group Category|
    |GroupImage|Mahakal.jpg|
  And User click on the "DONE"  button and create.


  Scenario: Verify the Created Groups details.
    When User Login to application with "GroupAdminRoleUser" and "GroupAdminRolePassword".
    And  User on left side bar navigate to "Groups".
    And  Search and Select Created group "Group Created through Automation_" from the Group list.
    And User on  Group page verify following details
      |Group Title|Group Created through Automation_|
      |Description|Description Added for Created Group through Automation_|
      |Category|DON'T DELETE AUTOMATION GROUP CATEGORY|
      |OwnerName|Bigfish163 User163|

  Scenario: Update Groups added details while creating.
    When User Login to application with "GroupAdminRoleUser" and "GroupAdminRolePassword".
    And  User on left side bar navigate to "Groups".
    And  Search and Select Created group "Group Created through Automation_" from the Group list.
    And  User click on group action button and select "EDIT" from dropdown.
    And User on Update Group page add following details.
      |Group Title|Group Update through Automation_|
      |Description|Description Added for Updated Group through Automation_|
      |Category|Update Don't Delete Automation Group Category|
      |GroupImage|PlantLife.jpg|
    And User click on the Done button and create and update Group.

  Scenario: Verify the updated Groups details.
    When User Login to application with "GroupAdminRoleUser" and "GroupAdminRolePassword".
    And  User on left side bar navigate to "Groups".
    And  Search and Select Created group "Group Update through Automation_" from the Group list.
    And User on  Group page verify following details
      |Group Title|Group Update through Automation_|
      |Description|Description Added for Updated Group through Automation_|
      |Category|UPDATE DON'T DELETE AUTOMATION GROUP CATEGORY|
      |OwnerName|Bigfish163 User163|


