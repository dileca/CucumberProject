package stepDefinitions;

import io.cucumber.java.en.*;


public class LoginSteps {
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
    }

    @When("I enter valid username {}")
    public void iEnterValidUsernameUsername(String username) {
    }

    @And("I enter valid password {}")
    public void iEnterValidPasswordPassword(String password) {
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
    }
}
