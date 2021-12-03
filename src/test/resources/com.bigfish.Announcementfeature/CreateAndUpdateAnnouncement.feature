##########################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateAndUpdateAnnouncement.feature
# Test ID    : An_1,An_2
# Test case  : 1.2,1.3,1.4,1.5,1.6,1.7,1.8
##########################################################
@Regression
@Announcement
Feature: Create and Update Announcement.
 Scenario: Create Announcement with proper details.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Announcements".
    And  User click on the "NEW ANNOUNCEMENT"  button and create.
    And User on create Announcement page add "Mahakal.jpg" banner image.
    And User on create Announcement page add following details
    |AnnouncementName| Announcement Created through Automation_|
    |Description|Description Added for Created Announcement through Automation_|
    |Category|General|
    And Add Criteria in Components while creating.
      |Announcement Audience|List of Employees,Adityanath Yogi,Ameya Dubey|
    And User adding following attachment while creating
     | Attachment |ImportEmployeeTemplate.xlsx,AutomationDemoVedio.mp4,BalKrishna.jpg|
   And User click on the "Post" button to create announcement.

  Scenario: Verify the created Announcement details.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Announcements".
    And  Search and click the Announcement "Announcement Created through Automation_" in Announcement list.
    And User on  Announcement page verify following details
      |AnnouncementName| Announcement Created through Automation_|
      |Description|Description Added for Created Announcement through Automation_|
      |Category|General|


  Scenario: Update Announce With proper details.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Announcements".
    And  Search and click the Announcement "Announcement Created through Automation_" in Announcement list.
    And  User click on circle dot button and select "Edit" from dropdown.
    And User on create Announcement page add following details
      |AnnouncementName| Announcement Updated through Automation_|
      |Description|Description Added for Updated Announcement through Automation_|
      |Category|Don't delete Auto Announcement category|
    And Add Criteria in Components while creating.
      |Announcement Audience|All Employees|
    And User click on the "SAVE"  button and create.

    Scenario: Verify the updated Announcement details.
      When User Login to application with "AdminUser" and "AdminPassword".
      And  User on left side bar navigate to "Announcements".
      And  Search and click the Announcement "Announcement Updated through Automation_" in Announcement list.
      And User on  Announcement page verify following details
        |AnnouncementName| Announcement Updated through Automation_|
        |Description|Description Added for Updated Announcement through Automation_|
        |Category|Don't delete Auto Announcement category|






