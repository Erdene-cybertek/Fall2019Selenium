package com.automation.tests.day2;

import com.sun.java.util.jar.pack.DriverResource;
import com.sun.org.apache.xerces.internal.dom.DeferredEntityReferenceImpl;
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

        for (String windowId: windowHandles){
            if (!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }
        }
        System.out.println("AFTER SWITCH : " + driver.getCurrentUrl());
        driver.close();
    }
}
