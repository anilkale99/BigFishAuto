#####################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateUpdateCampaign.feature
# Test ID    : Camp_1,Camp_2
# Test case  :
######################################################
@Regression
@Campaign
Feature: Create and update campaign feature
Scenario:Create new campaign
  When User Login to application with "AdminUser" and "AdminPassword".
  And  User on left side bar navigate to "Campaigns".
  And  User click on the "NEW CAMPAIGN"  button and create.
  And User on create campaign  page add "Mahakal.jpg" banner image.
  And User on create campaign page add following details
  |CampaignName|New Campaign Through Automation_|
  |Description |The Campaign is created Through Automation_|
  |StartDate   |02 Jun 2021|
  |EndDate     |23 Dec 2051|
  And Add Criteria in Components while creating.
    |Campaign Audience|List of Employees,Bigfish240 User240,Ameya Dubey|
  And User click on the "CREATE CAMPAIGN"  button and create.

 Scenario: Verify the Created campaign.
   When User Login to application with "AdminUser" and "AdminPassword".
   And  User on left side bar navigate to "Campaigns".
   And  Search and click the campaign "New Campaign Through Automation_" in campaign list.
   And  User on Campaign page verify the Details added while creating.
     |CampaignName|New Campaign Through Automation_|
     |Description |The Campaign is created Through Automation_|
    |StartDate   |2 Jun 2021|
    |EndDate     |23 Dec 2051|

 Scenario: Update the created Campaign.
   When User Login to application with "AdminUser" and "AdminPassword".
   And  User on left side bar navigate to "Campaigns".
   And  Search and click the campaign "New Campaign Through Automation_" in campaign list.
   And  User click on action button and select "EDIT" from dropdown.
   And  User on create campaign  page add "Life.jpg" banner image.
   And User on create campaign page add following details
     |CampaignName|Update Campaign Through Automation_|
     |Description |The Campaign is Updated Throught Automation_|
     |StartDate   |09 Aug 2021|
     |EndDate     |30 Dec 2051|
   And Add Criteria in Components while creating.
     |Campaign Audience|All Employees|
   And User click on the "SAVE CHANGES"  button and create.

  Scenario: Verify the Updated Campaign.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the campaign "Update Campaign Through Automation_" in campaign list.
    And  User on Campaign page verify the Details added while creating.
      |CampaignName|Update Campaign Through Automation_|
      |Description |The Campaign is Updated Throught Automation_|
      |StartDate   |9 Aug 2021|
      |EndDate     |30 Dec 2051|

  Scenario: Delete Campaign
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Campaigns".
    And  Search and click the Event "Update Campaign Through Automation_" in Event list.
    And  User click on action button and select "DELETE" from dropdown.

