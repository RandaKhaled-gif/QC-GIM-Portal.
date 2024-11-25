package org.example.Pages.PaymentOrder;

import org.example.Utilits.ConfigReader;
import org.example.Utilits.DataFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreatePaymentOrder {
    public WebDriver driver;
    public DataFaker faker;
    public CreatePaymentOrder(WebDriver driver){
        this.driver = driver;
        this.faker = new DataFaker(driver);}
    By ValueAddedServicesTab = By.xpath("//li[@id='ValueAddedServicesMerchant']/a/span");
    By CreatePaymentOrderTab = By.xpath("//a[contains(@href, '/Portal/Merchant/CreatePaymentOrder')]");
    By TerminalIdDDL = By.id("select2-NodeId-container");
    By SelectWebTerminal = By.xpath("//*[text()= '20734388']");
    By EmptyArea = By.id("frmCreatePaymentOrder");
    By PaymentTypeDDL = By.id("select2-PaymentType-container");
    By SearchPaymentType = By.xpath("//input[@type='search']");
    By SelectSingleTypeOption = By.xpath("//*[text() = 'One-use link ...']");
    By SelectMultipleTypeOption = By.xpath("//*[text()= 'Multiple-use link ...']");
    By AmountField = By.id("Amount");
    By EmailField = By.id("Email");
    By NumberOfPayment = By.id("MaxNumberOfPayment");
    By saveButton = By.id("btnSave");
    By PayButton = By.xpath("//button[normalize-space()='Pay']");
    By CardNumberField = By.id("cc-number");
    By ExpiryDateField = By.id("inputExpiration");
    By CvvField = By.id("inputCVV");
    By NameOnCard = By.id("inputNameonCard");
    By payAmountButton = By.id("pay-btn");
    public void ClickValueAddedServicesTab(){
        driver.findElement(ValueAddedServicesTab).click();
    }
    public void ClickCreatePaymentOrderTab(){
        driver.findElement(CreatePaymentOrderTab).click();
    }
    public void ClickTerminalIdDDL(){
        driver.findElement(TerminalIdDDL).click();
    }
    public void SelectWebTerminal(){
        driver.findElement(SelectWebTerminal).click();
    }
    public void clickEmptyArea(){ driver.findElement(EmptyArea).click(); }
    public void ClickPaymentTypeDDL(){
        driver.findElement(PaymentTypeDDL).click();
    }
    public void searchAboutPaymentType(){
        driver.findElement(SearchPaymentType).sendKeys("Mul");
    }
    public void SelectMultipleType(){
        driver.findElement(SelectMultipleTypeOption).click();
    }
    public void SelectSingleType(){
        driver.findElement(SelectSingleTypeOption).click();
    }
    public void enterAmount(String amount){
        driver.findElement(AmountField).clear();
        driver.findElement(AmountField).sendKeys(amount);
    }
    public void enterEmail(){ driver.findElement(EmailField).sendKeys("randa.khaled@paysky.io"); }
    public void enterNumberOfPayment(){ driver.findElement(NumberOfPayment).clear();
        driver.findElement(NumberOfPayment).sendKeys("80");}
    public void scrollToSaveButton(){
        WebElement save = driver.findElement(saveButton);
        ConfigReader.scrollToElement(driver,save); }
    public void clickSaveButton(){ driver.findElement(saveButton).click();
    }
    public void clickPaymentURL(){
        WebElement linkElement = driver.findElement(By.xpath("//a[contains(@href, 'lightbox-uat.gimpay.org')]"));
        String hrefValue = linkElement.getAttribute("href");
        //To open in new tab
        ((JavascriptExecutor) driver).executeScript("window.open(arguments[0], '_blank');", hrefValue);
    }
    public void clickPayButton(){ driver.findElement(PayButton).click(); }
    public void EnterLightBoxData(){
        driver.findElement(CardNumberField).sendKeys();
        driver.findElement(ExpiryDateField).sendKeys();
        driver.findElement(CvvField).sendKeys();
        driver.findElement(NameOnCard).sendKeys();
        driver.findElement(payAmountButton).click();
    }
}
