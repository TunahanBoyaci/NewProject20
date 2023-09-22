Feature: Data Table Example

  Scenario: Form filling
    Given Go to the webpage
    And Fill the form with valid data
    |Johnw           |
    |Snow1           |
    |2345 Sum St.|
    |2645456571     |
    Then Save the form

  Scenario: Form filling second
    Given Go to the webpage
    And Fill the form with valid data
    |Johny           |
    |Snow1           |
    |2345 Winter St.4|
    |26454565784     |
    Then Enter valid Information
      |Nameq       |Johnq           |
      |Last Nameq  |Snowq           |
      |Addressq    |2345 qWinter St.|
      |Phoneq      |2645456571     |
    Then Save the form