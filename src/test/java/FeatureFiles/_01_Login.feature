Feature: Login functionality
  As a user, I am able to log in with valid credentials.

  @Regression
  Scenario: Login with valid username and password
    Given Navigate to Campus
    And Enter username and password
    When Click on login Button
    Then User should be loged in successfully
