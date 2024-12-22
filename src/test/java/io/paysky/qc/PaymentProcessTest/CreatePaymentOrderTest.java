package io.paysky.qc.PaymentProcessTest;

import io.paysky.qc.pages.PaymentOrder.CreatePaymentOrder;
import org.example.QC.BaseTest;
import Utilits.DataFaker;
import org.testng.annotations.Test;

public class CreatePaymentOrderTest extends BaseTest {
    DataFaker faker;
    CreatePaymentOrder createPaymentOrder;

    @Test
    public void ValidPaymentOrder() throws InterruptedException {
        CreatePaymentOrder createPaymentOrder = new CreatePaymentOrder(driver);
        loginWithValidDataInFrench();
        Thread.sleep(10000);
        createPaymentOrder.ClickValueAddedServicesTab();
        Thread.sleep(10000);
        createPaymentOrder.ClickCreatePaymentOrderTab();
        Thread.sleep(10000);
        createPaymentOrder.ClickTerminalIdDDL();
        Thread.sleep(1000);
        createPaymentOrder.SelectWebTerminal();
        Thread.sleep(5000);
        createPaymentOrder.clickEmptyArea();
        Thread.sleep(1000);
        createPaymentOrder.enterAmount();
        Thread.sleep(5000);
        createPaymentOrder.ClickPaymentTypeDDL();
        Thread.sleep(5000);
        createPaymentOrder.searchAboutPaymentType();
        Thread.sleep(5000);
        createPaymentOrder.SelectMultipleType();
        Thread.sleep(1000);
        createPaymentOrder.clickEmptyArea();
        Thread.sleep(1000);
        createPaymentOrder.enterEmail();
        Thread.sleep(1000);
        createPaymentOrder.enterNumberOfPayment();
        Thread.sleep(5000);
        createPaymentOrder.scrollToSaveButton();
        Thread.sleep(1000);
        createPaymentOrder.clickSaveButton();
        Thread.sleep(10000);
        createPaymentOrder.clickPaymentURL();
        Thread.sleep(10000);
        createPaymentOrder.clickPayButton();
        Thread.sleep(7000);
        createPaymentOrder.EnterLightBoxData();
        Thread.sleep(10000);
        createPaymentOrder.getTransactionId();
        Thread.sleep(7000);
        createPaymentOrder.SearchAboutTransactionId();
        Thread.sleep(7000);
    }
}
