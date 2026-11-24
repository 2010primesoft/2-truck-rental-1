Feature: Vehicle Owner Management — module Owner Management

  Scenario: Direct vehicle owner registration by admin
    Given I am on the owner registration page
    When I enter owner name "John Doe"
    And I enter phone number "1234567890"
    And I enter email "johndoe@example.com"
    And I select US state "CA" from dropdown
    And I enter a valid password
    And I upload a valid government ID document
    And I submit the owner registration form
    Then the owner should be successfully registered with role OWNER

  Scenario: Owner KYC image upload exceeding maximum size limit
    Given I am on the owner registration page
    When I fill all mandatory owner text fields
    And I select an image file exceeding the 5 MB limit
    And I attempt to submit the owner registration form
    Then I should see a file upload validation error and submission is prevented

  Scenario: Debounced owner list search by full name
    Given I am on the owner list page
    When I type "John Doe" into the search bar
    And I wait 400 milliseconds
    Then the owner list search request is executed with pagination reset to page 0

  Scenario: Approve pending vehicle owner KYC application
    Given I am on the owner list page with a pending owner application
    When I click the approve owner application button
    And I confirm the action in the confirmation modal
    Then the owner status should be updated to ACTIVE and KYC verified

  Scenario: Reject pending vehicle owner application with reason
    Given I am on the owner list page with a pending owner application
    When I click the reject owner application button
    And I enter rejection reason "Invalid identification documents"
    And I confirm the rejection in the modal
    Then the owner application should be rejected

  Scenario: Deactivate and reactivate active vehicle owner
    Given I am on the owner list page with an active owner
    When I click the deactivate owner button and confirm the modal
    Then the owner account should be deactivated
    When I click the reactivate owner button
    Then the owner account should be reactivated immediately
