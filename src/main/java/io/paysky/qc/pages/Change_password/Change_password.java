package io.paysky.qc.pages.Change_password;

import io.paysky.qc.utilities.selenium.DriverFactory;
import io.paysky.qc.utilities.testdata.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Change_password {

    private WebDriver driver;
    String Home_Page_URL = "https://cube.gimpay.org/portal/Admin";

    public Change_password() {
        driver = DriverFactory.getDriver();
    }

    public void Open_change_password() throws InterruptedException {
        driver.findElement(By.id("navbarDropdown")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Change password")).click();
        Thread.sleep(5000);
    }

    public void Enter_change_password() {
        driver.findElement(By.id("OldPassword")).sendKeys(Constant.Admin_password);
        driver.findElement(By.id("NewPassword")).sendKeys(Constant.Invalid_Admin_password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Constant.Invalid_Admin_password);
    }

    public void Cancel_Enter_change_password() {
        driver.findElement(By.id("btnCancel")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.urlContains(Home_Page_URL));
    }

    public void change_valid_password() throws InterruptedException {
        driver.findElement(By.id("OldPassword")).sendKeys(Constant.Admin_password);
        driver.findElement(By.id("NewPassword")).sendKeys(Constant.New_password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Constant.Confirm_password);
        driver.findElement(By.id("btnSave")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        wait.until(ExpectedConditions.urlContains(Home_Page_URL));
        driver.findElement(By.id("navbarDropdown")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Change password")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("OldPassword")).sendKeys(Constant.New_password);
        driver.findElement(By.id("NewPassword")).sendKeys(Constant.New_password_return_back);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(Constant.Confirm_password_return_back);
        driver.findElement(By.id("btnSave")).click();
    }
}
