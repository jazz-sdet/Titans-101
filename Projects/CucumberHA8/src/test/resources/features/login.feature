Feature: Login

  Background:
      Given user is on "https://demo.espocrm.com/?" web page

    @login
    Scenario: Home page functions
      When user clicks login button
      And user clicks on burger button
      Then user should see all the function names