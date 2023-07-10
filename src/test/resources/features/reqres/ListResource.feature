@Tugas
Feature: List Resource
  Test case for get list resource

  Scenario: Get list resource
    Given Get list resource
    When User send request get list resource
    Then Status code should be 200 OK
    And Validate get list resource schema