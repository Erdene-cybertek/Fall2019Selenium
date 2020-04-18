package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * This class will be extended by page classes
 * And common webElements/locators can be stored here
 * Since navigation menu doesn't belong to particular page
 * We cannot really create a dedicated page class to store
 * elements from that menu
 */

public abstract class AbstractPageBase {

    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, 25);

    @FindBy(css = "#user-menu > a")
    protected WebElement currentUser;

    public AbstractPageBase() {
        PageFactory.initElements(driver, this);
    }


    public String getCurrentUserName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }


    /**
     * Method for vytrack navigation. Provide tab name and module name to navigate
     * @param tabName, like Dashboards, Fleet or Customers
     * @param moduleName, like Vehicles, Vehicles Odometer and Vehicles Costs
     */
    public void navigateTo(String tabName, String moduleName) {
        String tabNameXpath = "//span[@class='title title-level-1' and contains(text(),'" + tabName + "')]";
        String moduleXpath = "//span[@class='title title-level-2' and text()='" + moduleName + "']";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));
        WebElement moduleElement = driver.findElement(By.xpath(moduleXpath));

        Actions actions = new Actions(driver);

        BrowserUtils.wait(4);

        actions.moveToElement(tabElement).
                pause(2000).
                click(moduleElement).
                build().perform();

        //increase this wait time if still failing
        BrowserUtils.wait(4);
    }

    /**
     * Clicks on an element using JavaScript
     *
     *
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Scroll to element using JavaScript
     *
     *
     */
    public static void scrollTo(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * @param name screenshot name
     * @return path to the screenshot
     */
    public static String getScreenshot(String name) {
        //adding date and time to screenshot name, to make screenshot unique
        name = new Date().toString().replace(" ", "_").replace(":", "-") + "_" + name;
        //where we gonna store a screenshot
        String path = "";

        if (System.getProperty("os.name").toLowerCase().contains("mac")) {
            path = System.getProperty("user.dir") + "/test-output/screenshots/" + name + ".png";
        } else {
            path = System.getProperty("user.dir") + "\\test-output\\screenshots\\" + name + ".png";
        }

        System.out.println("OS name: " + System.getProperty("os.name"));
        System.out.println("Screenshot is here: " + path);
        //since our reference type is a WebDriver
        //we cannot see methods from TakesScreenshot interface
        //that's why do casting
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        //take screenshot of web browser, and save it as a file
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        //where screenshot will be saved
        File destination = new File(path);
        try {
            //copy file to the previously specified location
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }
}