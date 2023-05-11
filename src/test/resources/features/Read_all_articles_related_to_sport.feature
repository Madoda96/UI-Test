Feature: As a sports user, I would like to read about all articles related to sports
  Scenario: Use the search option to find all articles related to ‘sports’. Output the first heading and the last heading returned on the page.
    Given user is on the website.
    When user clicks on the Sport option.
    Then user should see all articles that are related to sports.
