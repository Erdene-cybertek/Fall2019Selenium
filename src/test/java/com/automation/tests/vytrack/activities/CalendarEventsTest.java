package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtilities;
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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalendarEventsTest {

    private WebDriver driver;
    private Actions actions;
    private String URL = "https://qa2.vytrack.com/user/login";

    // correct credentials for storemanager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private By activitiesBy = By.xpath("//*[@id='main-menu']/ul/li[5]/a/span");
    private By createCalendarEventBtnCalendarBy = By.xpath("//*[@id='container']/div[2]/div/div/div[2]/div/a");
    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']"); // id* artaliin id ni refresh hiiheer oorchlogdood bgaa bolhoor * ashiglalaa
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");
    private By endDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_end-uid']");
    private By endTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_end-uid']");

    @Test
    public void VerifyCreateBtn(){
        WebElement createCalendarEventBtnElement = driver.findElement(createCalendarEventBtnCalendarBy);
        Assert.assertTrue(createCalendarEventBtnElement.isDisplayed());
    }

    @Test(description = "Default options")
    public void VerifyDefaultValues(){
        // Click on Create Calendar Event
        driver.findElement(createCalendarEventBtnCalendarBy).click();
        BrowserUtilities.wait(2);

        //Default owner name should be current user
        String currentUserName = driver.findElement(currentUserBy).getText().trim();;
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();;
        Assert.assertEquals(currentUserName, defaultOwnerName);

        //Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());

        //Default start date should be current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy")); //date time syntax = https://www.journaldev.com/17899/java-simpledateformat-java-date-format
        String actualDate = driver.findElement(startDateBy).getAttribute("value");

        Assert.assertEquals(actualDate, expectedDate);

        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a")); // Time Zone now() dotor ZoneId.of("GMT-7") tegehgui bol test fail hiine

        String actualTime = driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(actualTime, expectedTime);

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
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtilities.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtilities.wait(2);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}