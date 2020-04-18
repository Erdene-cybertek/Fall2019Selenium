package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(1);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        buttons.get(0).click(); // to click 1st button
        BrowserUtils.wait(1);
        String popupText = driver.switchTo().alert().getText(); // to get text from pop-up message
        System.out.println(popupText);
        driver.switchTo().alert().accept(); // to click ok

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if (expected.equals(actual)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
            System.out.println("Expected : " + expected);
            System.out.println("Actual : " + actual);
        }

        // ________________________________________________________________________
        BrowserUtils.wait(1);

        buttons.get(1).click();
        BrowserUtils.wait(1);
        driver.switchTo().alert().dismiss(); // to cancel

        String expected2 = "You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if (expected2.equals(actual2)){
            System.out.println("Test Passed!");
            System.out.println("Expected : " + expected2);
            System.out.println("Actual : " + actual2);
        } else {
            System.out.println("Test Failed!");
        }
        BrowserUtils.wait(2);

        // ________________________________________________________________________

        buttons.get(2).click();
        BrowserUtils.wait(1);

        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Hello, World!");
        alert.accept();

        String result = driver.findElement(By.id("result")).getText();

        if (result.endsWith("Hello, World!")){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        BrowserUtils.wait(1);
        driver.quit();
    }
}
