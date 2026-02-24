Feature: Successful Registration

  Scenario Outline: Successful Registration
    Given I am on the Logon Page
    When I click on the Sign Up Here hyperlink
    And enter First Name <firstName>
    And enter Last Name <lastName>
    And enter Email <email>
    And enter Password  <password>
    And confirm Password <confirmPassword>
    And select a group from the Select Your Group dropdown
    And click Create Account button
    Then I should see a success message confirming my registration

    Examples:
      | firstName | lastName | email       | password  | confirmPassword |
      | Test      | Account  | 2@gmail.com | @12345678 | @12345678       |