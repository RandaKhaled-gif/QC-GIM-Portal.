package io.paysky.qc.pages.MerchantManagement;

import io.paysky.qc.utilities.ConfigReader;
import io.paysky.qc.utilities.DataFaker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddMerchant {
    public WebDriver driver;
    public DataFaker faker;

    public AddMerchant(WebDriver driver) {
        this.driver = driver;
        this.faker = new DataFaker(driver);
    }

    By AddIcon = By.xpath("//a[@title='add']");
    By BankDDL = By.id("select2-BankId-container");

    By SearchBank = By.xpath("//input[@type='search']");
    By SelectBank = By.xpath("//*[text()= 'ecommerce OFFUS bank']");
    By MerchantName = By.xpath("//input[@id='MerchantName']");
    By CategoryDDL = By.id("CategoryCodeId");
    By SelectCategory = By.xpath("//option[. = '3000-UNITED AIRLINES']");
    By Address = By.id("Address1");
    By CityDDL = By.id("select2-StateId-container");
    By SearchCity = By.xpath("//input[@type='search']");
    By SelectCity = By.xpath("//*[text()= 'Dakar']");
    By MobileField = By.id("TempMerchant_ContactPersonPhone");
    By NextButton = By.xpath("//*[@id=\"step-1\"]/div[3]/button");
    By NextButton2 = By.xpath("//*[@id=\"step-2\"]/div[5]/button");
    By InvoiceCloud = By.xpath("//div[@id='step-3']/div[3]/div/div/div[38]/div/div/div[2]/label/div");
    By PayLink = By.xpath("//div[@id='step-3']/div[3]/div/div/div[38]/div/div/div[4]/label/div");
    By DirectApiInt = By.xpath("//*[@id=\"step-3\"]/div[3]/div/div/div[44]/div[2]/label/div");
    By NextButton3 = By.xpath("//div[@id='step-3']/div[5]/button");
    By MerchantFullName = By.id("MerchantFullName");
    By MerchantUserEmail = By.id("MerchantUserEmail");
    By PortalLoginUsername = By.id("select2-MerchantUserNameSelectedType-container");
    By SelectMerchantId = By.xpath("//option[. = 'Merchant ID']");
    public void clickAddIcon() {
        driver.findElement(AddIcon).click();
    }
    public void clickBankDDL() {
        driver.findElement(BankDDL).click();
    }
    public void searchAboutBank(){
        driver.findElement(SearchBank).sendKeys("of");
    }
    public void selectBank(){
        driver.findElement(SelectBank).click();
    }
    public void EnterMerchantName(){
        driver.findElement(MerchantName).sendKeys(faker.fullName());
    }
    public void clickCategoryDDL(){
        driver.findElement(CategoryDDL).click();
    }
    public void selectCategory(){
        driver.findElement(SelectCategory).click();
    }
    public void EnterAddress(){
        driver.findElement(Address).sendKeys(faker.address());
    }
    public void clickCityDDL() { driver.findElement(CityDDL).click(); }
    public void searchAboutCity(){
        driver.findElement(SearchCity).sendKeys("Da");
    }
    public void selectCity(){ driver.findElement(SelectCity).click(); }
    public void EnterMobileNumber(){ driver.findElement(MobileField).sendKeys(faker.mobileNumber()); }
    public void clickNextButton() throws InterruptedException {
        WebElement Next = driver.findElement(NextButton);
        ConfigReader.scrollToElement(driver, Next);
        Thread.sleep(5000);
        driver.findElement(NextButton).click(); }
    public void clickNextButton2(){ driver.findElement(NextButton2).click(); }
    public void clickInvoiceCloudToggle(){ driver.findElement(InvoiceCloud).click(); }
    public void clickPayLinkToggle(){ driver.findElement(PayLink).click(); }
    public void clickDirectApiToggle() throws InterruptedException {
        WebElement Next = driver.findElement(NextButton3);
        ConfigReader.scrollToElement(driver,Next);
        Thread.sleep(5000);
        driver.findElement(DirectApiInt).click(); }
    public void clickNextButton3() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(NextButton3).click(); }
    public void EnterMerchantFullName(){
        driver.findElement(MerchantFullName).sendKeys(faker.fullName());
    }
    public void EnterMerchantUserEmail(){
        driver.findElement(MerchantUserEmail).sendKeys("randa.khaled@paysky.io");
    }
    public void clickPortalLoginUsername(){ driver.findElement(PortalLoginUsername).click(); }
    public void selectMerchantId(){ driver.findElement(SelectMerchantId).click(); }

}