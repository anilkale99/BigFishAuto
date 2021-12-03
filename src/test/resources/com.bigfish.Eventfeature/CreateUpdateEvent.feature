################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateUpdateEvent.feature
# Test ID    : Ev_1,Ev_2,Ev_3
# Test case  :
#################################################
@Regression
@Events
Feature: Create And Update Event feature.
  Scenario: Create Event with proper details.
  When User Login to application with "AdminUser" and "AdminPassword".
  And  User on left side bar navigate to "Events".
  And  User click on the "CREATE AN EVENT"  button and create.
  And User on create event  page add "Mahakal.jpg" banner image.
  And User on create event page add following details
    |EventName       |New Event Created Through Automation_|
    |Description     |The Event Description added Through Automation_|
    |EventCategory   |General  |
    |StartDate       |02 Dec 2021|
    |StartDateHours  |03       |
    |StartDateMinutes|21      |
    |EndDate         |20 Jun 2031|
    |EndDateHours    |10       |
    |EndDateMinutes  |22       |
    |Location        |Pune|
  And Add Criteria in Components while creating.
    |Event Audience|List of Employees,Adityanath Yogi,Ameya Dubey|
  And User click on the "CREATE EVENT"  button and create.

  Scenario: Verify Event with the added details.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Events".
    And  Search and click the Event "New Event Created Through Automation_" in Event list.
    And  User verifying the added details on the following event details
      |EventName       |New Event Created Through Automation_|
      |Description     |The Event Description added Through Automation_|
      |Location        |Pune|

  Scenario: Update Event with proper details
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Events".
    And  Search and click the Event "New Event Created Through Automation_" in Event list.
    And  User click on action button and select "Edit Event" from dropdown.
    And User on create event page add following details
      |EventName       |Updated Event Through Automation_|
      |Description     |Updated Event Description added Through Automation_|
      |EventCategory   |General|
      |StartDate       |01 Dec 2021|
      |StartDateHours  |07|
      |StartDateMinutes|28|
      |EndDate         |11 Jun 2051|
      |EndDateHours    |06|
      |EndDateMinutes  |22|
      |Location        |Mumbai|
    And Add Criteria in Components while creating.
      |Event Audience|All Employees|
    And User click on the "SAVE CHANGES"  button and create.

  Scenario: Verify Event with proper details.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Events".
    And  Search and click the Event "Updated Event Through Automation_" in Event list.
    And  User verifying the added details on the following event details
      |EventName       |Updated Event Through Automation_|
      |Description     |Updated Event Description added Through Automation_|
      |Location        |Mumbai|

  Scenario: Delete Event
   When User Login to application with "AdminUser" and "AdminPassword".
   And  User on left side bar navigate to "Events".
   And  Search and click the Event "Updated Event Through Automation_" in Event list.
   And  User click on action button and select "Delete Event" from dropdown.

