Feature: Admin Portal Authentication

  Scenario: Admin portal login with valid credentials
    Given I am on the login page
    When I enter email "admin@example.com" and password "ValidPassword123!"
    And I click the login button
    Then I should be redirected to the admin dashboard

  Scenario: Login form rejects invalid email format
    Given I am on the login page
    When I enter email "admin@invaliddomain" and password "AnyPassword123!"
    And I click the login button
    Then a validation error should be displayed on the email field
    And the form submission should be prevented
