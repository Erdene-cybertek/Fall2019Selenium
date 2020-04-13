package com.automation.tests.day11_JSExecutor;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyTitle(){
        String expected = "Practice";
        // we create javascriptexecutor object by casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // executeScript - this method executes javascript code
        // we provide js code as a string
        // return document.title - javascript code
        // document - represents HTML page
        String actual = (String) js.executeScript("return document.title"); // we can use .toString() at the end, instead of casting (String)

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void clickTest(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        // disable this click action, to perform it with js executor
        //       link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // after "" you can list webelements that will be used
        // as part of your javascript code
        // it's varargs, so you can list 0+
        // arguments - listed after ,
        // use index to get specific webelement
        // WebElement arguments = {element, link, link2};
        // from left - to right
        js.executeScript("arguments[0].click()", link);

        WebElement button6 = driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()", button6);
        BrowserUtilities.wait(2);

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals("Now it's gone!", result.getText());
    }

    @Test
    public void textInputTest(){
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtilities.wait(2);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginbtn = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // to get text from input box - read attribute "value"
        // to enter text - set attribute ''value
        //.setAttribute('value', 'text') - enter some text
        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginbtn);

        BrowserUtilities.wait(2);
        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

        Assert.assertEquals(subheader, expected);
    }

    @Test
    public void scrollToElement(){
        BrowserUtilities.wait(2);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        BrowserUtilities.wait(2);

    }


    @AfterMethod
    public void teardown(){
        BrowserUtilities.wait(2);
        driver.quit();
    }



}
