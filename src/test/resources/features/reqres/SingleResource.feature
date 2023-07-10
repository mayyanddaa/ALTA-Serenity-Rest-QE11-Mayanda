@Tugas
Feature: Get single resources
  Test case for get single resources

  Scenario Outline: Get single resources with valid id
    Given Get single resources with valid parameter <id>
    When User send request get single resource
    Then Status code should be 200 OK
    And Response body id should be <id>
    And Validate get single resource schema
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |
