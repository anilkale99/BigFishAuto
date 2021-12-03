########################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateAndUpdateEmployee.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Profile
Feature: Create and Update profile.
Scenario Outline: Create employee with provided details.
  When User Login to application with "AdminUser" and "AdminPassword".
  And  User on left side bar navigate to "Configuration".
  And  User on configuration navigate to link "Employee Management".
  And  User click on the "Add Employee"  button and create.
  And  User on on employee creation page add "<Firstname>" "<Lastname>" "<Designation>" "<Department>" "<EmployeeCode>" "<PinCode>" "<Country>" "<State>" "<City>" "<Gender>" "<ReportTo>" "<AlternateManager>" "<IsPeopleManager>" "<DateOfBirth>" "<DateOfJoining>" "<Email>" "<Mobile>" "<Address>" "<StreetAdds>" "<AddressLine2>" "<EntityType>" "<EmployeeCategory>" "<Function>" "<Region>" "<Cluster>" "<Area>" "<Territory>" "<Grade>" "<Store>" "<Status>" details.
  And User on create Employee  page add "BalKrishna.jpg" Profile image.
  Examples:
|Firstname|Lastname|Designation      |Department       |EmployeeCode|PinCode|Country|State      |City      |Gender|ReportTo   |AlternateManager|IsPeopleManager|DateOfBirth|DateOfJoining|Email  |Mobile|Address|StreetAdds  |AddressLine2|EntityType|EmployeeCategory|Function  |Region  |Cluster  |Area    |Territory   |Grade   |Store   |Status|
|Ratnakar_|Dubey_  |Software Engineer|Quality Assurance|QA-         |414111 |India  |Maharashtra|Ahmednagar|FEMALE|Adit Daneil|Adityanath yogi |True           |27 Feb 1998|27 Feb 2015  |dubeyji|134560|Addr01 |StreetAddr02|AddrLine2   |Entity1   |FULL_TIME       |Function 2|Region 1|Cluster I|Hadapsar|My Territory|Grade II|Store 11|Active|


Scenario: Verify the details of created employee
  When User Login to application with "AdminUser" and "AdminPassword".
  And  User on left side bar navigate to "Configuration".
  And  User on configuration navigate to link "Employee Management".
  And  Search and select Employee "Ratnakar_" from employee list.
  And  Verify the created employee following details
      |Employee Code|QA-|2|
      |Employee Name|Ratnakar_|3|
      |Employee Name|Dubey_|3   |
      |Designation|Software Engineer|4|
      |City|Ahmednagar|5|
      |Department|Quality Assurance|6|
      |Manager|adit daneil|7         |

  Scenario Outline: Update the details of the created employee.
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Employee Management".
    And  Search and select Employee "Ratnakar_" from employee list.
    And  User click on action button and select "Edit Details" from dropdown for employee edit.
    And  User on on employee creation page add "<Firstname>" "<Lastname>" "<Designation>" "<Department>" "<EmployeeCode>" "<PinCode>" "<Country>" "<State>" "<City>" "<Gender>" "<ReportTo>" "<AlternateManager>" "<IsPeopleManager>" "<DateOfBirth>" "<DateOfJoining>" "<Email>" "<Mobile>" "<Address>" "<StreetAdds>" "<AddressLine2>" "<EntityType>" "<EmployeeCategory>" "<Function>" "<Region>" "<Cluster>" "<Area>" "<Territory>" "<Grade>" "<Store>" "<Status>" details.
    And User on create Employee  page add "Life.jpg" Profile image.
    Examples:
      | Firstname | Lastname | Designation       | Department        | EmployeeCode | PinCode | Country | State       | City       | Gender | ReportTo    | AlternateManager | IsPeopleManager | DateOfBirth | DateOfJoining | Email   | Mobile | Address | StreetAdds   | AddressLine2 | EntityType | EmployeeCategory | Function   | Region   | Cluster   | Area     | Territory    | Grade    | Store    | Status |
      | Automation_| Update_ |Jr Quality Engineer |Quality Engg| AU- | 412207  | India   | Maharashtra | Mumbai | UNSPECIFIED | Adit Daneil | Adityanath yogi  | False            | 27 Aug 1991| 27 Mar 2018   | Automation | 134560 | Addrs01  | StreetAddrs02 | AddrsLine2    | Entity1    | FULL_TIME        | Function 2 | Region 1 | Cluster I | Hadapsar | My Territory | Grade II | Store 11 | Active |

  Scenario: Verify the details of Updated employee
    When User Login to application with "AdminUser" and "AdminPassword".
    And  User on left side bar navigate to "Configuration".
    And  User on configuration navigate to link "Employee Management".
    And  Search and select Employee "Automation_" from employee list.
    And  Verify the created employee following details
      |Employee Code|AU-|2|
      |Employee Name|Automation_|3|
      |Employee Name|Update_|3   |
      |Designation  |Jr Quality Engineer|4|
      |City         |Mumbai|5|
      |Department   |Quality Engg|6|
      |Manager      |adit daneil|7|
