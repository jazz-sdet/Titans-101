Feature: Whole Foods checkout tests

  Scenario: Successful checkout
    When user navigates at checkout cart
    And user uses credit/debit card as a payment method
    Then user checks out successfully

