########################################################
# Author     : Ratnakar Dubey
# Test Plane : VoteIndividualNomination.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Nominations
Feature:Voting Individual Nominations feature.
#IndividualAward
  Scenario: Create nomination for individual award.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination".
    And User on Nominations clicks on new "NewNominationBtn" field
    Then User create nomination Adding Values.
      |NominationTitle|Automation created nomination for Individual Award_|
      |NominationFor  | Bigfish Ratna   |
      |description    |Automation created nomination guideline added_     |
      |AwardFor       |Individual       |
      |SelfNominationSetting|Self and Others|
      |MaxNominations       |     5         |
    And Add Criteria in Components while creating.
      |Who can be nominated   |All Employees|
    And User on nominations form clicks on save and defined button
    And Add Criteria in Components while creating.
      |Who can nominate   |List of Employees,Bigfish240 User240,Ameya Dubey|
      |Who can validate   |List of Employees,Bigfish240 User240,Ameya Dubey|
      |Who can vote       |List of Employees,Bigfish240 User240,Ameya Dubey|
    And  User on nomination form clicks on Publish button to publish nomination.


  Scenario: Submit nomination of the user for the individual award.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "NOMINATE".
    And User on submit nomination form search and select employee or Team employee to nominate.
      | Adityanath Yogi |
      | Ameya Dubey     |
    And User Signing out from the Application.

  Scenario: Close the File Nomination stage in nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "FILE NOMINATIONS" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Adityanath Yogi |
      | Ameya Dubey     |

  Scenario: Initiate the Validation stage for created Individual Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "VALIDATION" process.
    And User Signing out from the Application.

  Scenario: Validate the users in validation stage list
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VALIDATE".
    And  User click on view details link and validated employee by "ACCEPT" the "Bigfish Ratna" Nomination process.
      | Adityanath   |
      | Ameya        |

  Scenario: Close the Validation stage in nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "VALIDATION" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Adityanath Yogi |
      | Ameya Dubey     |
  Scenario: Initiate the Voting stage for created Individual Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "REVIEW" process.
    And User Signing out from the Application.

  Scenario:  Vote the created individual Nomination.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VOTE".
    And   User on Voting detail page select employee or team and click on button to vote.
      | Adityanath Yogi |
      | Ameya Dubey     |
    And User Signing out from the Application.

  Scenario: Close the Voting stage in nomination and give away the award.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "REVIEW" stage.
    And User click on Give Award button of the Nomination award.
      | Adityanath Yogi |
      | Ameya Dubey     |
    And  User Signing out from the Application.

