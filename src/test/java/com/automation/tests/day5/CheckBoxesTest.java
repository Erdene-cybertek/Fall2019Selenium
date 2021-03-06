package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxesTest {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(1);

        // Task
        // Verify that 1st check box is not selected & 2nd is selected

         List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
         if (!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
              System.out.println("TEST PASSED");
         } else {
              System.out.println("TEST FAILED");
         }

         BrowserUtils.wait(1);

         // let's click on the first checkbox and verify it's clicked
        // checkBoxes.get(0).click();

        WebElement checkbox1 = checkBoxes.get(0); // to get 1st checkbox
        checkbox1.click(); // click on it

        if (checkbox1.isSelected()){
            System.out.println("TEST PASSED");
            System.out.println("Checkbox #1 is selected");
        } else {
            System.out.println("TEST FAILED");
            System.out.println("Checkbox #1 is NOT selected");
        }


        driver.quit();
    }
}
