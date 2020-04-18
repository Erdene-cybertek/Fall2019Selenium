package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxes {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(1);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        for (int x = 0; x< checkBoxes.size(); x++) {

        // if visible, eligible to click and not clicked yet
        if ( checkBoxes.get(x).isEnabled() && checkBoxes.get(x).isDisplayed() && (!checkBoxes.get(x).isSelected())){
            checkBoxes.get(x).click();
            System.out.println("check box : " + (x+1) + " clicked");
            } else {
            System.out.println("check box : " + (x+1) + " was not clicked");
            }
        }
        BrowserUtils.wait(1);

        driver.quit();
    }
}
