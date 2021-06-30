Feature: As a Swag Labs page user, I need page loads correctly.

  @chiara
  Scenario: User goes to Swag Labs page.
    Given The user is on nevegador's home.
    When The user enters www.saucedemo.com on search bar.
    Then The user sees SwagLabs login page.

