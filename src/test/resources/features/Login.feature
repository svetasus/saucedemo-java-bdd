@Login
Feature: User Authentication

  Scenario Outline: Verify login behavior with various credentials
    Given the user is on the login page
    When the user logs in with username "<username>" and password "<password>"
    Then the outcome should be "<outcome>"

    Examples:
      | username        | password       | outcome                                             |
      | standard_user   | secret_sauce   | success                                                     |
      | locked_out_user | secret_sauce   | Epic sadface: Sorry, this user has been locked out.         |
      | wrong_user      | secret_sauce   | Epic sadface: Username and password do not match any user   |
      | standard_user   | wrong_password | Epic sadface: Username and password do not match any user   |
