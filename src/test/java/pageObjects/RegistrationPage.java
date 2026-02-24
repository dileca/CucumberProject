package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RegistrationPage {

    WebDriver driver;

  //  @FindBy(id = "signup-toggle")
  //  WebElement signUpHereLink_id;

    @FindBy(xpath = "//div[@class='nav-user-section']")
    WebElement navLoginButtonXpath;
    //*[@id="app-root"]/nav/div[1]/div[3]/button/span[2]

    @FindBy(id = "login-heading")
    WebElement loginpageTitle_id;

    @FindBy(id = "registration-heading")
    WebElement registrationHeader_id;

    @FindBy(id = "register-firstName")
    WebElement firstNameTextBox_id;

    @FindBy(id = "register-lastName")
    WebElement lastNameTextBox_id;

    @FindBy(id = "register-email")
    WebElement emailTextBox_id;

    @FindBy(id = "register-password")
    WebElement passwordTextBox_id;

    @FindBy(id = "register-confirmPassword")
    WebElement confirmPasswordTextBox_id;

    @FindBy(id = "register-group")
    WebElement groupDropdown_id;

    @FindBy(id = "register-submit")
    WebElement createAccountButton_id;

    @FindBy(id = "login-toggle")
    WebElement loginHereHyperlink_id;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickNavLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(navLoginButtonXpath));
        navLoginButtonXpath.click();
    }

    public void verifyLoginPageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(visibilityOf(loginpageTitle_id));
        loginpageTitle_id.isDisplayed();
        System.out.println(loginpageTitle_id.getText());
    }

    public void clickSignUpHereLink() {
        loginHereHyperlink_id.click();
    }

    public void verifyRegistrationPageIsDisplayed() {
        registrationHeader_id.isDisplayed();
        System.out.println(registrationHeader_id.getText());
    }

    public void enterFirstName(String firstName) {
        firstNameTextBox_id.clear();
        firstNameTextBox_id.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameTextBox_id.clear();
        lastNameTextBox_id.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailTextBox_id.clear();
        emailTextBox_id.sendKeys(email);
    }

    //create a method to auto-generate a unique email address for each test run ending in gmail.com and save it as a variable to be used in the registration process
    //public String generateUniqueEmail() {
    //    String uniqueEmail = "testuser" + System.currentTimeMillis() + "@gmail.com";
    //    return uniqueEmail;
    //}

    public void enterPassword(String password) {
        passwordTextBox_id.clear();
        passwordTextBox_id.sendKeys(password);
    }

    public void confirmPassword(String password) {
        confirmPasswordTextBox_id.clear();
        confirmPasswordTextBox_id.sendKeys(password);
    }

    public void selectGroupFromDropdown() {
       groupDropdown_id.clear();
       groupDropdown_id.sendKeys("Group T (2026)");
    }

    public void clickCreateAccountButton() {
        createAccountButton_id.click();
    }

    public void verifySuccessfulRegistrationMessageIsDisplayed() {
        //Wait for the Alert to be Present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        //Switch to the Alert
        Alert alert2 = driver.switchTo().alert();
        //Retrieve the Alert Message
        String alertMessage = alert2.getText();
        System.out.println(alert2.getText());
        //Validate the Message
        String expectedMessage = "Registration submitted successfully. Your account is pending admin approval.";
        Assert.assertEquals(alertMessage, expectedMessage, "Alert message mismatch!");
        //Click OK
        alert2.accept();
    }
    }




