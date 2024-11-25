package org.example.Pages.BankManagement;

import org.example.Utilits.ConfigReader;
import org.example.Utilits.DataFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddBankPage {
    public WebDriver driver;
    public WebDriverWait wait;
   public DataFaker faker ;

    public AddBankPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        this.faker = new DataFaker(driver);
    }
    By AddIcon = By.xpath("//a[@title='add']");
    By SelectFileButton = By.xpath("//input[@id='LogoImg']");
    By Gim3dsButton = By.xpath("//*[@id=\"frmUpdateBank\"]/div[16]/div[9]/div[2]/label/div");
    By BankField = By.id("Bank_Name");
    By EcommButton = By.xpath("//*[@id=\"frmUpdateBank\"]/div[14]/div[2]/label");
   By ICSButton = By.xpath("//*[@id=\"frmUpdateBank\"]/div[15]/div/div[1]/div[2]/label/div");
   By saveButton = By.id("btnSave");
    public void clickAddIcon(){
       // WebElement AddIconElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='add']")));
        driver.findElement(AddIcon).click();
    }
    public void uploadImage(String path){
        driver.findElement(SelectFileButton).sendKeys(path);
    }
    public void EnableGim3dsButton() throws InterruptedException {
        WebElement saveButt = driver.findElement(By.id("btnSave"));
        ConfigReader.scrollToElement(driver, saveButt);
        Thread.sleep(2000);
        driver.findElement(Gim3dsButton).click();
    }
    public void EnterBankName(){
        driver.findElement(BankField).sendKeys(faker.fullName());
    }
    public void EnableEcommButton() throws InterruptedException {
        WebElement Ecomm = driver.findElement(EcommButton);
        ConfigReader.scrollToElement(driver, Ecomm);
        Thread.sleep(2000);
        driver.findElement(EcommButton).click();
        driver.findElement(ICSButton).click();
    }
    public void clickSaveButton() throws InterruptedException {
        WebElement saveButt = driver.findElement(By.id("btnSave"));
        ConfigReader.scrollToElement(driver, saveButt);
        Thread.sleep(2000);
        driver.findElement(saveButton).click();
    }

}
