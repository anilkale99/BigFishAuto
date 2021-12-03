########################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateUpdateIndividualNomination.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Nominations
Feature: Create And Update Individual Nominations feature.
#Individual Nomination
  Scenario: Create nomination for individual award.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination".
    And User on Nominations clicks on new "NewNominationBtn" field
    Then User create nomination Adding Values.
      |NominationTitle|Automation created nomination for Individual Award_|
      |NominationFor  | Bigfish Ratna   |
      |description    |Automation created nomination guideline added_|
      |AwardFor       |Individual       |
      |SelfNominationSetting|Self and Others|
      |MaxNominations       |     5         |
    And Add Criteria in Components while creating.
      |Who can be nominated   |All Employees|
    And User on nominations form clicks on save and defined button
    And Add Criteria in Components while creating.
      |Who can nominate   |List of Employees,Adityanath Yogi,Ameya Dubey|
      |Who can validate   |List of Employees,Adityanath Yogi,Ameya Dubey|
      |Who can vote       |List of Employees,Adityanath Yogi,Ameya Dubey|
    And  User on nomination form clicks on Publish button to publish nomination.

  Scenario: Verify the details of the created Individual Nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And User on  Nomination details page verify the created nomination details
      |Nomination Title|Automation created nomination for Individual Award_ |
      |Nomination Description|Automation created nomination guideline added_|
      |Award Name|Bigfish Ratna|
      |Award For|Individual Award|


  Scenario: Updated Created Nomination for individual award.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Individual Award_3071" nomination and clicks on "VIEW PROGRESS".
    Then User Update nomination Adding Values.
      |description          |Automation updated nomination guideline added_|
      |SelfNominationSetting|Self and Others|
      |MaxNominations       |     5         |
      |AwardFor             |Individual       |
    And Add Criteria in Components while creating.
      |Who can be nominated   |List of Employees,Adityanath Yogi,Ameya Dubey|
      |Who can nominate       |Department,Engineering,Quality Assurance     |
      |Who can vote           |Designation,Jr Quality Engineer,CEO          |
    And  User on nomination form clicks on Publish button to publish nomination.


Scenario: Verify the details of the Updated Individual Nomination
   When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
  And User on  Nomination details page verify the created nomination details
    |Nomination Title|Automation created nomination for Individual Award_|
    |Nomination Description|Automation updated nomination guideline added_|
    |Award Name|Bigfish Ratna|
    |Award For|Individual Award|
