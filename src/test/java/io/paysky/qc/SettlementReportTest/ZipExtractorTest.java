package io.paysky.qc.SettlementReportTest;

import org.testng.annotations.Test;

import static io.paysky.qc.pages.SettlementReport.ZipExtractor.unzip;

public class ZipExtractorTest {
    @Test
    public void unzipFile() {
        String zipPath = "C:/Users/RandaKhaled/Downloads";
        String extractTo = "C:/Users/RandaKhaled/Downloads/unzip";
        unzip(zipPath, extractTo);


    }
}
