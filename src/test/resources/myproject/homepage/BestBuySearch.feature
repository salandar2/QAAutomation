Feature: Search for iPhone 13 on BestBuy

  Scenario: Search for iPhone 13 and add to cart
    Given I open the BestBuy website
    When I search for "iPhone 13"
    Then I should see search results for "iPhone 13"
    And I add the first iPhone 13 to the cart
    And I click on the cart
    And I verify the order summary in the cart

  Scenario: Add the second iphone 13 item and add to cart
    Given I open the BestBuy website
    When I search for "iPhone 13"
    Then I should see search results for "iPhone 13"
    And I click on the 2nd item in the search results
    And I click on the cart
    And I verify the order summary in the cart

  Scenario: Add the second iphone 13 item and add to cart
    Given I open the BestBuy website
    When I search for "iPhone 13"
    Then I should see search results for "iPhone 13"
    And I click on the 3rd item in the search results
    And I click on the cart
    And I verify the order summary in the cart
