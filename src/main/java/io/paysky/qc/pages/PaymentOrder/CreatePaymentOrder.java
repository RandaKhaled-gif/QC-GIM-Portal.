package io.paysky.qc.pages.PaymentOrder;
import Utilits.ConfigReader;
import Utilits.Constant;
import Utilits.DataFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
    By PayButton = By.xpath("//button[contains(.,'Payer')]");
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
    public void enterAmount(){
        driver.findElement(AmountField).clear();
        driver.findElement(AmountField).sendKeys(Constant.Amount);
    }
    public void enterEmail(){ driver.findElement(EmailField).sendKeys(Constant.Email); }
    public void enterNumberOfPayment(){ driver.findElement(NumberOfPayment).clear();
        driver.findElement(NumberOfPayment).sendKeys(Constant.NumberOfPayment);}

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

    public void clickPayButton(){
        String originalTab = driver.getWindowHandle();
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        // Switch to the new tab (assuming it's the second tab)
        for (String tab : tabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
            driver.findElement(PayButton).click();
    }

    public void EnterLightBoxData() throws InterruptedException {
        driver.findElement(CardNumberField).sendKeys(Constant.CardNumber);
        Thread.sleep(1000);
        driver.findElement(ExpiryDateField).sendKeys(Constant.ExpiryDate);
        Thread.sleep(1000);
        driver.findElement(CvvField).sendKeys(Constant.Cvv);
        Thread.sleep(1000);
        driver.findElement(NameOnCard).sendKeys(faker.fullName());
        Thread.sleep(1000);
        driver.findElement(payAmountButton).click();
    }
   public String getTransactionId(){
        WebElement TransactionIdSuccess = driver.findElement(By.xpath("//div[@id='print-section']/div/p/span/strong"));
        String TransactionId = TransactionIdSuccess.getText();
        System.out.println(TransactionId);
        return TransactionId;
   }
   public void SearchAboutTransactionId(){
       String TranId = getTransactionId();
       driver.get("https://portal-uat.gimpay.org/Portal/Transactions/ShowDetails?tid="+TranId);
   }
    public void Payment() throws InterruptedException{
        ClickValueAddedServicesTab();
        Thread.sleep(10000);
        ClickCreatePaymentOrderTab();
        Thread.sleep(10000);
        ClickTerminalIdDDL();
        Thread.sleep(1000);
        SelectWebTerminal();
        Thread.sleep(5000);
        clickEmptyArea();
        Thread.sleep(1000);
        ClickPaymentTypeDDL();
        Thread.sleep(5000);
        searchAboutPaymentType();
        Thread.sleep(5000);
        SelectMultipleType();
        Thread.sleep(5000);
        //  SelectSingleType();
         enterAmount();
         Thread.sleep(1000);
         enterEmail();
         Thread.sleep(1000);
         enterNumberOfPayment();
         Thread.sleep(5000);
         scrollToSaveButton();
         Thread.sleep(1000);
         clickSaveButton();
         Thread.sleep(10000);
         clickPaymentURL();
         Thread.sleep(10000);
         clickPayButton();
         Thread.sleep(10000);
         EnterLightBoxData();
         Thread.sleep(7000);
         getTransactionId();
         Thread.sleep(7000);
         SearchAboutTransactionId();
        Thread.sleep(10000);
    }

}
