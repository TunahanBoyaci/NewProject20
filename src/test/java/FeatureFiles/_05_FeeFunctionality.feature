Feature: Fee Functionality

  Background: Login
    Given Navigate to Campus
    And Enter username and password
    And Click on login Button
    And Navigate to Fees page

  Scenario: Create a Fee
    And Click on add Button
    And Fill the add fee form
      | Alan Millan |
      | M803         |
      | 23kio        |
      | 946          |
    When Click on save and new button
    Then Success message should be displayed

  Scenario: Delete a Fee
    And Search for "M803" as code
    When Click on Delete and Confirm
    Then Success message should be displayed
