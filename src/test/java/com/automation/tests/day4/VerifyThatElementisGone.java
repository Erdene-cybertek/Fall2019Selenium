package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementisGone {

    /**
     *Interview Question
     *
     * how to check if element does not exist any more in the DOM (Document Object Model)
     *
     */

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().version("80").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        Thread.sleep(2000);

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        //if size is 0, that means no elements were found

        if(driver.findElements(By.id("disappearing_button")).size() == 0 ){
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        Thread.sleep(2000);
        // to find all buttons
        // make sure that you is findElements <=--- ending is important
        List<WebElement> buttons = driver.findElements(By.tagName("Button"));

        for (WebElement button: buttons){
            // click on every button
            button.click();
            Thread.sleep(2000);
        }

        driver.quit();

    }
}
