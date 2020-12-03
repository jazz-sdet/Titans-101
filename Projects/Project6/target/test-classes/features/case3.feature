Feature: user validation and status update
  Scenario: added user's criteria
    Given user is logged in admin page
    When user searches for an existing user
    Then user validates the username, user role, name and status

    Scenario: status change
      Given user is on result page
      When user clicks on username
      And user clicks on edit button
      Then user validates "Successfully Updated" message

      Scenario: search with username
        Given user on successfully updated message page
        When user searches with username
        Then user validates if the status is updated

