########################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateUpdatePoll.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Polls
Feature: Create poll
Scenario: Create poll with proper details
  When User Login to application with "PollsAdminRoleUser" and "PollsAdminRolePassword".
  And  User on left side bar navigate to "Polls and Surveys".
  And  User click on "POLLS" to navigate to polls details page.
  And  User click on the "NEW POLL"  button and create.
  And Add Criteria in Components while creating.
    |Poll Audience|List of Employees,Adityanath Yogi,Bigfish240 User240|
  And  User adds following details to create polls.
  |Poll Question|Poll Question is created through Automation_|
  |Poll Option 1|Poll Option1 added through automation_|
  |Poll Option 2|Poll Option2 added through automation_|
  |Poll Till Date|31 Dec 2051|
  |Anonymous Option|Yes|
  |Option For Show Result|After closure|
  And User click on the "PUBLISH"  button and create poll.

  Scenario: Verify the details of the created poll.
    When User Login to application with "PollsAdminRoleUser" and "PollsAdminRolePassword".
    And  User on left side bar navigate to "Polls and Surveys".
    And  User click on "POLLS" to navigate to polls details page.
    And  User verifying the following details of the created poll.
      |Poll Question|Poll Question is created through Automation_|
      |Poll Option|Poll Option1 added through automation_,Poll Option2 added through automation_|
      |End Date|31 Dec 2051|
      |Is Anonymous?|Yes|
      |Show Result|After closure|


    Scenario: Submit Created poll and verify poll is submitted or not.
      When User Login to application with "NormalUserUsername" and "NormalUserPassword".
      And  User on left side bar navigate to "Polls and Surveys".
      And  User click on "POLLS" to navigate to polls details page.
      And  Search and submit the created poll "Poll Question is created through Automation_" with option "Poll Option2 added through automation_" from Polls listing page.

