package org.example.QC;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.paysky.qc.pages.HomeDashboard.ChangeLanguage;
import io.paysky.qc.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

public class BaseTest {
    public WebDriver driver;
    LoginPage loginPage;
    ChangeLanguage language;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", "C:/Users/RandaKhaled/Downloads");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://portal-uat.gimpay.org/Portal/Account/Login");
        loginPage = new LoginPage(driver);
        language = new ChangeLanguage(driver);
    }

    public void loginWithValidDataInFrench() throws InterruptedException {
        language.clickNavBarDropDown();
        Thread.sleep(1000);
        language.selectFrench();
        Thread.sleep(5000);
        loginPage.enterUsername("randa.khaled");
        loginPage.enterPassword("1234");
        loginPage.clickSendOtpButton();
        loginPage.enterOtp("1111");
        loginPage.clickSignInButton();
    }
    public void loginWithValidDataInEnglish() throws InterruptedException {
        loginPage.enterUsername("randa.khaled");
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


