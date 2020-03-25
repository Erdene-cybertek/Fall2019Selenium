package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().version("80").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(2000);

        // how to collect all links from the page?

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for(WebElement link: links) {
            System.out.println(link.getText());
            System.out.println(link.getAttribute("href"));
            System.out.println();

        }

        // the we can click every link and go back window

        for (int i = 1; i < links.size(); i++) {            // i = 0 geed ehelbel Home-ruu orno tgd go back hiij bolohgui baigaa uchraas 1s ehellee

            driver.findElements(By.tagName("a")).get(i).click();
            driver.navigate().back();

        }

        driver.quit();
    }
}

