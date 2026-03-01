Feature: User login test

  Background:
    Given I am on the login page

  Scenario Outline: Successful login with valid credentials

    When I enter valid username <username>
    And I enter valid password <password>
    And I click the login button
    Then I should be redirected to the dashboard for <User>

    Examples:
      | username        | password  | User  |
      | 1@gmail.com     | @12345678 | test  |
 #     | admin@gmail.com | @12345678 | admin |