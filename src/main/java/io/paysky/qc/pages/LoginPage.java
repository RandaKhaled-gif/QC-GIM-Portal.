package io.paysky.qc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.paysky.qc.utilities.sharedComponent.SharedComponent.waitUntilVisible;

public class LoginPage {
    public WebDriver driver;
    public WebDriverWait wait;
    public HomeDashboard homeDashboard;
    public java.lang.Thread Thread;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
        By usernameField = By.id("UserName");
        By passwordField = By.id("userpassword");
        By sendOtpButton = By.id("sendotp");
        By otpField = By.id("otp");
        By signInButton = By.id("signinbtn");
    public void enterUsername(String name){
        driver.findElement(usernameField).sendKeys(name);
    }
    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSendOtpButton(){
        driver.findElement(sendOtpButton).click();
    }

    public void enterOtp(String otp) throws InterruptedException {
        java.lang.Thread.sleep(2000);
        driver.findElement(otpField).sendKeys(otp);
    }
    public void clickSignInButton(){
        driver.findElement(signInButton).click();
    }
}