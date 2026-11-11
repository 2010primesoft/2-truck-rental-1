Feature: Search owner list with debounce and persist filter parameters

  Scenario: Search owner list with debounce and persist filter parameters
    Given I am on the vehicle owners page
    When I type search term into owner search bar
    And I wait for debounce period to complete
    Then list triggers API call after 400ms delay, resets pagination to first page, and search parameters remain persisted upon returning
