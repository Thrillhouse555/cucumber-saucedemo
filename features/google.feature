Feature: Google Search Page

  Scenario: Open Google homepage and check title
    Given I open the Google homepage
    Then the page title should be "Google"
