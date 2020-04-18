package com.automation.tests.day10_Actions;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {

    private WebDriver driver;
    private Actions actions;

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(2);

        WebElement img1 = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/img"));
        WebElement img2 = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/img"));
        WebElement img3 = driver.findElement(By.xpath("//*[@id='content']/div/div[3]/img"));

        // build() is needed when you have couple of actions
        // always end with perform()
        // pause(1000) - is like Thread.sleep(1000) but use it "actions"
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();

        // hover on the first image
        // verify that "name: user1" is displayed

        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5"));
        System.out.println(imgText1.getText());
        //verify that webelement that contains the test is visible
        Assert.assertTrue(imgText1.isDisplayed());

        // move to the second image

        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/h5"));
        System.out.println(imgText2.getText());
        Assert.assertTrue(imgText2.isDisplayed());


    }

    @Test
    public void iqueryMenuTest(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        // hover on "enabled"
        // hover on "downloads"
        // hover on "pdf

        WebElement enabled = driver.findElement(By.xpath("//*[@id='ui-id-3']"));
        WebElement downloads = driver.findElement(By.xpath("//*[@id='ui-id-4']"));
        WebElement pdf = driver.findElement(By.xpath("//*[@id='ui-id-5']"));


        BrowserUtils.wait(2);
        actions.moveToElement(enabled).
                pause(1000).
                moveToElement(downloads).
                pause(1000).
                click(pdf).
                build().perform();


    }

    @Test
    public void dragAndDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
        // click on accept cookies
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[4]/div[2]/div/button")).click();

        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        actions.dragAndDrop(moon, earth).perform();

        BrowserUtils.wait(2);


        String expected = "You did great!";
        String actual = earth.getText();
        Assert.assertEquals(actual, expected);

    }



    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADrive("chrome");
        actions = new Actions(driver);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();

    }
}
