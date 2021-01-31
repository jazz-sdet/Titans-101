Feature: Techtorial Academy login tests

  Scenario: Happy path/Successful login/sign in
    When user navigates to Techtorial academy home page
    And user uses "admin" as username and "admin123" as password
    Then user is logged in