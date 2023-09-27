Feature: Citizenship Functionality

  Background: Login
    Given Navigate to Campus
    And Enter username and password
    And Click on login Button
    And Navigate to Citizenship page

  @Regression
  Scenario Outline: Create a new Citizenship
    And Click on add Button
    Then Enter "<CitizenshipName>" as citizenship name and "<CitizenshipShortName>" as short name
    When Click on save button
    Then Success message should be displayed
    Examples: Data for Citizenship scenario
      | CitizenshipName | CitizenshipShortName |
      | 112s1           | 1d34v                |
      | s1s2ew          | 43v5y                |
      | 23g78j          | 3v45                 |

  @Regression
  Scenario Outline: Delete a Citizenship
    And Search for "<CitizenshipName>" as citizenship name and "<CitizenshipShortName>" as short name
    When Click on Delete and Confirm
    Then Success message should be displayed
    Examples: Data for Delete Citizenship scenario
      | CitizenshipName | CitizenshipShortName |
      | 112s1           | 1d34v                |
      | s1s2ew          | 43v5y                |
      | 23g78j          | 3v45                 |