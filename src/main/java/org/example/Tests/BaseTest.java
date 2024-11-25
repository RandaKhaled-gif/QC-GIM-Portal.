package org.example.Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Pages.BankManagement.AddBankPage;
import org.example.Pages.HomeDashboard;
import org.example.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://portal-uat.gimpay.org/Portal/Account/Login");
        loginPage = new LoginPage(driver);
    }

    public void loginWithValidData() throws InterruptedException {
        loginPage.enterUsername("10442227306");
        loginPage.enterPassword("1234");
        loginPage.clickSendOtpButton();
        loginPage.enterOtp("1111");
        loginPage.clickSignInButton();
    }
     @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }


    }


}


