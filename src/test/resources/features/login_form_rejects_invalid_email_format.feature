Feature: Login form rejects invalid email format

  Scenario: Login form rejects invalid email format
    Given the user is on the login page
    When the user enters malformed email address without domain dot
    And the user enters password
    And the user submits login form
    Then validation error is displayed on email field and submission is prevented
