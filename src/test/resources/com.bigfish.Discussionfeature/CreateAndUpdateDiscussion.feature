#####################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateAndUpdateDiscussion.feature
# Test ID    : Disc_1,Disc_1
# Test case  :
######################################################
@Regression
@Discussion
Feature: Create and Update Discussion.
  Scenario: Create Discussion with proper details.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Discussions".
    And  User click on the "START DISCUSSION"  button and create.
    And User on create Discussion page add following details
      |Category|Don't Delete Automation General Discussion Category|
      |DiscussionName| Discussion Created through Automation_|
      |Discussion Question|Discussion Question added through Automation_|
    And User adding following attachment while creating
      | Attachment |ImportEmployeeTemplate.xlsx,AutomationDemoVedio.mp4,BalKrishna.jpg|
    And User click on the "DONE"  button and create.

  Scenario: Verify the created Discussion details.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Discussions".
    And  Search and click the Discussion "Discussion Created through Automation_" in discussion list.
    And User on  Discussion page verify following details
      |DiscussionName| Discussion Created through Automation_|
      |Discussion Question|Discussion Question added through Automation_|
      |Category|Don't Delete Automation General Discussion Category|


  Scenario: Update Discussion With proper details.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Discussions".
    And  Search and click the Discussion "Discussion Created through Automation_" in discussion list.
    And  User click on circle dot button and select "Edit" from dropdown.
    And User on Update Discussion page add following details
      |AnnouncementName| Discussion Updated through Automation_|
      |Discussion Question|Discussion Question Updated through Automation_|
    And User click on the "DONE"  button and create.

  Scenario: Verify the updated Discussion details.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Discussions".
    And  Search and click the Discussion "Discussion Updated through Automation_" in discussion list.
    And User on  Discussion page verify following details
      |DiscussionName| Discussion Updated through Automation_|
      |Discussion Question|Discussion Question Updated through Automation_|






