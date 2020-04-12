package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Static import of all ASSERTIONS
import static org.testng.Assert.*;

public class loginPageTests {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    // correct credentials for storemanager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.xpath("//*[@id='login-form']/fieldset/div[1]/div");



    @Test (description = "verify that warning message displays when user enters invalid username.")
    public void invalidUsername (){
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("USerUser123", Keys.ENTER);
        BrowserUtilities.wait(2);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual,expected);
    }

    @Test (description = "Login as store manager and verify that title is equals to Dashboard")
    public void loginAsStoreManager (){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtilities.wait(2);

        String expected = "Dashboard";
        String actual = driver.getTitle();
        assertEquals(actual,expected, "Page title is not correct!");
    }


    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardonw(){
        // if webdriver object alive
        if (driver != null){
            //close browser, close session
            driver.quit();
            // destroy driver object for sure
            driver = null;
        }
    }
}
