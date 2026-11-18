Feature: Admin Portal Authentication

  Scenario: Admin portal login with valid credentials
    Given I am on the admin login page
    When I enter email "admin@example.com" and password "adminPassword123"
    And I click the login button
    Then I should be redirected to the admin dashboard
    And the user profile should be verified as ADMIN

  Scenario: Login form rejects invalid email format
    Given I am on the admin login page
    When I enter email "invalid_email_no_dot" and password "anyPassword123"
    And I click the login button
    Then a validation error should be displayed on the email field
    And the login submission should be prevented
