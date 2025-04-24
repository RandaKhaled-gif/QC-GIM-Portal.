package io.paysky.qc.SettlementReportTest;
import org.testng.annotations.Test;
import static io.paysky.qc.pages.SettlementReport.FileNameValidator.validateFilesInFolder;

public class FileNameValidatorTest {
    @Test
    public void validName() {
        String folderPath = "C:/Users/RandaKhaled/Downloads/unzip";
        validateFilesInFolder(folderPath);
    }

}
