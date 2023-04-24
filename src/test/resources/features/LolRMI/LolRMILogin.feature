Feature: Test LolRMI Login Feature

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

  @LolRMI1
  Scenario Outline: <TestCaseID>_Verify LOL RMI Login feature with Valid credentials
    Given Read "TestData1" and "<SheetName>" and "<TestCaseID>" from test data
    When Navigate to the "LolRMI" app url
    And Open Login page button
    And Input Username and Password for LolRMI
    And Click LolRMI Login Button
    Then Verify "Valid" login Of User to LolRMI

    Examples:
      | TestCaseID | SheetName |
#      | QA_TestCase_Auto_RMI_1_2 | RMILogin  |
      | 174752     | RMILogin  |

  @LolRMI
  Scenario Outline: <TestCaseID>_Verify Searching for Producer by "<Criteria>"
    Given Read "TestData1" and "<SheetName>" and "<TestCaseID>" from test data
    When Navigate to the "LolRMI" app url
    And Open Login page button
    And Input Username and Password for LolRMI
    And Click LolRMI Login Button
    Then Verify "Valid" login Of User to LolRMI
    And Search For Producers By "<Criteria>"
    Then Verify Result in The Tile List

    Examples:
      | TestCaseID               | SheetName | Criteria |
#      | QA_TestCase_Auto_RMI_1_3 | RMILogin  | Producer |
      | 174753                   | RMILogin  | Producer |
#      | QA_TestCase_Auto_RMI_1_4 | RMILogin  | Farm ID |
#      | QA_TestCase_Auto_RMI_1_5 | RMILogin  | Milk Shed |

  @LolRMI
  Scenario Outline: <TestCaseID>_Verify Searching for Producer and Edit COP and Verify in Summary Report section
    Given Read "TestData1" and "<SheetName>" and "<TestCaseID>" from test data
    When Navigate to the "LolRMI" app url
    And Open Login page button
    And Input Username and Password for LolRMI
    And Click LolRMI Login Button
    Then Verify "Valid" login Of User to LolRMI
    And Search For Producers By "<Criteria>"
    And Click on Tile to Open Yearly Tiles List
    And Click on Edit COP in Yearly Tile
    And Edit Field Details in COP
    And Click on Save Button to Save Details
    Then Verify Success Message on Saving Data
    And Click on Edit COP in Yearly Tile
    And click on Summary Report to Check Saved Data
    Then Verify Details on Summary Report Tab

    Examples:
      | TestCaseID | SheetName | Criteria |
#      | QA_TestCase_Auto_RMI_1_6 | RMILogin  | Producer |
      | 174754     | RMILogin  | Producer |

  @LolRMI
  Scenario Outline: <TestCaseID>_Verify Searching for Producer and Edit Income in COP and Verify in Summary Report section
    Given Read "TestData1" and "<SheetName>" and "<TestCaseID>" from test data
    When Navigate to the "LolRMI" app url
    And Open Login page button
    And Input Username and Password for LolRMI
    And Click LolRMI Login Button
    Then Verify "Valid" login Of User to LolRMI
    And Search For Producers By "<Criteria>"
    And Click on Tile to Open Yearly Tiles List
    And Click on Edit COP in Yearly Tile
    And Edit Total Income Fields Detail in COP
    Then Verify Total Milk And Income Details on Form
    And Click on Save Button to Save Details
    Then Verify Success Message on Saving Data
    And Click on Edit COP in Yearly Tile
    And click on Summary Report to Check Saved Data
    Then Verify Total Income Details on Summary Report Tab

    Examples:
      | TestCaseID | SheetName | Criteria |
#      | QA_TestCase_Auto_RMI_1_7 | RMILogin  | Producer |
      | 174755     | RMILogin  | Producer |

  @LolRMI
  Scenario Outline: <TestCaseID>_Verify Searching for Producer and Edit COP and Verify in Summary Report section
    Given Read "TestData1" and "<SheetName>" and "<TestCaseID>" from test data
    When Navigate to the "LolRMI" app url
    And Open Login page button
    And Input Username and Password for LolRMI
    And Click LolRMI Login Button
    Then Verify "Valid" login Of User to LolRMI
    And Search For Producers By "<Criteria>"
    And Click on Tile to Open Yearly Tiles List
    And Click on Edit COP in Yearly Tile
    And Edit Field Details in COP
    And Edit Total Income Fields Detail in COP
    Then Verify Total Milk And Income Details on Form
    And Click on Save Button to Save Details
    Then Verify Success Message on Saving Data
    And Click on Edit COP in Yearly Tile
    And click on Summary Report to Check Saved Data
    Then Verify Details on Summary Report Tab
    Then Verify Total Income Details on Summary Report Tab

    Examples:
      | TestCaseID | SheetName | Criteria |
#      | QA_TestCase_Auto_RMI_1_6 | RMILogin  | Producer |
      | 176255     | RMILogin  | Producer |

  @LolRMI
  Scenario: 178465_Verify LOL RMI Login feature with Valid credentials
    Given This test has been failed
