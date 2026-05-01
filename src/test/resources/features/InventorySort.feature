@Inventory
Feature: Inventory Sorting on SauceDemo

  Background:
    Given the user is on the login page
    And the user logs in with username "standard_user" and password "secret_sauce"

  Scenario: User can sort product by price from low to high
    When the user selects "Price (low to high)" from the sort dropdown menu
    Then the first item displayed should cost "$7.99"
