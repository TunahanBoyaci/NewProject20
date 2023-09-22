Feature: Database Testing for States Function

  Background: Background for Database Testing for States Function
    Given Navigate to Campus
    When Enter username and password
    And Click on login Button

  Scenario: Scenario for Database Testing for States Function
    Given Navigate to States page
    When Send the query "select name from states"
    Then Check if they match with the names on the UI
