package io.paysky.qc.BankManagementTest;

import io.paysky.qc.pages.BankManagement.AddBankPage;
import io.paysky.qc.pages.HomeDashboard.Home;
import org.example.QC.BaseTest;
import Utilits.DataFaker;
import org.testng.annotations.Test;

public class AddBankTest extends BaseTest {
    Home homeDashboard ;
    AddBankPage addBankPage ;

    @Test
    public void validAddingNewBank() throws InterruptedException {
        homeDashboard = new Home(driver);
        addBankPage = new AddBankPage(driver);
        loginWithValidDataInFrench();
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
