package io.paysky.qc.pages.HomeDashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChangeLanguage {
    public WebDriver driver;
    public ChangeLanguage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickNavBarDropDown(){
        WebElement navBarDropDown = driver.findElement(By.id("navbarDropdown"));
        navBarDropDown.click();
    }
    public void selectFrench(){
        WebElement frenchLanguage = driver.findElement(By.linkText("French"));
        frenchLanguage.click();
    }
    public void selectEnglish(){
        WebElement englishLanguage = driver.findElement(By.linkText("English"));
        englishLanguage.click();
    }



}
