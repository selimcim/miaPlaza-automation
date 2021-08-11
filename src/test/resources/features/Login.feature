
Feature: Login With Different Scenarios

  Scenario: Login with valid credentials
    Given the user logged in enters "username" and "password"
    Then the user should see the title "Zero - Account Summary"


  Scenario Outline: Login with invalid credentials
    Given the user logged in enters "<username>" and "<password>"
    Then the user should see the message "Login and/or password are wrong."
    And the user should see the title "Zero - Log in"

    Examples:
      |username|password|
      |  1234  |password|
      |  1234  | 1234   |
      |username|1234    |
      |username| |
      | |password|
      | | |