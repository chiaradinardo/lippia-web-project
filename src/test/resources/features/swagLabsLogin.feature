Feature: As an Swag Labs user, I need to have an user and password to enter to home page.
Background:
  Given User is on Swag Labs page.

  @chiara
  Scenario: User verify labels are enabled.
    When User sees labels on page.
    Then Labels are enabled to write.

  @chiara
  Scenario Outline: Password is hidden.
    When User enter a password <password>.
    Then Characters entered are hidden with *.
    Examples:
      | password |
      | 1234     |

  @chiara @loginFailed
  Scenario Outline: User can not enter to home page if credentials are not correct.
    When User enter an username <username>.
    And User enter a password <password>.
    And User click on Login button.
    Then Home page is not redirected. A message <message> is shown.
    Examples:
      | username        | password     | message                                                                   |
      |                 |              | Epic sadface: Username is required                                        |
      | user            | 1234         | Epic sadface: Username and password do not match any user in this service |
      | user            |              | Epic sadface: Password is required                                        |
      |                 | 1234         | Epic sadface: Username is required                                        |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |

  @chiara @loginOk
  Scenario: User can enter to home page.
    When User enter an username standard_user.
    And User enter a password secret_sauce.
    And User click on Login button.
    Then Home page is redirected.