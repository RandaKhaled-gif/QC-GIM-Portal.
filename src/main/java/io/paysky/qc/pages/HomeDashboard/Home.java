package io.paysky.qc.pages.HomeDashboard;

import io.github.bonigarcia.wdm.webdriver.OptionsWithArguments;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    By SettlementReportTab = By.xpath("//a[@href='/Portal/Transactions/MerchantSettlement']");
    public void clickSettlementReportTab(){
        driver.findElement(SettlementReportTab).click(); }

    By ExportedFilesDownload = By.xpath("/html/body/div[2]/div/nav/ul/li[21]/a");
    public void clickExportedFilesDownload(){
        WebElement Exported =  driver.findElement(By.xpath("//a[@href='/Portal/Base/ExportedFilesDownloadSearch']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", Exported);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(Exported));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Exported); }
    By DownloadExported = By.xpath("//tbody/tr[1]/td[4]/b[1]/div[1]/a[1]//*[name()='svg']//*[name()='path' and contains(@fill,'currentCol')]");
    public void clickDownloadExported(){
        driver.findElement(DownloadExported).click();}
}
