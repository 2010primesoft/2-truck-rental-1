Feature: Admin portal login with valid credentials

  Scenario: Admin portal login with valid credentials
    Given the user is on the login page
    When the user enters the admin email and password
    And the user clicks the login button
    Then the user is redirected to the admin dashboard
