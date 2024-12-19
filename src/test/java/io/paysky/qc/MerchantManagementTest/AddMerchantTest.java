package io.paysky.qc.MerchantManagementTest;

import io.paysky.qc.pages.HomeDashboard;
import io.paysky.qc.pages.MerchantManagement.AddMerchant;
import org.example.QC.BaseTest;
import Utilits.DataFaker;
import org.testng.annotations.Test;

public class AddMerchantTest extends BaseTest {
    HomeDashboard homeDashboard ;
    AddMerchant addMerchant;
    DataFaker faker;
    @Test
    public void validAddNewMerchant() throws InterruptedException {
        HomeDashboard homeDashboard =  new HomeDashboard(driver);
        AddMerchant addMerchant = new AddMerchant(driver);
        DataFaker faker = new DataFaker(driver);
        loginWithValidData();
        Thread.sleep(10000);
        homeDashboard.clickMerchantTab();
        homeDashboard.clickMerchantSubTab();
        Thread.sleep(10000);
        addMerchant.clickAddIcon();
        Thread.sleep(10000);
        addMerchant.clickBankDDL();
        Thread.sleep(5000);
        addMerchant.searchAboutBank();
        addMerchant.selectBank();
        Thread.sleep(1000);
        addMerchant.EnterMerchantName();
        Thread.sleep(1000);
        addMerchant.clickCategoryDDL();
        addMerchant.selectCategory();
        Thread.sleep(5000);
        addMerchant.EnterAddress();
        Thread.sleep(5000);
        addMerchant.clickCityDDL();
        Thread.sleep(1000);
        addMerchant.searchAboutCity();
        Thread.sleep(5000);
        addMerchant.selectCity();
        Thread.sleep(5000);
        addMerchant.EnterMobileNumber();
        Thread.sleep(5000);
        addMerchant.clickNextButton();
        Thread.sleep(1000);
        addMerchant.clickNextButton2();
        Thread.sleep(5000);
        addMerchant.clickInvoiceCloudToggle();
        Thread.sleep(5000);
        addMerchant.clickPayLinkToggle();
        Thread.sleep(5000);
        addMerchant.clickDirectApiToggle();
        Thread.sleep(5000);
        addMerchant.clickNextButton3();
        Thread.sleep(5000);
        addMerchant.EnterMerchantFullName();
        Thread.sleep(5000);
        addMerchant.EnterMerchantUserEmail();
        Thread.sleep(5000);
        addMerchant.clickPortalLoginUsername();
        Thread.sleep(1000);
        addMerchant.selectMerchantId();
        addMerchant.clickEmptyArea();
        Thread.sleep(5000);
        addMerchant.clickNotificationMethod();
        Thread.sleep(1000);
        addMerchant.selectEmail();
        Thread.sleep(1000);
        addMerchant.clickEmptyArea();
        Thread.sleep(5000);
        addMerchant.clickNextButton4();
        Thread.sleep(5000);
        addMerchant.uploadFile("C:/Users/RandaKhaled/Downloads/Security_Testing_Presentation.pdf");
        Thread.sleep(1000);
        addMerchant.clickSaveButton();
        Thread.sleep(10000);
    }
}
