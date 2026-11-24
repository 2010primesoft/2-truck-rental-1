Feature: Admin Authentication and Session Management — module Authentication

  Scenario: Admin portal login with valid credentials
    Given I open the login page
    When I enter email "admin@example.com" and password "ValidPass123!"
    And I click the login button
    Then I should be redirected to the admin dashboard with admin profile loaded

  Scenario: Block owner role from admin portal login
    Given I open the login page
    When I enter email "owner@example.com" and password "ValidPass123!"
    And I click the login button
    Then I should see an error message stating non-admin accounts cannot access the admin portal

  Scenario: Login form rejects invalid email format
    Given I open the login page
    When I enter email "invalidemail" and password "ValidPass123!"
    And I submit the login form
    Then I should see a validation error on the email field and submission is prevented

  Scenario: Redirect authenticated owner user visiting guest route
    Given I am logged in as an authenticated owner user
    When I navigate to a guest route
    Then I should be redirected to the my trucks page

  Scenario: Session clearance on 401 unauthenticated response
    Given I am logged in as an admin user
    When an API request returns a 401 unauthenticated response
    Then the session tokens should be cleared and I am redirected to the admin login page with a session expired toast

  Scenario: Admin logout clean-up execution
    Given I am logged in as an admin user on the dashboard
    When I open the user profile menu
    And I click the logout button
    Then I should be logged out, redirected to the login page, and see a success toast
