package com.automation.tests.day10_Actions;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private RemoteWebDriver driver;

    @BeforeMethod
    public void setup(){
       // driver = DriverFactory.createADrive("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void scrollTest(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        // you need to cas if reference type is a WebDriver
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll down 250 pixels
        // x, y  coordinates
        //driver.executeScript("window.scrollBy(0, 250)");

        for (int i = 0; i < 10; i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtilities.wait(1);
        }

        BrowserUtilities.wait(2);
    }

    @Test
    public void ScrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtilities.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtilities.wait(1);
    }


}
