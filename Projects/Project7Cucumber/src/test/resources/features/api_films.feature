Feature:API status code testing
  @starWarFilms
  Scenario: star war films positive testing for get method
    When user creates get request by using path
    Then user gets the status code 200

    @StarNegative
    Scenario: Star wars films negative testing for get request
      When user will creates get request by using invalid path
      Then user will get status code 404

      @starwarPeople
      Scenario: Positive test to get star war people
        When user creates get request by using path people
        Then user gets the status code 200

  @starwarPeople1
  Scenario: Positive test to get star war people
    When user creates get request by using path people1
    Then user gets the status code 200

  @starwarVehicle
  Scenario: Positive test to get star war people
    When user creates get request by using path vehicle
    Then user gets the status code 200


