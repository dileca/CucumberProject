Feature: Update User to Admin

  Background:
    Given I am on the login page

  Scenario Outline: Update a user to admin role
  #  Given I log in as an admin
    When I enter valid username <username>
    And I enter valid password <password>
    And I click the login button
    Then I should be redirected to the dashboard for <User>
    And I select Admin Panel from the Admin dropdown
    And I find my User via the Search
    And I update the user role to Admin
    Then I should receive a pop up message confirming the update request
    And I should receive a Success message
    And I should see the user role updated to Admin

    Examples:
      | username         | password  | User  |
      | admin@gmail.com | @12345678 | admin |