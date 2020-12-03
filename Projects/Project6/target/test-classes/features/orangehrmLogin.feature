Feature: orangehrm login test

  Scenario: Successful login
    When user navigates to opensource-demo.orangehrmlive.com
    And  user uses "Admin" and "admin123" to log in
    Then user logs in


    Scenario: Admin checkbox validation
      Given user is logged in to opensource-demo.orangehrmlive.com
      When user clicks Admin function
      And user click first checkbox next to username
      Then all checkboxes are selected

      Scenario: Username descending order Validation
        Given user is logged in as admin
        When user clicks username twice
        Then usernames are in descending order






