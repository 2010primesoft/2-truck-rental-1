Feature: Admin Authentication

  Scenario: Admin portal login with valid credentials
    Given I open the login page
    When I enter email "admin@example.com" and password "password123"
    And I click the login button
    Then I should be redirected to the admin dashboard

  Scenario: Login form rejects invalid email format
    Given I open the login page
    When I enter email "admin@invalid"
    And I click the login button
    Then a validation error should be displayed on the email field
