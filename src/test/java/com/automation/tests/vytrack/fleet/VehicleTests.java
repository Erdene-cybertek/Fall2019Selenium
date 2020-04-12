package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//Static import of all ASSERTIONS
import static org.testng.Assert.*;


public class VehicleTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    // correct credentials for storemanager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By fleetBy = By.xpath("//*[@id='main-menu']/ul/li[2]/a/span");
    private By subtitleBy = By.xpath("//*[@id='container']/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1");
    private By pageNumberBy = By.cssSelector("input[type='number']"); // xpath - "//input[@type='number']"


    @Test
       public void VerifyPageSubtitle (){

        String actual = driver.findElement(subtitleBy).getText();
        String expected = "All Cars";
        assertEquals(actual,expected);
    }


    @Test (description = "verify page number")
    public void verifyPageNumber(){

        String expected = "1";
        String actual = driver.findElement(pageNumberBy).getAttribute("value");

        Assert.assertEquals(actual, expected);

    }



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtilities.wait(2);
        // driver.findElement(fleetBy).click();
        // Actions class is used for more advanced browser interactions
        Actions actions = new Actions(driver);
        // move to element instead of click
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        // perform - to execute command
        // every actions should end with perform()


        BrowserUtilities.wait(2);
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtilities.wait(2);

    }

    @AfterMethod
    public void teardonw() {
        // if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            // destroy driver object for sure
            driver = null;
        }
    }
}