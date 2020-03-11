package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(5000);

        // every window has some id, this id calls window handle
        // based on window handle, we can switch in between windows
        String windowHandle = driver.getWindowHandle();                 // window ID gargaj irne
        System.out.println(windowHandle);

        Set<String> windowHandles = driver.getWindowHandles();          // windowHandle(s) olon ID gargana
        System.out.println(windowHandles);
        System.out.println("BEFORE SWITCH : " + driver.getCurrentUrl());

        for (String windowId: windowHandles){                                              // 2 window hoorond shiljine
            if (!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("AFTER SWITCH : " + driver.getCurrentUrl());
        driver.close();
    }

    /**
     * This method helps to switch in between windows on page title
     */
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver) {    // 2s deesh window neegsen uyd ashiglana
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows){
            if (driver.getTitle().equals(pageTitle)){
                break;
            }

        }
    }
}
