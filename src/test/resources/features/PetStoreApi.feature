Feature: Test Pet store apis
@get
  Scenario: Get pet by id
    When user executes "GET" request
    Then status code is 200
    And pet has following attributes
      | petName | petID | petStatus |
      | Pizza   | 1015  | available  |
