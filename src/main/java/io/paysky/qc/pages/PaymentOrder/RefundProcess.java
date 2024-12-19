package io.paysky.qc.pages.PaymentOrder;

import Utilits.Constant;
import Utilits.DataFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RefundProcess {
    public WebDriver driver;
    public DataFaker faker;
    public RefundProcess(WebDriver driver) {
        this.driver = driver;
        this.faker = new DataFaker(driver);
    }
    public void clickRefundButton(){
        WebElement RefundButton = driver.findElement(By.xpath("//a[3]/b"));
        RefundButton.click();
    }
    public void doRefundProcess() throws InterruptedException {
        WebElement enterPasswordField = driver.findElement(By.id("UserPassword"));
        WebElement enterAmountField = driver.findElement(By.id("Amount"));
        WebElement enterReasonField = driver.findElement(By.id("RefundReason"));
        WebElement refundButton = driver.findElement(By.id("btnSendRefund"));
        enterPasswordField.sendKeys(Constant.Password);
        Thread.sleep(1000);
        enterAmountField.sendKeys(Constant.Amount);
        Thread.sleep(1000);
        enterReasonField.sendKeys("Testing");
        Thread.sleep(1000);
        refundButton.click();
    }
}
