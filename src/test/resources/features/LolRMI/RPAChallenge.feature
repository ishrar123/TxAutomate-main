Feature: RPA Challenge Feature
#  @LolRMI
#  Scenario Outline: <TestCaseID>_Verify LOL RMI Login feature with Invalid credentials
#    Given Read "TestData11" and "<SheetName>" and "<TestCaseID>" from test data
#    When Navigate to the "LolRMI" app url
#    And Open Login page button
#    And Input Username and Password for LolRMI
#    And Click LolRMI Login Button
#    Then Verify "InValid" login Of User to LolRMI
#
#    Examples:
#      | TestCaseID               | SheetName |
#      | QA_TestCase_Auto_RMI_1_1 | RMILogin  |

@RPAC
Scenario Outline: <TestCaseID>_Verify LOL RMI Login feature with Valid credentials
Given Read "TestData1" and "<SheetName>" and "<TestCaseID>" from test data
When Navigate to the "PRAChallenge" app url
And Input Userdetails for RPAChallenge
And Click On Submit Button

Examples:
| TestCaseID | SheetName |
#      | QA_TestCase_Auto_RMI_1_2 | RMILogin  |
#| 174752     | RMILogin  |
| 1   |RPAChallenge|