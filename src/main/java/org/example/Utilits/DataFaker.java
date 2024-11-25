package org.example.Utilits;

import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataFaker {
    public final Faker faker;
    public DataFaker(WebDriver driver) {
        faker = new Faker();
    }
    public String fullName(){return faker.name().fullName();}
    public String address(){
        return faker.address().streetAddress();
    }
    public String mobileNumber() {
        Random random = new Random();
        // Ensure the first digit is non-zero
        StringBuilder mobileNumber = new StringBuilder("01");

        // Append 9 more random digits to make it 11 digits
        for (int i = 0; i < 9; i++) {
            mobileNumber.append(random.nextInt(10));
        }

        return mobileNumber.toString();
    }


}
