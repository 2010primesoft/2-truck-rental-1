Feature: Login form rejects invalid email format

  Scenario: Login form rejects invalid email format
    Given Enter malformed email address without domain dot
    When Enter password
    When Submit login form
    Then Validation error is displayed on email field and submission is prevented
