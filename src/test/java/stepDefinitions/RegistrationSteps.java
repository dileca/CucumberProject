package stepDefinitions;

import io.cucumber.java.en.*;
import pageObjects.RegistrationPage;
import utils.Base;

public class RegistrationSteps extends Base {

    @Given("I am on the Logon Page")
    public void i_am_on_the_logon_page() {
        registrationPage.clickNavLoginButton();
        registrationPage.verifyLoginPageIsDisplayed();
    }

    @And("I click on the Sign Up Here hyperlink")
    public void i_click_on_the_sign_up_here_hyperlink() {
        registrationPage.clickSignUpHereLink();
        registrationPage.verifyRegistrationPageIsDisplayed();
    }

    @And("enter First Name {}")
    public void enter_first_name(String firstName) {
        registrationPage.enterFirstName(firstName);
    }

    @And("enter Last Name {}")
    public void enter_last_name(String lastName) {
        registrationPage.enterLastName(lastName);
    }

    @And("enter Email {}")
    public void enter_email(String email) {
        registrationPage.enterEmail(email);
    }

    @And("enter Password {}")
    public void enter_password(String password) {
        registrationPage.enterPassword(password);
    }

    @And("confirm Password {}")
    public void confirm_password(String confirmPassword) {
        registrationPage.confirmPassword(confirmPassword);
    }

    @And("select a group from the Select Your Group dropdown")
    public void select_a_group_from_the_select_your_group_dropdown() {
        registrationPage.selectGroupFromDropdown();
    }

    @And("click Create Account button")
    public void click_create_account_button() {
        registrationPage.clickCreateAccountButton();
    }

    @Then("I should see a success message confirming my registration")
    public void i_should_see_a_success_message_confirming_my_registration() {
        registrationPage.verifySuccessfulRegistrationMessageIsDisplayed();

    }


}
