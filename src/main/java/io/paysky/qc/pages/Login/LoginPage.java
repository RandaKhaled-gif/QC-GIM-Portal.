package io.paysky.qc.pages.Login;

import io.paysky.qc.GlobalProperties;
import io.paysky.qc.utilities.selenium.DriverFactory;
import io.paysky.qc.utilities.testdata.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    public void LoginURL() {
        driver = DriverFactory.getDriver();
        driver.get(GlobalProperties.getProperty("Login_main_URL"));
    }

    public void Valid_Login_with_admin_user() throws InterruptedException {
        driver.findElement(By.id("UserName")).sendKeys(Constant.Admin_user);
        driver.findElement(By.id("userpassword")).sendKeys(Constant.Admin_password);
        driver.findElement(By.id("sendotp")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("otp")).sendKeys(Constant.OTP);
        driver.findElement(By.id("signinbtn")).click();
        Thread.sleep(10000);
    }

    public void Invalid_credentials_with_admin_user() throws InterruptedException {
        driver.findElement(By.id("UserName")).sendKeys(Constant.Invalid_Admin_user);
        driver.findElement(By.id("userpassword")).sendKeys(Constant.Invalid_Admin_password);
        driver.findElement(By.id("sendotp")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("otp")).sendKeys(Constant.OTP);
        driver.findElement(By.id("signinbtn")).click();
        String Error_Message = driver.findElement(By.id("validateSummaryDiv")).getText();
        Assert.assertEquals(Error_Message, "Invalid user name or password.");
        Thread.sleep(5000);
    }

    public void Invalid_OTP_Login_with_admin_user() throws InterruptedException {
        driver.findElement(By.id("UserName")).sendKeys(Constant.Admin_user);
        driver.findElement(By.id("userpassword")).sendKeys(Constant.Admin_password);
        driver.findElement(By.id("sendotp")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("otp")).sendKeys(Constant.Invalid_OTP);
        driver.findElement(By.id("signinbtn")).click();
        Thread.sleep(2000);
        String Error_Message = driver.findElement(By.id("validateSummaryDiv")).getText();
        Assert.assertEquals(Error_Message, "Code is not verified.");
        Thread.sleep(5000);
    }

    public void Login_clear_credentials() throws InterruptedException {
        driver.findElement(By.id("UserName")).clear();
        driver.findElement(By.id("userpassword")).clear();
        Thread.sleep(5000);
    }

}