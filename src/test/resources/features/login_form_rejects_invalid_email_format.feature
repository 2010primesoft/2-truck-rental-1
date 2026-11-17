Feature: Login form rejects invalid email format

  Scenario: Login form rejects invalid email format
    Given the user is on the login page to submit credentials
    When the user enters a malformed email address without domain dot
    And the user enters a password in the password field
    And the user submits the login form
    Then submission is prevented and user remains on the login page
