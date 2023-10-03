Feature: Entrance Exams Functionality
  Background: Login
    Given Navigate to Campus
    And Enter username and password
    And Click on login Button
    And Go to Entrance Exams Page

  Scenario Outline: Create an Entrance Exam
    And Click on add Button
    And Fill the Create Exam Form
      |<Exam Name>    |
    And Create a description
      |<Description>  |
    And Create a note
      |<Note>         |
    When Click on save button
    Then Success message should be displayed
    Examples: Data for Create Entrance Exam Scenario
    |Exam Name     |Description         |Note                        |
    |John Exam 1h  |John is selectedh   |Ready for next levelh       |
    |John Exam 2h  |John has passedh    |Getting prepared for nexth  |
    |John Exam 3h  |John is researchingh|Final examh                 |

  Scenario Outline: Delete an Entrance Exam
    And Search for "<Exam Name>"
    When Click on Delete and Confirm
    Then Success message should be displayed
    Examples: Data for Delete Entrance Exam Scenario
    |Exam Name     |
    |John Exam 1h  |
    |John Exam 2h  |
    |John Exam 3h  |
