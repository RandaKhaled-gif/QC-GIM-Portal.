package org.example.Tests;

import com.opencsv.exceptions.CsvException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Pages.LoginPage;
import org.example.Utilits.CSVUtilits;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginDataTest {
    WebDriver driver;
    LoginPage loginPage ;
    @BeforeTest
    public void Setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        driver.get("https://portal-uat.gimpay.org/Portal/Account/Login");
    }
    @DataProvider(name = "LoginDataCSV")
    public Object[][] getLoginDataFromCSV() throws IOException, CsvException {
        String filePath = "src/test/resources/LoginData.csv";
        List<String[]> csvData = CSVUtilits.readCSV(filePath);
        Object[][] data = new Object[csvData.size()][2];

        for (int i = 2 ; i < csvData.size() ; i++){
            data[i][0] = csvData.get(i)[0];
            data [i][1] = csvData.get(i)[1];
        }
      return data;
    }
    @Test(dataProvider = "LoginDataCSV")
    public void TestLoginWithDataFromCSV(String username , String password){
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickSendOtpButton();
        loginPage.enterOtp("1111");
        loginPage.clickSignInButton();
    }
}
