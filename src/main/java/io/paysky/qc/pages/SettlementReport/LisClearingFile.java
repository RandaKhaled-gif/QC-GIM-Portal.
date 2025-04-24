package io.paysky.qc.pages.SettlementReport;

import Utilits.DataFaker;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LisClearingFile {
    public WebDriver driver;
    public WebDriverWait wait;
    public DataFaker faker ;
    public LisClearingFile(WebDriver driver) {
        this.driver = driver;
       // this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.faker = new DataFaker(driver);
    }
    By BankDDL = By.xpath("//span[@id='select2-BankId-container']");
    By SearchBank = By.xpath("//input[@type='search']");
    By SelectBank = By.xpath("//*[text()= 'ecommerce OFFUS bank']");
    By SettlementTypeDDL = By.xpath("//span[@id='select2-SettlementType-container']");
    By SearchType = By.xpath("//input[@type='search']");
    By SelectType = By.xpath("//*[text()= 'LISClearingFile']");
    By DateFrom = By.xpath("//input[@id='DateFrom']");
    By DateTo = By.xpath("//input[@id='DateTo']");
    By space = By.xpath("//label[normalize-space()='Date à']");
    By DownloadButton = By.xpath("//button[@id='btnDownload']");

    public void clickBankDDL(){
        driver.findElement(BankDDL).click();}
    public void searchAboutBank(){
        driver.findElement(SearchBank).sendKeys("of");
    }
    public void selectBank(){
        driver.findElement(SelectBank).click();}

    public void clickSettlementTypeDDL(){
        driver.findElement(SettlementTypeDDL).click();}
    public void searchAboutSettlementType(){
        driver.findElement(SearchType).sendKeys("LIS");
    }
    public void selectType(){
        driver.findElement(SelectType).click();}
    public void clickSpace(){
        driver.findElement(space).click();}

     public void changeDate(){
       LocalDate yesterday = LocalDate.now().minusDays(1);
        String formattedDateTime = yesterday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " 12:00 AM";
        WebElement dateField = driver.findElement(By.xpath("//input[@id='DateFrom']"));
        dateField.click();
        dateField.clear();
        dateField.sendKeys(formattedDateTime);
        dateField.sendKeys(Keys.ENTER);
    }

    public void clickDownloadButton(){
        driver.findElement(DownloadButton).click();}


}
