@Smoke
Feature: validate Cataloge page

  @Navigation
  Scenario: Verify user able to navigate to the cart page
    Given User is on Cataloge page
    When user clicks on Cart button
    Then user lands on cart page