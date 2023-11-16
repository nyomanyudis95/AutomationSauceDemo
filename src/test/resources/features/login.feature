Feature: Login

  Background:
    Given User is on login page

  Scenario: User can login with valid username and password
    When user input username input text with "standard_user"
    And user input password input text with "secret_sauce"
    And user click button login
    Then user is on homepage

  Scenario: User can't login with empty password
    When user input username input text with "standard_user"
    And user click button login
    Then show alert error password is required

  Scenario: User can't login with empty username
    When user input password input text with "secret_sauce"
    And user click button login
    Then show alert error username is required

  Scenario: User can't login with empty username and password
    And user click button login
    Then show alert error username is required

  Scenario: User can't login with invalid username and password
    When user input username input text with "acedcv"
    And user input password input text with "aedfcaesf"
    And user click button login
    Then show alert error username and password dont match

  Scenario: User can't login with locked username
    When user input username input text with "locked_out_user"
    And user input password input text with "secret_sauce"
    And user click button login
    Then show alert error user has been locked out
