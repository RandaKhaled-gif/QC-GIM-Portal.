package org.example.Tests;

import org.example.Pages.PaymentOrder.CreatePaymentOrder;
import org.example.Utilits.DataFaker;
import org.testng.annotations.Test;

public class CreatePaymentOrderTest extends BaseTest{
    DataFaker faker;
    CreatePaymentOrder createPaymentOrder;

    @Test
    public void CreateValidPaymentOrder() throws InterruptedException {
        DataFaker faker = new DataFaker(driver);
        CreatePaymentOrder createPaymentOrder = new CreatePaymentOrder(driver);
        loginWithValidData();
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
        createPaymentOrder.enterAmount("2500");
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
        Thread.sleep(1000);
        createPaymentOrder.clickPayButton();
        Thread.sleep(5000);
        createPaymentOrder.EnterLightBoxData();
        Thread.sleep(10000);
    }
}
