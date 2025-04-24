package io.paysky.qc.SettlementReportTest;

import io.paysky.qc.pages.HomeDashboard.Home;
import io.paysky.qc.pages.MerchantManagement.AddMerchant;
import io.paysky.qc.pages.SettlementReport.LisClearingFile;
import org.example.QC.BaseTest;
import org.testng.annotations.Test;

public class LisClearingFileTest extends BaseTest {
    Home homeDashboard;
    LisClearingFile lisClearingFile;

    @Test
    public void validDownloadLISClearingFile() throws InterruptedException {
        homeDashboard = new Home(driver);
        lisClearingFile = new LisClearingFile(driver);
        loginWithValidDataInFrench();
        Thread.sleep(20000);
        homeDashboard.clickSettlementReportTab();
        Thread.sleep(5000);
        lisClearingFile.clickBankDDL();
        Thread.sleep(700);
        lisClearingFile.searchAboutBank();
        Thread.sleep(700);
        lisClearingFile.selectBank();
        Thread.sleep(700);
        lisClearingFile.clickSettlementTypeDDL();
        Thread.sleep(700);
        lisClearingFile.searchAboutSettlementType();
        Thread.sleep(700);
        lisClearingFile.selectType();
        Thread.sleep(700);
        lisClearingFile.clickSpace();
        Thread.sleep(1000);
        lisClearingFile.changeDate();
        Thread.sleep(1000);
        lisClearingFile.clickDownloadButton();
        Thread.sleep(5000);
        homeDashboard.clickExportedFilesDownload();
        Thread.sleep(1000);
        homeDashboard.clickDownloadExported();
        Thread.sleep(1000);
    }
}
