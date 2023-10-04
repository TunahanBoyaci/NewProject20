Feature: Country Functionality
  As a user, I want to be able to create and update countries
  so that I can update the country list

  Background:
    Given Navigate to Campus
    And Enter username and password
    And Click on login Button
    And Navigate to Country page

  @Smoke
  Scenario: Create a new country
    When Create a new country
    Then Success message should be displayed

    @Smoke
  Scenario: Delete a new country
      And Search for a country
      When Click on Delete and Confirm
    Then Success message should be displayed

  @Smoke
  Scenario: Create a new country, fill the form
    And Click on add Button
    And Enter "2e23ir" as country name and "h291" as country code
    When Click on save button
    Then Success message should be displayed

  @Smoke
  Scenario: Delete a new country, fill the form
    And Search for "2e23ir" as country name and "h291" as code
    When Click on Delete and Confirm
    Then Success message should be displayed