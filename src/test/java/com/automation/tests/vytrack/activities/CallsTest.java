package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsTest {

    private WebDriver driver;
    private Actions actions;
    private String URL = "https://qa2.vytrack.com/user/login";

    // correct credentials for storemanager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By activitiesBy = By.xpath("//*[@id='main-menu']/ul/li[5]/a/span");
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");




    @Test
    public void VerifyLogCallButton(){
        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);
        Assert.assertTrue(logCallBtnElement.isDisplayed());

    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(2);

        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();

        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Calls")).click();

        BrowserUtils.wait(2);
    }



    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
