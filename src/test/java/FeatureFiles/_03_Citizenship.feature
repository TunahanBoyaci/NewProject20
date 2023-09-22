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
    |CitizenshipName|CitizenshipShortName|
    |11s12          |1d1w12                  |
    |Mae12w          |435g                  |
    |23rfsd         |3g43                  |

    @Regression
    Scenario Outline: Delete a Citizenship
      And Search for "<CitizenshipName>" as citizenship name and "<CitizenshipShortName>" as short name
      When Delete citizenship
      Then Success message should be displayed
      Examples: Data for Delete Citizenship scenario
        |CitizenshipName|CitizenshipShortName|
        |11s12          |1d1w12                  |
        |Mae12w          |435g                  |
        |23rfsd         |3g43                  |