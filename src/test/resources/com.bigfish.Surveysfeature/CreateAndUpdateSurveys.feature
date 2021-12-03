#########################################################
# Author     : Ratnakar Dubey
# Test Plane : CreateAndUpdateSurveys.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Surveys
Feature: Create Survey with proper details.
  Scenario:Create Survey with all question.
    When User Login to application with "SurveyAdminRole" and "SurveyAdminPassWord".
    And  User on left side bar navigate to "Polls and Surveys".
    And  User click on "SURVEYS" to navigate to polls details page.
    And  User click on the "NEW SURVEY"  button and create.
    And  User adding Survey Title "Survey Created through automation_" and description "Survey Description added through automation_" to create survey.
    And  User click on the "Continue"  button and create.
    And  User adding the Single choice, Multiple choice,Dropdown or scale Question in survey.
      |Question No|1|
      |Question Type|Single Choice|
      |Question|Single Question Added through Automation?|
      |Options|SingleChoiceAutomationChoice1,SingleChoiceAutomationChoice2,SingleChoiceAutomationChoice3|
    And  User adding the Single choice, Multiple choice,Dropdown or scale Question in survey.
      |Question No|2|
      |Question Type|Multi Choice|
      |Question|Multi Choice Question Added through Automation?|
      |Options|MultipleChoiceAutomationChoice1,MultipleChoiceAutomationChoice2,MultipleChoiceAutomationChoice3,MultipleChoiceAutomationChoice4|
   And  User adding the Simple Text Input,Long test Question or Net Promoter Score Question in survey.
      |Question No|3|
      |Question Type|Simple Text Input|
      |Question|Adding Simple text Question through Automation?|

    And  User adding the Simple Text Input,Long test Question or Net Promoter Score Question in survey.
      |Question No|4|
      |Question Type|Long Text Input|
      |Question|Long Text Input Question Added through Automation?|

    And  User adding the Single choice, Multiple choice,Dropdown or scale Question in survey.
      |Question No|5|
      |Question Type|Dropdown|
      |Question|Dropdown Question Added through Automation?|
      |Options|DropdownChoice1,DropdownChoice2,DropdownChoice3|

    And  User adding the Single choice, Multiple choice,Dropdown or scale Question in survey.
      |Question No|6|
      |Question Type|Scale Question|
      |Question|Scale Question Added through Automation?|
      |Label|AutomationLabel1,AutomationLabel2|

    And  User adding the Simple Text Input,Long test Question or Net Promoter Score Question in survey.
      |Question No|7|
      |Question Type|Net Promoter Score|
      |Question|Net Promoter Score Question Added through Automation?|

    And User click on the "Continue"  button and create.

    And Add and edit Criteria in Survey while creating.
      |Survey Audience|List of Employees,Adityanath Yogi,Ameya Dubey|
    And User adding Following settings in survey while creating.
    |How will results be captured?|Anonymously |
    |Is the survey mandatory?|Optional|
    And user adding dates in Surveys while creating.
      |StartDate   |02 Jun 2021|
      |EndDate     |23 Dec 2051|
    And User click on the "Continue"  button and create.
    And User click on the "Publish" button and confirm "Publish Now" to create Survey.

    Scenario: Update Created Survey details
    When User Login to application with "SurveyAdminRole" and "SurveyAdminPassWord".
    And  User on left side bar navigate to "Polls and Surveys".
    And  User click on "SURVEYS" to navigate to polls details page.
    And  User on  details page "Survey Created through automation_" submitting by clicking on "Edit" button.
    And  User adding Survey Title "Survey updated through automation_" and description "Survey updated Description added through automation_" to create survey.
    And  User click on the "Continue"  button and create.
    And  User click on the "Continue"  button and create.
    And Add and edit Criteria in Survey while creating.
      |Survey Audience|Department,Quality Assurance|
    And User adding Following settings in survey while creating.
      |Is the survey mandatory?|Optional|
    And user adding dates in Surveys while creating.
      |StartDate   |10 May 2021|
      |EndDate     |23 Dec 2061|
    And User click on the "Continue"  button and create.
      And User click on the "Publish" button and confirm "Publish Now" to create Survey.






