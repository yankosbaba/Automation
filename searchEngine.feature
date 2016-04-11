Feature: Springer Link Search Engine

  Scenario: 
    As a user I want to be able to search books

    Given that I am on Springer Link search page
    When I enter books name
    Then I should see books results
    Given that I am on Springer Link search page
    When I enter wrong books name
    Then I should see an error message
