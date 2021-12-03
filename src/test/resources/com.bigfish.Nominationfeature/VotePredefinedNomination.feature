########################################################
# Author     : Ratnakar Dubey
# Test Plane : VotePredefinedNomination.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Nominations
Feature:Voting Predefined Team Nominations feature.
#Predefined Team Nomination
  Scenario: Create nomination for Predefined Team
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations clicks on new "NewNominationBtn" field
    Then User create nomination Adding Values.
      |NominationTitle|Automation created nomination for Predefined_|
      |NominationFor  |Angular upgrade award edit|
      |description    |Automation created nomination guideline added_|
      |AwardFor       |Predefined Team|
      |SelfNominationSetting|Self and Others|
      |MaxNominations       |     5         |
    And User on nominations form clicks on save and defined button
    And Add Criteria in Components while creating.
      |Who can nominate   |List of Employees,Bigfish240 User240,Ameya Dubey|
      |Who can validate   |List of Employees,Adityanath Yogi,Ameya Dubey|
      |Who can vote       |List of Employees,Bigfish240 User240,Ameya Dubey|
    And  User on nomination form clicks on Publish button to publish nomination.

  Scenario: Submit nomination For Pre defined Team.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "NOMINATE".
    And User on submit nomination form search and select employee or Team employee to nominate.
      | Engineering Team |
      | Quality Assurance|
    And User Signing out from the Application.

  Scenario: Close the File Nomination stage in nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "FILE NOMINATIONS" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Adityanath Yogi |
      | Ameya Dubey     |

  #Validation for predefine team is not added on web.(Adding Initiate and Closed flow)
  Scenario: Initiate the Validation stage for created Predefined Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "VALIDATION" process.
    And User Signing out from the Application.

  Scenario: Close the Validation stage in nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "VALIDATION" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Adityanath Yogi |
      | Ameya Dubey     |

  Scenario: Initiate the Voting stage for created Individual Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "REVIEW" process.
    And User Signing out from the Application.

  Scenario:  Vote the created Predefined team Nomination.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VOTE".
    And  User on Voting detail page select employee or team and click on button to vote.
      | Engineering Team |
      | Quality Assurance|


  Scenario: Close the Voting stage in nomination and give away the award.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "REVIEW" stage.
    And User click on Give Award button of the Nomination award.
      | Engineering Team |
      | Quality Assurance|