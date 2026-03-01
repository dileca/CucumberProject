Feature: Update User to Admin

  Background:
    Given I am on the login page

  Scenario Outline: Approve a user
    When I enter valid username <username>
    And I enter valid password <password>
    And I click the login button
    Then I should be redirected to the dashboard for <User>
    And I select Admin Panel from the Admin dropdown
    And I select Approvals from the Admin Panel
    And I search for the User via email <email>
    And I approve the user
    Then I should receive a Success message

    Examples:
      | username       | password  | User | email
      | soap@gmail.com | soap@1234 | Joe  | email@gmail.com