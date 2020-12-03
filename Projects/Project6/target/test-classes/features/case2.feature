Feature: Adding new employee

  Scenario: Login as admin
    Given user was logged in as admin
    When admin clicks on add button and selects his/her role
    And admin selects employee name, enters username and selects status
    And admin enters password, confirms and saves
    Then admin validates Successfully Saved message
