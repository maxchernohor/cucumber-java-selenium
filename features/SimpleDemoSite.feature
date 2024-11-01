Feature: Simple Demo Site

  @P1
  Scenario: Navigate to Catalog Page
    Given I am on the Simple Demo Home Page
    When I click on Catalog Button
    Then I navigated to Catalog Page

  @P1
  Scenario: Scroll to bottom and click on white sandals
    Given I am on the Simple Demo Home Page
    When I click on Catalog Button
    Then I navigated to Catalog Page
    Given I scroll to the bottom
    When I click on white sandals
    Then I navigated to white sandals page

  @P2 @setCookies
  Scenario: Add white sandals to cart and validate cart count
    Given I am on the Simple Demo Home Page
    When I click on Catalog Button
    Then I navigated to Catalog Page
    Given I scroll to the bottom
    When I click on white sandals
    Then I navigated to white sandals page
    When I click on add to cart sandals
    Then the cart count should increase by one