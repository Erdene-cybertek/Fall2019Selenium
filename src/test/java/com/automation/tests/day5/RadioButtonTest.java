package com.automation.tests.day5;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonTest {

    public static void main(String[] args) {

        // WebDriverManager.chromedriver().version("80").setup();
       //  WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtilities.wait(1);

        WebElement blackButton = driver.findElement(By.id("black"));

        // if visible and eligible to click
        if (blackButton.isDisplayed() && blackButton.isEnabled()){
            System.out.println("clicked on black button");
            blackButton.click();
        } else {
            System.out.println("failed to click black button");
        }

        // how to we verify that button clicked
        // returns true, if button clicked
        if(blackButton.isSelected()){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }

        driver.quit();



    }
}
