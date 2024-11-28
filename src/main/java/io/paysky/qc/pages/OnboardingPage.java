package io.paysky.qc.pages;

import io.paysky.qc.GlobalProperties;
import io.paysky.qc.utilities.selenium.DriverFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OnboardingPage {

    private DriverFactory driverFactory;

    String propFileName = "config.properties";

    @Test
    public void setUp() {
        driverFactory = new DriverFactory();

        try {
            InputStream input = new FileInputStream("./src/main/resources/" + propFileName);
            GlobalProperties.global_propertoes.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }

    }

}
