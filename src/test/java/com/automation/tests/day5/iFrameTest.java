package com.automation.tests.day5;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class iFrameTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtilities.wait(1);

        // before looking for that element, we need to jump to that frame
        driver.switchTo().frame("mce_0_ifr");
        // now, this content will be visible
        WebElement inputText = driver.findElement(By.id("tinymce"));
        System.out.println(inputText.getText());

        BrowserUtilities.wait(1);

        inputText.clear();
        inputText.sendKeys("Hello, World!");

        BrowserUtilities.wait(1);

        // exit from the frame
        driver.switchTo().defaultContent();

        WebElement heading = driver.findElement(By.tagName("h3"));
        System.out.println(heading.getText());

         driver.quit();
    }

}
