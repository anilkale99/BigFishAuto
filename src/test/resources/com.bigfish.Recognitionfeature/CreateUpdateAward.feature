########################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateUpdateAward.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Recognition
Feature: Create and update Recognition Award feature
  Scenario Outline: Create award.
    When User Login to application with "AdminUser" and "AdminPassword".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And User click on Create button and select "Award" to create.
    And User on Award details page add "<AwardName>" in award name field.
    And User on Award details page add "<Description>" in Description field.
    And User on Award detail page Select "<FundName>" in Fund field.
    And User on Award detail page add "<RoleName>" in Who can give-Select roles field.
    And User on Award detail page add "<Points>" in Points field.
    And User on Award detail page add "<Status>" in Status field and Save.
    Examples:
      | AwardName       | Description                      | FundName   | RoleName | Points | Status |
      | Best Automation Award_ |Created Award Through Automation_|Automation Fund Do not delete/edit| Employee | 100    | Active |

  Scenario: Verify the Details of the created award
    When User Login to application with "AdminUser" and "AdminPassword".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And Search and select "Best Automation Award_" Recognition "Awards" from list.
    And Verify the created Award following details.
    |Award Name|Best Automation Award_|2|
    |Description|Created Award Through Automation_|3|
    |Status|Active|4                                |
    |Points|100|5                                   |

  Scenario Outline: Update Created Award.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User on Award listing page  search recognition "Awards" click on "Edit" action of "Best Automation Award_".
    And User on Award details page add "<AwardName>" in award name field.
    And User on Award details page add "<Description>" in Description field.
    And User on Award detail page Select "<FundName>" in Fund field.
    And User on Award detail page add "<EmployeeName>" in field.
    And User on Award detail page add "<Points>" in Points field.
    And User on Award detail page add "<Status>" in Status field and Save.
    Examples:
      | AwardName               | Description                      | FundName                      | EmployeeName                             | Points | Status |
      | Best Updated Automation Award_| Update Award Through Automation_ | Alloted funds for gifts/award |Adityanath Yogi,Ameya Dubey,Avinash Thorat| 0    | Active |

  Scenario: Verify the update Details of the created award
    When User Login to application with "AdminUser" and "AdminPassword".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And User on left side bar navigate to "Configuration".
    And User on configuration navigate to link "Badges and Awards Management".
    And Search and select "Best Updated Automation Award_" Recognition "Awards" from list.
    And Verify the created Award following details.
      |Award Name|Best Updated Automation Award_|2|
      |Description|Update Award Through Automation_|3|
      |Status|Active|4                                |
      |Points|-|5                                     |

  Scenario Outline: Making Created/Updated Award  Inactive.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Badges and Awards Management".
    And  User on Award listing page  search recognition "Awards" click on "Edit" action of "Best Updated Automation Award_".
    And User on Award detail page add "<Status>" in Status field and Save.
    Examples:
      | Status |
      | Inactive |




