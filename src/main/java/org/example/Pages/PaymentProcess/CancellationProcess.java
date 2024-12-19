package org.example.Pages.PaymentProcess;

import org.example.Utilits.DataFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CancellationProcess {
    public WebDriver driver;
    public DataFaker faker;
    public CancellationProcess(WebDriver driver) {
        this.driver = driver;
        this.faker = new DataFaker(driver);
    }
    By ReportsTab = By.xpath("//ul[@id='ulul']/li[2]/a");
    By TransactionReportSubTab = By.xpath("//li[@id='IndexTransactions']/a");
    By SelectSearchParameter = By.xpath("//h2[@id='headingOne']/button");
    public void clickReportsTab(){ driver.findElement(ReportsTab).click(); }
    public void clickTransactionReportSubTab(){ driver.findElement(TransactionReportSubTab).click(); }
    public void clickSelectSearchParameter(){ driver.findElement(SelectSearchParameter).click(); }


}
