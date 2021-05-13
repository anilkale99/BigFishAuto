Feature: Nominations feature

  @Nominations
Scenario: Create nomination for individual award
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    When User on Nominations clicks on new "NEW_NOMINATION_BTN" field
    And  User on nomination form enter "Automation created nomination for Individual Award_" in title field
    And  User on nomination form enter "Bigfish Ratna" in nomination for field
    And  User on nomination form enter "Automation created nomination guideline added" in description field
    And  User on nomination form enter "Individual" in award for field
    And  User on nomination form enter "All Employees" and "SKIP" and 1 and 2 and 1 in Criteria field
    And  User on nomination form enter "Self and Others" in Self Nomination Setting field
    And  User on nomination form enter "5" in Max Nominations field
    When User on nominations form clicks on "Save & Define Workflow" button
    And  User on nomination Stage I workflow part of form enters "List of Employees" and "Adityanath Yogi" and 2 and 3 and 1 in Criteria field
    And  User on nomination Stage II workflow part of form enters "List of Employees" and "Adityanath Yogi" and 4 and 4 and 2 in Criteria field
    And User on nomination Stage III workflow part of form enters "List of Employees" and "Adityanath Yogi" and 3 and 4 and 2 in Criteria field
    And  User on nomination form clicks on "PublishButton" button to publish nomination.

Scenario: Create nomination for Predefined Team
  When User Login to application with "nomiRoleUser" and "nomiRolePassword".
  And User on left side bar navigate to "Nomination"
  And User on Nominations clicks on new "NEW_NOMINATION_BTN" field
  And  User on nomination form enter "Automation created nomination for Predefined_" in title field
  And  User on nomination form enter "Angular upgrade award edit" in nomination for field
  And  User on nomination form enter "Automation created nomination guideline added_" in description field
  And  User on nomination form enter "Predefined Team" in award for field
  And  User on nomination form enter "5" in Max Nominations field
  And User on nominations form clicks on "Save & Define Workflow" button
  And  User on nomination Stage I workflow part of form enters "List of Employees" and "Adityanath Yogi" and 2 and 2 and 1 in Criteria field
  And  User on nomination Stage II workflow part of form enters "List of Employees" and "Adityanath Yogi" and 4 and 3 and 2 in Criteria field
  And User on nomination Stage III workflow part of form enters "List of Employees" and "Adityanath Yogi" and 3 and 3 and 2 in Criteria field
  And  User on nomination form clicks on "PublishButton" button to publish nomination.

Scenario: Create nomination for Set of employee
  When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations clicks on new "NEW_NOMINATION_BTN" field
    And  User on nomination form enter "Automation created nomination for Set of employee_" in title field
    And  User on nomination form enter "Bigfish Ratna" in nomination for field
    And  User on nomination form enter "Automation created nomination guideline added_" in description field
    And  User on nomination form enter "Set of Employees" in award for field
    And  User on nomination form enter "10" in Max employee in a set field
    And  User on nomination form enter "Department" and "Engineering" and 1 and 2 and 1 in Criteria field
    And  User on nomination form enter "Self and Others" in Self Nomination Setting field
    And  User on nomination form enter "20" in Max Nominations field
    And  User on nominations form clicks on "Save & Define Workflow" button
    And  User on nomination Stage I workflow part of form enters "Grade" and "Grade II" and 2 and 3 and 2 in Criteria field
    And  User on nomination Stage II workflow part of form enters "List of Employees" and "Adityanath Yogi" and 4 and 4 and 3 in Criteria field
    And  User on nomination Stage III workflow part of form enters "Cluster2" and "Cluster II" and 3 and 4 and 3 in Criteria field
    And  User on nomination form clicks on "PublishButton" button to publish nomination.



Scenario: Verify the details of the created Individual Nomination
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "VIEW PROGRESS".
    And Verify the nomination title field "Automation created nomination for Individual Award_" of the created nomination.
    And Verify the nomination for field "Bigfish Ratna" of the created nomination.
    And Verify the nomination guideline field "Automation created nomination guideline added_" of the created nomination.
    And Verify the award for field "Individual" of the created nomination.
    And Verify the Self Nomination Setting field "Self and Others" of the created nomination.
    And Verify the Max Nominations Submitted field "5" of created nomination.

Scenario: Submit nomination flow for the individual award.
    When User Login to application with "nomiRoleUser" and "nomiRolePassword".
    And User on left side bar navigate to "Nomination"
    And User on Nominations list page searching "Automation created nomination for Individual Award_" nomination and clicks on "NOMINATE".
    And User on submit nomination form search and select employee "Adityanath Yogi" to nominate.





