package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApprovalsPage {

        WebDriver driver;

        @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[2]/div/div/input")
        WebElement approvalSearchField_id;

        @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[3]/table/tbody/tr[1]/td[6]/button[1]")
        WebElement approveButton_id;

        @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[2]")
        WebElement approvalSuccessMessage_id;


        public void searchUserInApprovals(String email) throws InterruptedException {
            approvalSearchField_id.sendKeys(email);
            Thread.sleep(2000);
        }

        public void clickApproveButton() throws InterruptedException {
            approveButton_id.click();
            Thread.sleep(2000);
        }

        public String verifyApprovalSuccessMessageIsDisplayed() {
            return approvalSuccessMessage_id.getText();
        }



    }


