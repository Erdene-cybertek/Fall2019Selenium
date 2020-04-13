package com.automation.tests.day8_TestNG;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {

    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtilities.wait(2);
        List<WebElement> searchItems = driver.findElements(By.tagName("title"));
        for (WebElement eachSearchItem: searchItems){
            String variable = eachSearchItem.getText();
            // if there is a a text - print it
            if(!variable.isEmpty()){
                System.out.println(variable);
                // verify that every search result contains java
                // Assert.assertTrue(variable.equalsIgnoreCase("java"));
            }
        }

    }

    @Test (description = "Search for Java book on amazon")
    public void amazonSearchTest(){
        driver.get("https://www.amazon.com/");
        BrowserUtilities.wait(2);

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        BrowserUtilities.wait(2);

        List<WebElement> searchItems = driver.findElements(By.tagName("h2"));

        searchItems.get(0).click();
        BrowserUtilities.wait(2);

        WebElement productTitle = driver.findElement(By.id("productTitle"));
        String producTitleString = productTitle.getText();
        System.out.println(producTitleString);

        Assert.assertTrue(producTitleString.contains("Java"));




    }
    @BeforeMethod
    public void setup(){
        //setup webdriver
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        // close browser and destroy driver object
        driver.quit();
    }
}
