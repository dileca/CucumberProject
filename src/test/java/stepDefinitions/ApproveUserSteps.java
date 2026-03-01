package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import utils.Base;

public class ApproveUserSteps extends Base {

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        loginPage.clickNavLoginButton();
    }


    @When("I enter valid username {}")
    public void iEnterValidUsername(String username) {
        loginPage.enterUsername(username);
    }


    @And("I enter valid password {}")
    public void iEnterValidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the dashboard for {}")
    public void iShouldBeRedirectedToTheDashboardForUser(String User) {
        String actualValue = loginPage.getLoginSuccessMessage();
            System.out.println("Actual login success message: " + actualValue);
            String expectedValue = "Welcome back, " + User + "! 👋";
            Assert.assertEquals(actualValue, expectedValue,
                    "Expected message: " + expectedValue + ", but got: " + actualValue);
    }

    @And("I select Admin Panel from the Admin dropdown")
    public void iSelectAdminPanelFromTheAdminDropdown() throws InterruptedException {
        adminPanelPage.navigateToAdminPanel();
    }

    @And("I select Approvals from the Admin Panel")
    public void iSelectApprovalsFromTheAdminPanel() throws InterruptedException {
        adminPanelPage.navigateToApprovalsPage();
    }

    @And("I search for the User via email {}")
    public void iFindMyUserViaTheSearch(String email) throws InterruptedException {
        approvalsPage.searchUserInApprovals(email);
    }

    @And("I approve the user")
    public void iApproveTheUser() throws InterruptedException {
        approvalsPage.clickApproveButton();
    }


    @Then("I should receive a Success message")
    public void iShouldReceiveASuccessMessage() {
        String actualValue = approvalsPage.verifyApprovalSuccessMessageIsDisplayed();
        System.out.println("Actual success message: " + actualValue);
        String expectedValue = "User approved successfully!";
        Assert.assertEquals(actualValue, expectedValue,
                "Expected message: " + expectedValue + ", but got: " + actualValue);
    }

}