package io.paysky.qc.pages.PaymentOrder;

import Utilits.ConfigReader;
import Utilits.Constant;
import Utilits.DataFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CancellationProcess {
    public WebDriver driver;
    public DataFaker faker;
    public CancellationProcess(WebDriver driver) {
        this.driver = driver;
        this.faker = new DataFaker(driver);
    }
    public void scrollToCancellationButton(){
        WebElement cancellationButton = driver.findElement(By.xpath("//a[4]/b"));
        ConfigReader.scrollToElement(driver,cancellationButton);
    }
    public void clickCancellationButton(){
        WebElement cancellationButton = driver.findElement(By.xpath("//a[4]/b"));
        cancellationButton.click();
    }
    public void doCancellationProcess() throws InterruptedException {
        WebElement enterPasswordField = driver.findElement(By.id("UserPassword"));
        WebElement enterReasonField = driver.findElement(By.id("RefundReason"));
        WebElement cancelButton = driver.findElement(By.id("btnSendRefund"));
        enterPasswordField.sendKeys(Constant.Password);
        Thread.sleep(1000);
        enterReasonField.sendKeys("Testing");
        Thread.sleep(1000);
        cancelButton.click();
    }


}
