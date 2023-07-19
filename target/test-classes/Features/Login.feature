@Smoke
Feature: verify user able to login and logout in application

  @Login
  Scenario: validate login functionality
    Given User is on Cataloge page
    When user clicks on Menu button
    And user clicks on Log In button
    And user enters username and password
    And user clicks on Login button
    Then User is on Cataloge page

  @Login
  Scenario: validate logout functionality
    Given User is on Cataloge page
    When user clicks on Menu button
    And user clicks on Log Out button
    And user clicks on Logout popup
    Then User is on login page