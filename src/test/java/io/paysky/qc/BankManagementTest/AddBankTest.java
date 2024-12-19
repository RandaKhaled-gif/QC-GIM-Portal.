package io.paysky.qc.BankManagementTest;

import io.paysky.qc.pages.BankManagement.AddBankPage;
import io.paysky.qc.pages.HomeDashboard;
import org.example.QC.BaseTest;
import Utilits.DataFaker;
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
