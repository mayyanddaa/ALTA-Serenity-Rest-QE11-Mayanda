@Tugas
  Feature: Register feature
    Test case for register user account

  Scenario: Post new register user with valid json file
    Given Create new register user with valid json
    When User send request post register user
    Then Status code should be 200 OK
    And Response body should be 4 as id and "QpwL5tke4Pnpja7X4" as token
    And Validate register json schema

  Scenario: Post new register user with invalid json file
    Given Create new register with invalid json
    When User send request post register user
    Then Status code should be 400 Bad Request
    And Response body should be "Missing password" as error message
    And Validate unsuccesful register schema