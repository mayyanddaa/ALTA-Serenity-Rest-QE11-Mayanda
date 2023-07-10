@Tugas
  Feature: Login feature
    Test case for login user

  Scenario: Post login user with valid json file
    Given Login with existing user with valid json
    When User send request post login user
    Then Status code should be 200 OK
    And Response body should be "QpwL5tke4Pnpja7X4" as token
    And Validate login json schema

  Scenario: Post login user with invalid json file
    Given Login with existing user with invalid json
    When User send request post login user
    Then Status code should be 400 Bad Request
    And Response body should be "Missing password" as error message
    And Validate unsuccesful login schema