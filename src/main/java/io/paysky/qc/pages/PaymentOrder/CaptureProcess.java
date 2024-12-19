package io.paysky.qc.pages.PaymentOrder;

import Utilits.ConfigReader;
import Utilits.Constant;
import Utilits.DataFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CaptureProcess {
    public WebDriver driver;
    public DataFaker faker;
    public CaptureProcess(WebDriver driver) {
        this.driver = driver;
        this.faker = new DataFaker(driver);
    }
    public void scrollToCaptureButton(){
        WebElement captureButton = driver.findElement(By.xpath("//a[3]/b"));
        ConfigReader.scrollToElement(driver,captureButton);
    }
    public void clickCaptureButton(){
        WebElement captureButton = driver.findElement(By.xpath("//a[3]/b"));
        captureButton.click();
    }
    public void doCaptureProcess() throws InterruptedException {
        WebElement enterPasswordField = driver.findElement(By.id("UserPassword"));
        WebElement captureButton = driver.findElement(By.id("btnSendCapture"));
        enterPasswordField.sendKeys(Constant.Password);
        Thread.sleep(1000);
        captureButton.click();
    }

}
