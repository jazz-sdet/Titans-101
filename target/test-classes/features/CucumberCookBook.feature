Feature: search for cucumber cook book

  Scenario: search result validation on google
    When user navigates to "https://www.google.com/"
    And user looks for cucumber cook book
    Then user validates for two result pages