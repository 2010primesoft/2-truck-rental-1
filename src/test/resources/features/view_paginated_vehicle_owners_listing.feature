Feature: View paginated vehicle owners listing

  Scenario: View paginated vehicle owners listing
    Given I navigate to vehicle owners page
    Then paginated owner list displays client-generated IDs, name, phone, vehicle count, registration date, status badge, and Stripe status
