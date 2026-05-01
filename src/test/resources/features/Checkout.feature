@Checkout
Feature: Checkout Form Validation

  Background:
    Given the user is on the login page
    And the user logs in with username "standard_user" and password "secret_sauce"
    And the user navigates directly to the checkout page

  Scenario: Successful form submission with valid data
    When the user enters first name "John", last name "Doe", and zip "12345"
    Then the user should be taken to the Checkout Overview page

  Scenario Outline: Form validation blocks empty fields
    When the user enters first name "<FirstName>", last name "<LastName>", and zip "<ZipCode>"
    Then the checkout error should be "<ErrorMessage>"

    Examples:
      | FirstName | LastName | ZipCode | ErrorMessage                   |
      | John      |          | 2200    | Error: Last Name is required   |
      |           | Ivanov   | 1       | Error: First Name is required  |
      | John      |    Doe   |         | Error: Postal Code is required |
