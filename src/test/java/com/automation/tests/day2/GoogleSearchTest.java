package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        Thread.sleep(2000);

        WebElement search = driver.findElement(By.name("q"));       // By.name("q") --> name="q" google search
        search.sendKeys("Java", Keys.ENTER);    // haih ugee bicheed taslal taviad Keys.ENTER geed shuud haina
        Thread.sleep(2000);

        WebElement news = driver.findElement(By.linkText("News"));      // google search ugee olsonii daraa "News" - ruu orohdoo text linkiig ni oruulna.
        news.click();
        Thread.sleep(2000);

        WebElement image = driver.findElement(By.linkText("Images"));
        image.click();



        // driver.quit();
    }
}
