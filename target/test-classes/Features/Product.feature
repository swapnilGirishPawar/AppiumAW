Feature: verify user able to add and remove product in cart in application

  @Smoke
  @Product
  Scenario: validate add to cart functionality
    Given User is on Cataloge page
    When User navigates to the product
    And user clicks on the product
    And user add 2 quantity of product
    And user clicks on add to cart button
    Then Product with 2 quantity visible in cart page.

  @Product
  Scenario: validate add to remove functionality
    Given User is on Cataloge page
    When User navigates to cart page
    And user clicks on the remove items button
    Then cart page become empty.