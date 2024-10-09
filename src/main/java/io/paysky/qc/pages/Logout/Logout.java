package io.paysky.qc.pages.Logout;

import io.paysky.qc.utilities.selenium.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logout {

    private WebDriver driver;

    public Logout() {
        driver = DriverFactory.getDriver();
    }

    public void Log_out() throws InterruptedException {
        driver = DriverFactory.getDriver();
        driver.findElement(By.id("navbarDropdown")).click();
        Thread.sleep(5000);
        driver.findElement(By.linkText("Log out")).click();
        Thread.sleep(5000);
    }

    public void Close_Driver_After_Test() {
        driver.close();
    }

}