######################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateAndUpdateAnnouncement.feature
# Test ID    : Camp_1,Camp_2
# Test case  :
#######################################################
@Regression
@Campaign
Feature: Contribute Text post in campaign.
   Scenario:Create campaign for Text post verification
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  User click on the "NEW CAMPAIGN"  button and create.
    And User on create campaign  page add "Life.jpg" banner image.
    And User on create campaign page add following details
      |CampaignName|New Campaign Through Automation for text post_|
      |Description |The Campaign Discription Through Automation for text post _|
      |StartDate   |25 Jun 2021|
      |EndDate     |31 Dec 2051|
    And Add Criteria in Components while creating.
      |Campaign Audience|List of Employees,Bigfish240 User240,Ameya Dubey|
    And User click on the "CREATE CAMPAIGN"  button and create.

  Scenario: Search and participate self and contribute only text in the created campaign.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for text post_" in campaign list.
    And  User click on "PARTICIPATE" Button to participate in campaign.
    Then User click on "CONTRIBUTE" Button And contribute text "Automation Text post in campaign" in Campaign post.

  Scenario: Verify the comment added on the Text post
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for text post_" in campaign list.
    And  User on campaign detail page verify the text "Automation Text post in campaign" added on the post.


  Scenario: Search and Contribute Text post in  campaign by user
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for text post_" in campaign list.
    And  User click on "PARTICIPATE" Button to participate in campaign.
    Then User click on "CONTRIBUTE" Button And contribute text "Automation Text post in campaign" in Campaign post.
  Scenario: Verify the added campaign Text post by Normal user

  Scenario: Add comment to the contributed post  by self and another user too.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for text post_" in campaign list.
    And User on Campaign Detail page click on "Automation Text post in campaign" post and add "Automation added comment By owner" comment on it.
    Then User Signing out from the Application.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for text post_" in campaign list.
    And User on Campaign Detail page click on "Automation Text post in campaign" post and add "Automation added comment by normal use" comment on it.

  Scenario: Delete Campaign
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for text post_" in campaign list.
    And  User click on action button and select "DELETE" from dropdown.