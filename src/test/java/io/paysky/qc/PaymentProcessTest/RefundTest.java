package io.paysky.qc.PaymentProcessTest;

import io.paysky.qc.pages.PaymentOrder.CaptureProcess;
import io.paysky.qc.pages.PaymentOrder.CreatePaymentOrder;
import io.paysky.qc.pages.PaymentOrder.RefundProcess;
import org.example.QC.BaseTest;
import Utilits.DataFaker;
import org.testng.annotations.Test;

public class RefundTest extends BaseTest {
    RefundProcess refundProcess;
    CreatePaymentOrder createPaymentOrder;
    @Test
    public void ValidRefundProcess() throws InterruptedException {
        CaptureProcess captureProcess  = new CaptureProcess(driver);
        RefundProcess refundProcess  = new RefundProcess(driver);
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
        refundProcess.clickRefundButton();
        Thread.sleep(1000);
        refundProcess.doRefundProcess();
        Thread.sleep(10000);
    }
}
