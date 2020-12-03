Feature: Find cucumber on google

  Background:
    When user navigates to "https://www.google.com/"

  @google
  Scenario: Validating search results for cucumber on google

    And user is searching for cucumber
    Then user should validate the number of search results to  be more than 100
  @test
  Scenario: Negative search scenario
    When user navigates to "https://www.google.com/" search page
    And user enters "java basics" in search field
    Then the result page will have topics about "python