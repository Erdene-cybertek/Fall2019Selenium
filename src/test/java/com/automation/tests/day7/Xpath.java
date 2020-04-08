package com.automation.tests.day7;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {
    public static String userNameLocator = "//label[text()='Username']/following-sibling::input";
    public static String passwordLocator = "//label[text()='Password']/following-sibling::input";
    public static String login = "//button[contains(text(),'Login')]";
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/login");
        BrowserUtilities.wait(2);

        driver.findElement(By.xpath(userNameLocator)).sendKeys("tomsmith");
        driver.findElement(By.xpath(passwordLocator)).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath(login)).click();

        BrowserUtilities.wait(2);
        driver.quit();
    }
}
