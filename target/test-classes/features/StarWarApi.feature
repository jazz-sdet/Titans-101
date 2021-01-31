Feature: Test star war api
  Scenario: get unique titles
    When user executes the "GET" request
    Then titles are unique