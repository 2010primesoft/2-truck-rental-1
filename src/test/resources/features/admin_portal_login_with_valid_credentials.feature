Feature: Admin portal login with valid credentials

  Scenario: Admin portal login with valid credentials
    Given Open the login page
    When Enter admin email and password
    When Click the login button
    Then Authentication request is submitted with webapp source, access token is saved in local storage, user profile is fetched and verified as ADMIN, and user is redirected to the admin dashboard
