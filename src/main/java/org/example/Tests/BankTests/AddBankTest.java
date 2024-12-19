package org.example.Tests.BankTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Pages.BankManagement.AddBankPage;
import org.example.Pages.HomeDashboard;
import org.example.Pages.LoginPage;
import org.example.Tests.BaseTest;
import org.example.Utilits.DataFaker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddBankTest extends BaseTest {
    HomeDashboard homeDashboard ;
    AddBankPage addBankPage ;
    DataFaker faker;
    @Test
    public void validAddingNewBank() throws InterruptedException {
        homeDashboard = new HomeDashboard(driver);
        addBankPage = new AddBankPage(driver);
        faker = new DataFaker(driver);
        loginWithValidData();
        Thread.sleep(10000);
        homeDashboard.clickBankTab();
        homeDashboard.clickBankSubTab();
        Thread.sleep(10000);
        addBankPage.clickAddIcon();
        Thread.sleep(10000);
        //addBankPage.clickSelectFileButton();
       // addBankPage.uploadImage("C:/Users/RandaKhaled/Downloads/structure LIS.png");
       // Thread.sleep(10000);
        addBankPage.EnterBankName();
        addBankPage.EnableEcommButton();
        addBankPage.EnableGim3dsButton();
        addBankPage.clickSaveButton();
    }
}
