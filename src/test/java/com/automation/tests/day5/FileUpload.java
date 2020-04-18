package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(2);

        WebElement upload = driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.dir")+"/pom.xml";  // its folder from java

        String filePath2 = "C:/Users/tseri/Desktop/3-30-20 Nadir Recruiter call session.txt";

                System.out.println(filePath);

        upload.sendKeys(filePath2);

        driver.findElement(By.id("file-submit")).click(); // click to upload

        BrowserUtils.wait(2);

        driver.quit();
    }
}
