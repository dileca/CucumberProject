package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Base;

import java.time.Duration;

public class AdminPanelPage extends Base {

    WebDriver driver;
    String email;

    @FindBy(className = "user-pill")
    WebElement adminDropdownButton_id;

    @FindBy(xpath = "//*[@id=\"app-root\"]/nav/div[1]/div[3]/div/div/button[4]/span[2]")
    WebElement adminPanelOption_id;

    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[1]/div[2]/input")
    WebElement searchUserTextBox_id;

    @FindBy(xpath = "//*[@id=\"app-root\"]/div/div[3]/div/div[2]/table/tbody/tr/td[4]/select")
    WebElement userRoleDropdown_id;


    public AdminPanelPage(WebDriver driver) {
        this.driver = driver;
    }

    //   public void loginAsAdmin() throws InterruptedException {
//        driver = new ChromeDriver();
//        driver.get("https://ndosisimplifiedautomation.vercel.app/");
//        Thread.sleep(2000);
//        loginPage.clickNavLoginButton();
//        loginPage.enterEmail("

    public void navigateToAdminPanel() throws InterruptedException {
        adminDropdownButton_id.click();
        Thread.sleep(1000);
        adminPanelOption_id.click();
    }

    public void searchUser(String email) throws InterruptedException {
        searchUserTextBox_id.sendKeys(email);
        Thread.sleep(2000);
    }

    public void changeUserRole() throws InterruptedException {
        userRoleDropdown_id.sendKeys("Admin");
        Thread.sleep(2000);
    }

    public void verifyMessagePopUpOnRoleChange() {
        //Wait for the Alert to be Present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        //Switch to the Alert
        Alert alert2 = driver.switchTo().alert();
        //Retrieve the Alert Message
        String alertMessage = alert2.getText();
        System.out.println(alert2.getText());
        //Validate the Message
        String expectedMessage = "Are you sure you want to change this user's role to \"admin\"?.";
        Assert.assertEquals(alertMessage, expectedMessage, "Alert message mismatch!");
        //Click OK
        alert2.accept();
    }

    public void verifySuccessfulRoleChangeConfirmationPopUp() {
        //Wait for the Alert to be Present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
        //Switch to the Alert
        Alert alert4 = driver.switchTo().alert();
        //Retrieve the Alert Message
        String alertMessage = alert4.getText();
        System.out.println(alert4.getText());
        //Validate the Message
        String expectedMessage = "User role updated to \"admin\" successfully!";
        Assert.assertEquals(alertMessage, expectedMessage, "Alert message mismatch!");
        //Click OK
        alert4.accept();
    }

    public void verifyUserRoleChanged(String email) {
        WebElement userRole = driver.findElement(By.xpath("//*[@id=\"app-root\"]/div/div[3]/div/div[2]/table/tbody/tr/td[4]/select"));
        String selectedRole = userRole.getAttribute("value");
        if (selectedRole.equals("Admin")) {
            System.out.println("User role for " + email + " has been successfully changed to Admin.");
        } else {
            System.out.println("Failed to change user role for " + email + ". Current role: " + selectedRole);
        }
    }


}
