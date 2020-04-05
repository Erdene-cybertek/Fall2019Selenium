package com.automation.tests.day6;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelectDropdown {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtilities.wait(2);

        driver.findElement(By.id("dropdownMenuLink")).click(); // expand to dropdown options

        BrowserUtilities.wait(1);

       // lets loop
        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));

        for (WebElement eachlink: allLinks){
            System.out.println(eachlink.getText()+" : "+eachlink.getAttribute("href"));
        }


        driver.findElement(By.linkText("Amazon")).click();
        // <a class="dropdown-item" href="https://www.amazon.com/">Amazon</a>





        BrowserUtilities.wait(2);
        driver.quit();


    }
}
