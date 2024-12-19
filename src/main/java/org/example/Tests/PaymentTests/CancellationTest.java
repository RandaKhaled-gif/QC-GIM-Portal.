package org.example.Tests.PaymentTests;

import org.example.Pages.PaymentProcess.CancellationProcess;
import org.example.Tests.BaseTest;
import org.example.Utilits.DataFaker;
import org.testng.annotations.Test;

public class CancellationTest extends BaseTest {
    DataFaker faker;
    CancellationProcess cancellationProcess;
    @Test
    public void ValidCancellationProcess() throws InterruptedException {
        DataFaker faker = new DataFaker(driver);
        CancellationProcess cancellationProcess  = new CancellationProcess(driver);
        loginWithValidData();
        cancellationProcess.clickReportsTab();
        Thread.sleep(1000);
        cancellationProcess.clickTransactionReportSubTab();
        Thread.sleep(10000);
        cancellationProcess.clickSelectSearchParameter();

    }

}
