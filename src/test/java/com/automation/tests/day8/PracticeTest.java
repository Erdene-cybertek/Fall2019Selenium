package com.automation.tests.day8;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PracticeTest {

    private WebDriver driver;

    @Test
    public void loginTest(){
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Form Authentication")).click();

        driver.findElement(By.name("username")).sendKeys("tomsmith");

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        driver.findElement(By.id("wooden_spoon")).click();

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");



}

    @Test
    public void forgotPasswordTest(){
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
        BrowserUtilities.wait(1);
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtilities.wait(1);
        driver.findElement(By.name("email")).sendKeys("testemail@email.com");
        driver.findElement(By.id("form_submit")).submit();
        BrowserUtilities.wait(1);
        Assert.assertEquals(driver.findElement(By.name("confirmation_message")).getText(), "Your e-mail's been sent!");
        BrowserUtilities.wait(1);


    }

    @Test
    public void checkboxTest1(){
        driver.get("http://practice.cybertekschool.com");
        driver.manage().window().maximize();
        BrowserUtilities.wait(1);
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtilities.wait(1);
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        BrowserUtilities.wait(1);

        checkboxes.get(0).click(); // to click checkbox #1
        BrowserUtilities.wait(1);

        Assert.assertTrue(checkboxes.get(0).isSelected(), "Check box #1 is not selected!" );

    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        // How to handle ssl issues in selenium?
        // ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions = new ChromeOptions();
        // to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        // provide chromeOptions object into chromedriver constructor
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
