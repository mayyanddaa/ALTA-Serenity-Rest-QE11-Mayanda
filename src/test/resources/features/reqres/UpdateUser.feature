@Tugas
  Feature: Update user
    Test case for put update user data

    Scenario Outline: Put existing user with valid parameter id and json file
      Given Put update user with valid id <id> and json
      When User send request update user
      Then Status code should be 200 OK
      And Response body name should be "Mayanda" and job is "QA Engineer"
      And Validate put update user schema
      Examples:
        | id |
        | 1 |
        | 2 |
        | 3 |
