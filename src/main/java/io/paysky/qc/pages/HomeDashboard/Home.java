package io.paysky.qc.pages.HomeDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    public WebDriver driver;
    public Home(WebDriver driver) {
        this.driver = driver;
    }
    By BankTab = By.xpath("//ul[@id='ulul']/li[3]/a");
    By BankSubTab = By.xpath("//li[@id='IndexBanks']/a");
    public void clickBankTab(){
        driver.findElement(BankTab).click(); }
    public void clickBankSubTab(){
        driver.findElement(BankSubTab).click(); }
    By MerchantTab = By.xpath("//ul[@id='ulul']/li[4]/a");
    By MerchantSubTab = By.xpath("//li[@id='IndexMerchants']/a");
    public void clickMerchantTab(){
        driver.findElement(MerchantTab).click(); }
    public void clickMerchantSubTab(){
        driver.findElement(MerchantSubTab).click(); }
}
