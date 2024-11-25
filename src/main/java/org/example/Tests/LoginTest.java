package org.example.Tests;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.opencsv.exceptions.CsvException;
import org.example.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;


public class LoginTest {
    WebDriver driver;
     LoginPage loginPage ;
    @BeforeTest
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        driver.get("https://portal-uat.gimpay.org/Portal/Account/Login");
    }

   @Test
    public void validLoginOnPortal(){
        loginPage.enterUsername("randa.khaled");
        loginPage.enterPassword("1234");
        loginPage.clickSendOtpButton();
        loginPage.enterOtp("1111");
        loginPage.clickSignInButton();
   }

}
