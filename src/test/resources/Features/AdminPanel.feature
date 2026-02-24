Feature: Update User to Admin

  Scenario Outline: Update a user to admin role
    Given I log in as an admin
    And I select Admin Panel from the Admin dropdown
    And I find my User via the Search
    And I update the user role to Admin
    Then I should receive a pop up message confirming the update request
    And I should receive a Success message
    And I should see the user role updated to Admin

    Examples:
      | email         | password  |
      | admin@gmail.com | @12345678 |