#########################################################
# Author     : Ratnakar Dubey
# Test Plane : SubmitSurvey.feature
# Test ID    :
# Test case  :
#########################################################
@Regression
@Survey
Feature: Submit Survey
  Scenario:Create Survey with all question.
    When User Login to application with "SurveyAdminRole" and "SurveyAdminPassWord".
    And  User on left side bar navigate to "Polls and Surveys".
    And  User click on "SURVEYS" to navigate to polls details page.
    And  User click on the "NEW SURVEY"  button and create.
    And  User adding Survey Title "_Survey Created through automation" and description "_Survey Description added through automation to verify submit flow" to create survey.
    And  User click on the "Continue"  button and create.
    And  User adding the Single choice, Multiple choice,Dropdown or scale Question in survey.
      |Question No|1|
      |Question Type|Single Choice|
      |Question|Single Question Added through Automation for Submit?|
      |Options|SingleChoiceAutomationChoice_1,SingleChoiceAutomationChoice_2,SingleChoiceAutomationChoice_3|
    And  User adding the Single choice, Multiple choice,Dropdown or scale Question in survey.
      |Question No|2|
      |Question Type|Multi Choice|
      |Question|Multi Choice Question Added through Automation for Submit?|
      |Options|MultipleChoiceAutomationChoice_1,MultipleChoiceAutomationChoice_2,MultipleChoiceAutomationChoice_3,MultipleChoiceAutomationChoice_4|
    And  User adding the Simple Text Input,Long test Question or Net Promoter Score Question in survey.
      |Question No|3|
      |Question Type|Simple Text Input|
      |Question|Adding Simple text Question through Automation for Submit?|

    And  User adding the Simple Text Input,Long test Question or Net Promoter Score Question in survey.
      |Question No|4|
      |Question Type|Long Text Input|
      |Question|Long Text Input Question Added through Automation for Submit?|

    And  User adding the Single choice, Multiple choice,Dropdown or scale Question in survey.
      |Question No|5|
      |Question Type|Dropdown|
      |Question|Dropdown Question Added through Automation for Submit?|
      |Options|DropdownChoice_1,DropdownChoice_2,DropdownChoice_3|

    And  User adding the Single choice, Multiple choice,Dropdown or scale Question in survey.
      |Question No|6|
      |Question Type|Scale Question|
      |Question|Scale Question Added through Automation for Submit?|
      |Label|AutoLabel_1,AutoLabel_2|

    And  User adding the Simple Text Input,Long test Question or Net Promoter Score Question in survey.
      |Question No|7|
      |Question Type|Net Promoter Score|
      |Question|Net Promoter Score Question Added through Automation for Submit?|

    And User click on the "Continue"  button and create.

    And Add and edit Criteria in Survey while creating.
      |Survey Audience|List of Employees,Bigfish240 User240,Ameya Dubey|
    And User adding Following settings in survey while creating.
      |How will results be captured?|Anonymously |
      |Is the survey mandatory?|Optional|
    And user adding dates in Surveys while creating.
      |StartDate   |02 May 2021|
      |EndDate     |23 Aug 2051|
    And User click on the "Continue"  button and create.
    And User click on the "Publish" button and confirm "Publish Now" to create Survey.

Scenario: Submit survey with respective choices by admin user
  When User Login to application with "SurveyAdminRole" and "SurveyAdminPassWord".
  And  User on left side bar navigate to "Polls and Surveys".
  And  User click on "SURVEYS" to navigate to polls details page.
  And  User on  details page "_Survey Created through automation" submitting by clicking on "Take Survey" button.
  And  User on Submit survey page adding following choices.
#  1 Question type, 2 Survey Question, 3 Choices.
  |Single Choice|Single Question Added through Automation for Submit?|SingleChoiceAutomationChoice_2|
  |Multi Choice |Multi Choice Question Added through Automation for Submit?|MultipleChoiceAutomationChoice_1,MultipleChoiceAutomationChoice_4|
  |Text Input|Adding Simple text Question through Automation for Submit?|Ratnakar adding simple text answer in survey|
  |Text Input|Long Text Input Question Added through Automation for Submit?|Ratnakar adding Long text answer in survey through automation so the we can check the its working properly or not |
  |Dropdown|Dropdown Question Added through Automation for Submit?|DropdownChoice_3|
  |Scale Question|Scale Question Added through Automation for Submit?|5|
  |Single Choice|Net Promoter Score Question Added through Automation for Submit?|10|
  And User click on the "Submit" button and confirm "BACK TO ALL SURVEYS" to create Survey.

  Scenario: Submit survey with respective choices by normal user
    When User Login to application with "NormalUserUsername" and "NormalUserPassword".
    And  User on left side bar navigate to "Polls and Surveys".
    And  User click on "SURVEYS" to navigate to polls details page.
    And  User on  details page "_Survey Created through automation" submitting by clicking on "Take Survey" button.
    And  User on Submit survey page adding following choices.
#  1 Question type, 2 Survey Question, 3 Choices.
      |Single Choice|Single Question Added through Automation for Submit?|SingleChoiceAutomationChoice_2|
      |Multi Choice |Multi Choice Question Added through Automation for Submit?|MultipleChoiceAutomationChoice_1,MultipleChoiceAutomationChoice_4|
      |Text Input|Adding Simple text Question through Automation for Submit?|Ratnakar adding simple text answer in survey|
      |Text Input|Long Text Input Question Added through Automation for Submit?|Ratnakar adding Long text answer in survey through automation so the we can check the its working properly or not |
      |Dropdown|Dropdown Question Added through Automation for Submit?|DropdownChoice_3|
      |Scale Question|Scale Question Added through Automation for Submit?|5|
      |Single Choice|Net Promoter Score Question Added through Automation for Submit?|10|
    And User click on the "Submit" button and confirm "BACK TO ALL SURVEYS" to create Survey.


