package org.example.QC;


import io.paysky.qc.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage ;
    public void loginWithValidData() throws InterruptedException {
        loginPage.enterUsername("randa.khaled");
        loginPage.enterPassword("1234");
        loginPage.clickSendOtpButton();
        loginPage.enterOtp("1111");
        loginPage.clickSignInButton();
    }
}
