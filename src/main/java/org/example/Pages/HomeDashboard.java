package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeDashboard {
    public WebDriver driver;
    public WebDriverWait wait;
    public HomeDashboard(WebDriver driver) {
        this.driver = driver;
    }
    By BankTab = By.xpath("//a[@href='#Banks']");
    By BankSubTab = By.xpath("//a[@href='/Portal/BankManagement/Banks']");
    By MerchantTab = By.xpath("//span[normalize-space()='Merchants']");
    By MerchantSubTab = By.xpath("//a[@href='/Portal/MerchantManagement/Merchants']");

    public void clickBankTab(){
      //  WebElement BankTabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#Banks']")));

        driver.findElement(BankTab).click();
    }
    public void clickBankSubTab(){
        driver.findElement(BankSubTab).click();
    }
    public void clickMerchantTab(){
        driver.findElement(MerchantTab).click();
    }
    public void clickMerchantSubTab(){
        driver.findElement(MerchantSubTab).click();
    }
}
