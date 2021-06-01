Feature: Nominations feature
  @Nominations
  Scenario: Create nomination for individual award
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    When User on Nominations clicks on new "NewNominationBtn" field
    And  User on nomination form enter "Automation created nomination for Individual Award_" in title field
    And  User on nomination form enter "Bigfish Ratna" in nomination for field
    And  User on nomination form enter "Automation created nomination guideline added_" in description field
    And  User on nomination form enter "Individual" in award for field
    And  User on nomination form enter "All Employees" and "1" and "2" in Criteria field
      | SKIP |
    And  User on nomination form enter "Self and Others" in Self Nomination Setting field
    And  User on nomination form enter "5" in Max Nominations field
    When User on nominations form clicks on "Save & Define Workflow" button
    And  User on nomination Stage I workflow part of form enters "List of Employees" and "2" and "3" in Criteria field
      | Adityanath Yogi |
      | Ameya Dubey     |
    And  User on nomination Stage II workflow part of form enters "List of Employees" and "4" and "4" in Criteria field
      | Adityanath Yogi |
      | Ameya Dubey     |
    And User on nomination Stage III workflow part of form enters "List of Employees" and "3" and "4" in Criteria field
      | Adityanath Yogi |
      | Ameya Dubey     |
    And  User on nomination form clicks on "PublishButton" button to publish nomination.

#Scenario: Verify the details of the created Individual Nomination
#   When User Login to application with "nomiRoleUser" and "nomiRolePassword".
#    And User on left side bar navigate to "Nomination"
#    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
#    And Verify the nomination title field "Automation created nomination for Individual Award_" of the created nomination.
#    And Verify the nomination for field "Bigfish Ratna" of the created nomination.
#    And Verify the nomination guideline field "Automation created nomination guideline added_" of the created nomination.
#    And Verify the award for field "Individual" of the created nomination.
#    And Verify the Self Nomination Setting field "Self and Others" of the created nomination.
#    And Verify the Max Nominations Submitted field "5" of created nomination.

  Scenario: Submit nomination of the user for the individual award.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "NOMINATE".
    And User on submit nomination form search and select employee or Team employee to nominate.
      | Adityanath Yogi |
      | Ameya Dubey     |
    And User Signing out from the Application.

 Scenario: Close the File Nomination stage in nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "FILE NOMINATIONS" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Adityanath Yogi |
      | Ameya Dubey     |

Scenario: Initiate the Validation stage for created Individual Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination"
    And  User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "VALIDATION" process.
    And User Signing out from the Application.

  Scenario: Validate the users in validation stage list
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Nomination"
    And  User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VALIDATE".
    And  User click on view details link and validated employee by "ACCEPT" the "Bigfish Ratna" Nomination process.
      | Adityanath   |
      | Ameya         |

  Scenario: Close the Validation stage in nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "VALIDATION" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Adityanath Yogi |
      | Ameya Dubey     |
  Scenario: Initiate the Voting stage for created Individual Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination"
    And  User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "REVIEW" process.
    And User Signing out from the Application.

  Scenario:  Vote the created individual Nomination.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Nomination"
    And  User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VOTE".
    And   User on Voting detail page select employee or team and click on button to vote.
      | Adityanath Yogi |
      | Ameya Dubey     |
    And User Signing out from the Application.

  Scenario: Close the Voting stage in nomination and give away the award.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "REVIEW" stage.
    And User click on Give Award button of the Nomination award.
      | Adityanath Yogi |
      | Ameya Dubey     |
    And  User Signing out from the Application.

