package io.paysky.qc.PaymentProcessTest;

import io.paysky.qc.pages.PaymentOrder.CaptureProcess;
import io.paysky.qc.pages.PaymentOrder.CreatePaymentOrder;
import org.example.QC.BaseTest;
import Utilits.DataFaker;
import org.testng.annotations.Test;

public class CaptureTest extends BaseTest {
    DataFaker faker;
    CaptureProcess captureProcess;
    CreatePaymentOrder createPaymentOrder;
    @Test
    public void ValidCaptureProcess() throws InterruptedException {
        CaptureProcess captureProcess  = new CaptureProcess(driver);
        CreatePaymentOrder createPaymentOrder = new CreatePaymentOrder(driver);
        loginWithValidDataInFrench();
        Thread.sleep(10000);
        createPaymentOrder.Payment();
        captureProcess.scrollToCaptureButton();
        Thread.sleep(1000);
        captureProcess.clickCaptureButton();
        Thread.sleep(1000);
        captureProcess.doCaptureProcess();
        Thread.sleep(10000);
        }
}
