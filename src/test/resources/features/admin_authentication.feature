Feature: Admin Authentication

  Scenario: Admin portal login with valid credentials
    Given I navigate to the login page
    When I enter email "admin@example.com" and password "adminPassword123"
    And I click the login button
    Then I should be redirected to the admin dashboard

  Scenario: Login form rejects invalid email format
    Given I navigate to the login page
    When I enter email "invalidemail@domain" and password "validPassword123"
    And I click the login button
    Then a validation error should be displayed on the email field
