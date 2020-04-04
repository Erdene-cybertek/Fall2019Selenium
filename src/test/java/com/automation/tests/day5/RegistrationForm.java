package com.automation.tests.day5;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RegistrationForm {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/registration_form");
        BrowserUtilities.wait(5);

        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("username")).sendKeys("Johnsmith");
        driver.findElement(By.name("email")).sendKeys("johnsmith@gmail.com");
        driver.findElement(By.name("password")).sendKeys("1234567890");
        driver.findElement(By.name("phone")).sendKeys("907-907-9007");

        List <WebElement> genders = driver.findElements(By.name("gender"));  // radio button male/female/other
        genders.get(1).click();

        driver.findElement(By.name("birthday")).sendKeys("01/01/2020");
        driver.findElement(By.id("inlineCheckbox2")).click();

        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtilities.wait(2);



        driver.quit();


    }
}
