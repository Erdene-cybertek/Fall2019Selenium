package com.automation.tests.day12_Synchronization;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {
    private WebDriver driver;

    @BeforeMethod
    private void setup(){
        driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void waitTest(){
        driver.findElement(By.tagName("button")).click();
        WebElement finishElement = driver.findElement(By.id("finish"));
        System.out.println(finishElement.getText());
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }
}
