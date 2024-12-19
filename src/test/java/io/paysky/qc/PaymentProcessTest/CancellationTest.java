package io.paysky.qc.PaymentProcessTest;

import io.paysky.qc.pages.PaymentOrder.CancellationProcess;
import io.paysky.qc.pages.PaymentOrder.CreatePaymentOrder;
import org.example.QC.BaseTest;
import Utilits.DataFaker;
import org.testng.annotations.Test;

public class CancellationTest extends BaseTest {
    DataFaker faker;
    CancellationProcess cancellationProcess;
    CreatePaymentOrder createPaymentOrder;
    @Test
    public void ValidCancellationProcess() throws InterruptedException {
        CancellationProcess cancellationProcess  = new CancellationProcess(driver);
        CreatePaymentOrder createPaymentOrder = new CreatePaymentOrder(driver);
        loginWithValidData();
        Thread.sleep(10000);
        createPaymentOrder.Payment();
        cancellationProcess.scrollToCancellationButton();
        Thread.sleep(1000);
        cancellationProcess.clickCancellationButton();
        Thread.sleep(5000);
        cancellationProcess.doCancellationProcess();
        Thread.sleep(10000);
    }

}
