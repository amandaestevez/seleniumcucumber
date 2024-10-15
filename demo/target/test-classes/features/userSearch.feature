Feature: Google Search Feature

  Scenario: User enters a query in the search input field
    Given I am on the Google search homepage
    When I enter "weather" in the search input field
    Then the search input field should contain "weather"
