Feature: Search feature
  @xyz4
  Scenario: User can perform a search failure
    Given User is on the search page
    And I navigate to Bus tab and verify details
    And I enter "Bengaluru" to "Panjim" as destinations


  Scenario: User can perform a search
    Given User is on the search page
    And I navigate to Bus tab and verify details
    And I enter "Bengaluru" to "Goa" as destinations pass
    And I select "Majestic" "Mapsa" as pick up and drop off points
    And I enter "Sam" "Jack" as first and last name
