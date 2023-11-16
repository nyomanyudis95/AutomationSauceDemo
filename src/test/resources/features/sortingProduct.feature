Feature: Sorting Product
  Background: User already login and in HomePage
    Given User is already login

    Scenario: User can sorting product by ascending based on product name in Home Screen
      When user select sorting type to Name(A to Z)
      Then all item display in Home Page is sort ascending base on productName

    Scenario: User can sorting product by descending based on product name in Home Screen
      When user select sorting type to Name(Z to A)
      Then all item display in Home Page is sort descending base on productName

    Scenario: User can sorting product by ascending based on product price in Home Screen
      When user select sorting type to Price(low to high)
      Then all item display in Home Page is sort ascending base on productPrice

    Scenario: User can sorting product by descending based on product price in Home Screen
      When user select sorting type to Price(high to low)
      Then all item display in Home Page is sort descending base on productPrice

