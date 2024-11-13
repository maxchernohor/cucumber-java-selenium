#Feature: Simple Demo Site
#
#  @P3
#  Scenario: Sign up and validate login
#    Given I am on the Simple Demo Home Page
#    When I click on Sign Up Button
#    Then I fill out the sign up form with First Name, Last Name, Email Address, and Password
#    When I click on Create Account
#    Then I see login successful
#
#  @P3
#  Scenario: Customer login and validate
#    Given I am on the Simple Demo Home Page
#    When I click on Customer Login Button
#    Then I fill out the login form with Email Address and Password
#    When I click on Sign In
#    Then I validate that user signed in
#
#  @P1
#  Scenario: Navigate to Catalog Page
#    Given I am on the Simple Demo Home Page
#    When I click on Catalog Button
#    Then I navigated to Catalog Page
#
#  @P2 @setCookies
#  Scenario: Add white sandals to cart and validate cart count
#    Given I am on the Simple Demo Home Page
#    When I click on Catalog Button
#    Then I navigated to Catalog Page
#    Given I scroll to the bottom
#    When I click on white sandals
#    Then I navigated to white sandals page
#    Then I click on Add to cart and cart count should increase by one
#
#  @P2
#  Scenario Outline: Navigate to Catalog Page and click on item
#    Given I am on the Simple Demo Home Page
#    When I click on Catalog Button
#    Then I navigated to Catalog Page
#    Given I scroll to the bottom
#    Then I click on "<item>"
#    Examples:
#      | item         |
#      | White sandals|
#      | Grey jacket  |
#      | Noir jacket  |
#
#  @P3
#  Scenario: Validate price on item page
#    Given I am on the Simple Demo Home Page
#    When I click on Catalog Button
#    Then I navigated to Catalog Page
#    Given I scroll to the bottom
#    When I click on white sandals
#    Then I navigated to white sandals page
#    Then I validate the price on the item page
#
#  @P3
#  Scenario: Validate price after adding to cart
#    Given I am on the Simple Demo Home Page
#    When I click on Catalog Button
#    Then I navigated to Catalog Page
#    Given I scroll to the bottom
#    When I click on white sandals
#    Then I navigated to white sandals page
#    When I click on Add to cart
#    Then I validate the price in the cart is the same as on the item page
#
#  @P3
#  Scenario: Add two items and validate total price
#    Given I am on the Simple Demo Home Page
#    When I click on Catalog Button
#    Then I navigated to Catalog Page
#    Given I scroll to the bottom
#    When I click on white sandals
#    Then I navigated to white sandals page
#    When I click on Add to cart
#    Then I navigate back to Catalog Page
#    When I click on grey jacket
#    Then I navigated to grey jacket page
#    When I click on Add to cart
#    Then I validate the total price in the cart is the sum of the prices of both items
#
#  @P3
#  Scenario: Remove all items from cart and check that the cart is empty
#    Given I am on the Simple Demo Home Page
#    When I click on Catalog Button
#    Then I navigated to Catalog Page
#    Given I scroll to the bottom
#    When I click on white sandals
#    Then I navigated to white sandals page
#    When I click on Add to cart
#    Then I navigate back to Catalog Page
#    When I click on grey jacket
#    Then I navigated to grey jacket page
#    When I click on Add to cart
#    Then I remove all items from the cart
#    Then I validate that the cart is empty
#
#  @P3
#  Scenario: Validate Blog page and first post
#    Given I am on the Simple Demo Home Page
#    When I click on Blog Button
#    Then I navigated to Blog Page
#    Then I validate that the first post is present and the date is correct
#
#  @P3
#  Scenario: Validate About Us page
#    Given I am on the Simple Demo Home Page
#    When I click on About Us Button
#    Then I navigated to About Us Page
#    Then I validate that About Us is present

Feature: Simple Demo Site

  @P1
  Scenario: Navigate to Catalog Page
    Given I am on the Simple Demo Home Page
    When I click on Catalog Button
    Then I navigated to Catalog Page

  @P2 @setCookies
  Scenario: Add white sandals to cart and validate cart count
    Given I am on the Simple Demo Home Page
    When I click on Catalog Button
    Then I navigated to Catalog Page
    Given I scroll to the bottom
    When I click on white sandals
    Then I navigated to white sandals page
    Then I click on Add to cart and cart count should increase by one

  @P2
  Scenario Outline: Navigate to Catalog Page and click on item
    Given I am on the Simple Demo Home Page
    When I click on Catalog Button
    Then I navigated to Catalog Page
    Given I scroll to the bottom
    Then I click on "<item>"
    Examples:
      | item         |
      | White sandals|
      | Grey jacket  |
      | Noir jacket  |