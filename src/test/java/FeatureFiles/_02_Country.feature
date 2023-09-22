Feature: Country Functionality.
  As a user, I want to be able to create and update countries
  so that I can update the country list

  Background: Login
    Given Navigate to Campus
    And Enter username and password
    And Click on login Button
    And Navigate to Country page

  Scenario: Create a new country
    When Create a new country
    Then Success message should be displayed


#  Scenario: Delete a new country

    Scenario: Create a new country, fill the form
      And Click on add Button
      And Enter "2e2jqw" as country name and "x301" as country code
      When Click on save button
      Then Success message should be displayed


#    Scenario: Delete a new country, fill the form

