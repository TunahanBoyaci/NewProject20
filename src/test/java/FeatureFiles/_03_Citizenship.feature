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
      | j4g3h2          | 9iu0                 |
      | 3h5v5j4         | 8u8j                 |
      | 4h3gg5          | 68jk                 |

  @Regression
  Scenario Outline: Delete a Citizenship
    And Search for "<CitizenshipName>" as citizenship name and "<CitizenshipShortName>" as short name
    When Click on Delete and Confirm
    Then Success message should be displayed
    Examples: Data for Delete Citizenship scenario
      | CitizenshipName | CitizenshipShortName |
      | j4g3h2          | 9iu0                 |
      | 3h5v5j4         | 8u8j                 |
      | 4h3gg5          | 68jk                 |
