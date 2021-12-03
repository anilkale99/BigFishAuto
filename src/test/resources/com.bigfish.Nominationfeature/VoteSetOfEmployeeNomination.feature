########################################################
# Author     : Ratnakar Dubey
# Test Plane : VoteSetOfEmployeeNomination.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Nominations
Feature:Voting Set Of Employee Nominations feature.
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
      |Who can nominate   |List of Employees,Bigfish240 User240,Ameya Dubey|
      |Who can validate   |List of Employees,Bigfish240 User240,Ameya Dubey|
      |Who can vote       |List of Employees,Bigfish240 User240,Ameya Dubey|
    And  User on nomination form clicks on Publish button to publish nomination.

  Scenario: Submit nomination For Set of employee.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "NOMINATE".
    And User on submit nomination form Search and select employee in Set to nominate.
      | Avinash Thorat |
      | Sohail Khan|
      | Ratnakar Durgesh |
      | Prateek Dubey|

    And User on submit nomination form Search and select employee in Set to nominate.
      | Akshit Sood |
      | Prassanna Ghurde|
      | Arpita Jambad |
      | Ankit Jibhakate|
    And User Signing out from the Application.

  Scenario: Close the File Nomination stage in nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "FILE NOMINATIONS" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Avinash Thorat |
      | Akshit Sood    |

  Scenario: Initiate the Validation stage for created Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "VALIDATION" process.
    And User Signing out from the Application.

  Scenario: Validate nomination For Set of employee.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VALIDATE".
    And  User on validation detail page "ACCEPT" the Set of employee with team leader "Avinash Thorat".

  Scenario: Validate nomination For Set of employee.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VALIDATE".
    And  User on validation detail page "ACCEPT" the Set of employee with team leader "Akshit Sood".

  Scenario: Close the Validation stage in nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination".
    And User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "VALIDATION" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Adityanath Yogi |
      | Ameya Dubey     |

  Scenario: Initiate the Voting stage for created  Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "REVIEW" process.
    And User Signing out from the Application.

  Scenario:  Vote the created Predefined team Nomination.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Nomination".
    And  User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VOTE".
    And  User on voting stage select the set of employee and vote in nomination.
    And  User on Voting detail page select employee or team and click on button to vote.
      |Avinash Thorat |
      |Akshit Sood|


