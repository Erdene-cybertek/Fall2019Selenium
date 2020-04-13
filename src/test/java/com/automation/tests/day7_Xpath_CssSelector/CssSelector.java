package com.automation.tests.day7_Xpath_CssSelector;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelector {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtilities.wait(2);
        WebElement heading = driver.findElement(By.cssSelector(".h3"));
        WebElement home = driver.findElement(By.cssSelector(".nav-link"));
        WebElement button1 = driver.findElement(By.cssSelector("[onclick='button1()']"));
        WebElement button2 = driver.findElement(By.cssSelector("[name='button2']"));
        WebElement button3 = driver.findElement(By.cssSelector("[id^='button_']"));
        WebElement button4 = driver.findElement(By.cssSelector("[onclick='button4()']"));
        WebElement button5 = driver.findElement(By.cssSelector("[onclick='button5()']"));
        WebElement button6 = driver.findElement(By.cssSelector("#disappearing_button"));
        BrowserUtilities.wait(2);

        button1.click();
        BrowserUtilities.wait(2);
        button2.click();
        BrowserUtilities.wait(2);
        button3.click();
        BrowserUtilities.wait(2);
        button4.click();
        BrowserUtilities.wait(2);
        button5.click();
        BrowserUtilities.wait(2);
        button6.click();


        BrowserUtilities.wait(2);
        driver.quit();
    }
}
