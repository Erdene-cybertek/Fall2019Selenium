package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select selectState = new Select(driver.findElement(By.id("state")));
        selectState.selectByIndex(9);

        BrowserUtils.wait(2);

        selectState.selectByIndex(selectState.getOptions().size()-1); // selecting last index



        BrowserUtils.wait(2);
        driver.quit();
    }
}
