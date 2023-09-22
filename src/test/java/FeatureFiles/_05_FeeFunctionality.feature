Feature: Fee Functionality
  Background: Login
    Given Navigate to Campus
    And Enter username and password
    And Click on login Button
    And Navigate to Fees page

    Scenario: Create a Fee
      And Click on add Button
      And Fill the add fee form
      |John Sm123|
      |Ja1e        |
      |123dfda    |
      |413        |
      When Click on save button
      Then Success message should be displayed