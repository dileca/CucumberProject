package stepDefinitions;

import io.cucumber.java.en.*;
import utils.Base;

public class UpdateAdminSteps extends Base {

   // Are you sure you want to change this user's role to "admin"?
  // User role updated to "admin" successfully!



    @And("I select Approvals from the Admin Panel")
    public void iSelectApprovalsFromTheAdminPanel() {
            loginPage.clickNavLoginButton();
        }


    @And("I approve the user")
    public void iApproveTheUser() {
    }
}