Scenario: Create nomination for Predefined Team
  When User Login to application with "nomiRoleUser" and "nomiRolePassword".
  And User on left side bar navigate to "Nomination"
  And User on Nominations clicks on new "NewNominationBtn" field
  And  User on nomination form enter "Automation created nomination for Predefined_" in title field
  And  User on nomination form enter "Angular upgrade award edit" in nomination for field
  And  User on nomination form enter "Automation created nomination guideline added_" in description field
  And  User on nomination form enter "Predefined Team" in award for field
  And  User on nomination form enter "5" in Max Nominations field
  And User on nominations form clicks on "Save & Define Workflow" button
  And  User on nomination Stage I workflow part of form enters "List of Employees" and "2" and "2" in Criteria field
    | Adityanath Yogi |
    | Ameya Dubey     |
  And  User on nomination Stage II workflow part of form enters "List of Employees" and "4" and "3" in Criteria field
    | Adityanath Yogi |
    | Ameya Dubey     |
  And User on nomination Stage III workflow part of form enters "List of Employees" and "3" and "3" in Criteria field
    | Adityanath Yogi |
    | Ameya Dubey     |
  And  User on nomination form clicks on "PublishButton" button to publish nomination.

  Scenario: Submit nomination For Pre defined Team.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "NOMINATE".
    And User on submit nomination form search and select employee or Team employee to nominate.
      | Engineering Team |
      | Quality Assurance|
    And User Signing out from the Application.

  Scenario: Close the File Nomination stage in nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "FILE NOMINATIONS" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Adityanath Yogi |
      | Ameya Dubey     |
#Validation for predefine team is not added on web.(Adding Initiate and Closed flow)
  Scenario: Initiate the Validation stage for created Predefined Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination"
    And  User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "VALIDATION" process.
    And User Signing out from the Application.

#  Scenario: Validate the users in validation stage list

  Scenario: Close the Validation stage in nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "VALIDATION" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Adityanath Yogi |
      | Ameya Dubey     |

  Scenario: Initiate the Voting stage for created Individual Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination"
    And  User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "REVIEW" process.
    And User Signing out from the Application.

  Scenario:  Vote the created individual Nomination.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Nomination"
    And  User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VOTE".
    And  User on Voting detail page select employee or team and click on button to vote.
      | Engineering Team |
      | Quality Assurance|


  Scenario: Close the Voting stage in nomination and give away the award.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Predefined_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "REVIEW" stage.
    And User click on Give Award button of the Nomination award.
      | Engineering Team |
      | Quality Assurance|

Scenario: Create nomination for Set of employee
  When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations clicks on new "NewNominationBtn" field
    And  User on nomination form enter "Automation created nomination for Set of employee_" in title field
    And  User on nomination form enter "Bigfish Ratna" in nomination for field
    And  User on nomination form enter "Automation created nomination guideline added_" in description field
    And  User on nomination form enter "Set of Employees" in award for field
    And  User on nomination form enter "10" in Max employee in a set field
    And  User on nomination form enter "All Employees" and "1" and "2" in Criteria field
      | SKIP |
    And  User on nomination form enter "Self and Others" in Self Nomination Setting field
    And  User on nomination form enter "20" in Max Nominations field
    And  User on nominations form clicks on "Save & Define Workflow" button
  And  User on nomination Stage I workflow part of form enters "List of Employees" and "2" and "3" in Criteria field
    | Adityanath Yogi |
    | Ameya Dubey     |
  And  User on nomination Stage II workflow part of form enters "List of Employees" and "4" and "4" in Criteria field
    | Adityanath Yogi |
    | Ameya Dubey     |
  And User on nomination Stage III workflow part of form enters "List of Employees" and "3" and "4" in Criteria field
    | Adityanath Yogi |
    | Ameya Dubey     |
  And  User on nomination form clicks on "PublishButton" button to publish nomination.

Scenario: Submit nomination For Set of employee.
  When User Login to application with "NormalUserUsername" and "NormalUserPassword".
  And User on left side bar navigate to "Nomination"
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
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VIEW PROGRESS".
    And User Click on Close stage button and close the nomination "FILE NOMINATIONS" stage.
    And User clicks on move nominee button and select option "MOVE ALL" and move nominees
      | Avinash Thorat |
      | Akshit Sood     |

Scenario: Initiate the Validation stage for created Individual Nomination.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And  User on left side bar navigate to "Nomination"
    And  User on Nominations list page searching "Automation created nomination for Set of employee_" nomination and clicks on "VIEW PROGRESS".
    And  User click on initiate button to initiate "VALIDATION" process.
    And User Signing out from the Application.

#Scenario: Validate nomination For Set of employee. .





