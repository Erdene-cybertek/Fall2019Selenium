package com.automation.tests.day12_Synchronization;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWait {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADrive("chrome");

    }

    @Test
    public void waitForTitle(){
        driver.get("https://www.google.com/");

        WebDriverWait wait = new WebDriverWait(driver, 10 );
        // wait up to 10 seconds until title contains Google
        wait.until(ExpectedConditions.titleContains("Google"));

    }

    @AfterMethod
    public void teardown(){
        BrowserUtilities.wait(2);
        driver.quit();
    }
}
