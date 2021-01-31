@etsy
Feature: Etsy search
  Scenario: correct price verification
    Given user is on etsy home page
    When user searches for "unique jewelry"
    Then the result page has total price more than 0