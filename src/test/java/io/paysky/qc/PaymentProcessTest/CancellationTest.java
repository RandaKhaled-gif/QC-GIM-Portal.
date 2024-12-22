package io.paysky.qc.PaymentProcessTest;

import io.paysky.qc.pages.PaymentOrder.CancellationProcess;
import io.paysky.qc.pages.PaymentOrder.CreatePaymentOrder;
import org.example.QC.BaseTest;
import Utilits.DataFaker;
import org.testng.annotations.Test;

public class CancellationTest extends BaseTest {
    CancellationProcess cancellationProcess;
    CreatePaymentOrder createPaymentOrder;
    @Test
    public void ValidCancellationProcess() throws InterruptedException {
         cancellationProcess  = new CancellationProcess(driver);
         createPaymentOrder = new CreatePaymentOrder(driver);
        loginWithValidDataInFrench();
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
