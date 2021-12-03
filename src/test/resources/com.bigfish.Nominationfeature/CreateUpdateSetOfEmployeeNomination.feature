########################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateUpdateSetOfEmployeeNomination.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Nominations
Feature: Create And Update Set Of Employee Nominations feature.
  #Set of employee Nomination
  Scenario: Create nomination for Set of employee
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations clicks on new "NewNominationBtn" field
    Then User create nomination Adding Values.
      |NominationTitle|Automation created nomination for Set of employee_|
      |NominationFor  |Bigfish Ratna|
      |description    |Automation created set of employee nomination guideline added_|
      |AwardFor       |Set of Employees|
      |SelfNominationSetting|Self and Others|
      |MaxNominations       |     5         |
      |Max employee in a set|      10         |
    And Add Criteria in Components while creating.
      |Who can be nominated   |All Employees|
    And User on nominations form clicks on save and defined button
    And Add Criteria in Components while creating.
      |Who can nominate   |List of Employees,Adityanath Yogi,Ameya Dubey|
      |Who can validate   |List of Employees,Adityanath Yogi,Ameya Dubey|
      |Who can vote       |List of Employees,Adityanath Yogi,Ameya Dubey|
    And  User on nomination form clicks on Publish button to publish nomination.

  Scenario: Verify the details of the created Set of Employees Nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VIEW PROGRESS".
    And User on  Nomination details page verify the created nomination details
      |Nomination Title|Automation created nomination for Set of employee_ |
      |Nomination Description|Automation created set of employee nomination guideline added_|
      |Award Name|Bigfish Ratna|
      |Award For|Set Of Employees|

  Scenario: Updated Created Nomination for Set of employee award.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VIEW PROGRESS".
    Then User Update nomination Adding Values.
      |NominationFor  |Angular upgrade award edit|
      |description    |Automation updated set of employee nomination guideline added_|
      |AwardFor       |Set of Employees|
      |SelfNominationSetting|Self and Others|
      |MaxNominations       |     4        |
      |Max employee in a set|      9         |
    And Add Criteria in Components while creating.
      |Who can be nominated   |List of Employees,Adityanath Yogi,Ameya Dubey|
      |Who can nominate   |Department,Engineering,Quality Assurance|
      |Who can vote       |Designation,Jr Quality Engineer,CEO|
    And  User on nomination form clicks on Publish button to publish nomination.

  Scenario: Verify the details of the created Set of Employees Nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VIEW PROGRESS".
    And User on  Nomination details page verify the created nomination details
      |Nomination Title|Automation created nomination for Set of employee_ |
      |Nomination Description|Automation updated set of employee nomination guideline added_|
      |Award Name|Angular upgrade award edit|
      |Award For|Set Of Employees|