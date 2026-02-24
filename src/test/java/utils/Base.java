package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AdminPanelPage;
import pageObjects.LoginPage;
import pageObjects.RegistrationPage;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    final WebDriver driver = browserFactory.startBrowser("chrome", "https://ndosisimplifiedautomation.vercel.app/");
    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    public RegistrationPage registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
    public AdminPanelPage adminPanelPage = PageFactory.initElements(driver, AdminPanelPage.class);
}


