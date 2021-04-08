Feature: Nominations feature

  @Nominations
  Scenario: Create Nomination
    When User enters value "Mahesh@bftest.com" in "username" field
    And User enters value "Welcome@123" in "password" field
    And User clicks on "Login"
    And User on left side bar navigate to "Nomination"
    And User on Nominations clicks on new "New Nomination" field
