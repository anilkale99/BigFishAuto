##########################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateAndUpdateAnnouncement.feature
# Test ID    : Camp_1,Camp_2
# Test case  :
###########################################################
@Regression
@Campaign
Feature: Contribute Video post in campaign.
  Scenario:Create campaign for Text post verification
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  User click on the "NEW CAMPAIGN"  button and create.
    And User on create campaign  page add "Life.jpg" banner image.
    And User on create campaign page add following details
      |CampaignName|New Campaign Through Automation for Video post_|
      |Description |The Campaign Description Through Automation for Video post _|
      |StartDate   |25 Jun 2021|
      |EndDate     |31 Dec 2051|
    And Add Criteria in Components while creating.
      |Campaign Audience|List of Employees,Bigfish240 User240,Ameya Dubey|
    And User click on the "CREATE CAMPAIGN"  button and create.

  Scenario: Contribute campaign Video post by user
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for Video post_" in campaign list.
    And  User click on "PARTICIPATE" Button to participate in campaign.
    Then User click on "CONTRIBUTE" Button And contribute Image or Video "AutomationDemoVedio1.mp4" and Comment "Automation Video post in campaign By user" in Campaign post.

  Scenario: Verify the comment added on the Image post
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for Video post_" in campaign list.
    And  User on campaign detail page verify the text "Automation Video post in campaign By user" added on the post.

  Scenario: Add comment to the contributed Video post  by self and another user too.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for Video post_" in campaign list.
    And User on Campaign Detail page click on "Automation Video post in campaign" post and add "Automation added comment By owner on Video post" comment on it.
    Then User Signing out from the Application.
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for Video post_" in campaign list.
    And User on Campaign Detail page click on "Automation Video post in campaign" post and add "Automation added comment by normal use on video" comment on it.

  Scenario: Delete Campaign
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "New Campaign Through Automation for Video post_" in campaign list.
    And  User click on action button and select "DELETE" from dropdown.
