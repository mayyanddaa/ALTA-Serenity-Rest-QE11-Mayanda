@Tugas
  Feature: List Users
    Test case for get list users

  Scenario Outline: Get list users with valid parameter page
    Given Get list user with valid parameter page <page>
    When User send request get list users
    Then  Status code should be 200 OK
    And Response value body page should be <page>
    And Validate get list user JSON schema
    Examples:
      | page |
      | 1    |
      | 2    |
