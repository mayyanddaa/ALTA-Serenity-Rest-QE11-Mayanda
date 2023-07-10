@Tugas
Feature: Delete existing user
  Test case is for delete user

  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When User send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |
      | 2  |