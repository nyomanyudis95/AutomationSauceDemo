Feature: Add And Remove Cart
  Background: User is already login and in HomePage
    Given User is already login

    Scenario: User can add cart 1 item  in HomePage
      When user click add cart in first item
      Then assert button text in Product Detail And Home Page First Item is Remove
      And assert firstItem in Cart Page
      And assert counterTotalCart to one

    Scenario: User can remove 1 item in HomePage
      Given user click add cart in first item
      When user click remove cart in first item
      Then assert button text in Product Detail And Home Page First Item is Add to cart
      And assert no item in Cart Page
      And assert counterTotalCart to zero

    Scenario: User can add cart item in ProductDetail
      When user click item name in first item
      And user click button Add to cart in Product Detail
      Then assert button text in Product Detail And Home Page First Item is Remove
      And assert counterTotalCart to one
      And assert firstItem in Cart Page

    Scenario: User can remove cart item in ProductDetail
      Given user click add cart in first item
      When user click item name in first item
      And user click button Remove to cart in Product Detail
      Then assert button text in Product Detail And Home Page First Item is Add to cart
      And assert counterTotalCart to zero
      And assert no item in Cart Page

