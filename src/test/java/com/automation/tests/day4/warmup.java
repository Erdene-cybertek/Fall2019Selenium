package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class warmup {

    public static void main(String[] args) throws Exception {

        ebayTest();

        amazonTest();

        wikipediaTest();
    }

    public static void ebayTest() throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");
        Thread.sleep(2000);
        driver.findElement(By.name("_nkw")).sendKeys("ipad");
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);
        String numberOfResult = driver.findElement(By.className("srp-controls__count-heading")).getText().split(" ")[0];  // ehnii toog salgaj avch bna Array ashiglan
        System.out.println(numberOfResult);

        driver.quit();

    }

    public static void amazonTest() throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER); // haih ugee bicheel shuud enter darna gesen ug Easy
        String title = driver.getTitle();
        if (title.contains("iphone")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }

    public static void wikipediaTest() throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(2000);
        driver.findElement(By.id("searchInput")).sendKeys("Selenium (software)", Keys.ENTER);
        if (driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        driver.quit();

    }
}
