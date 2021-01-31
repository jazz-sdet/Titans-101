Feature: Slack message
  @messageOnSlack
  Scenario: sent message validation
    Given user verifies the message is not in the channel
    When user posts a message in a slack
    Then user verifies if the message was sent
