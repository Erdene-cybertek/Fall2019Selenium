package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        //create object webElement
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        // provide webElement object into constructor
        Select selectDropdown = new Select(dropdown);
        //select visible text
        selectDropdown.selectByVisibleText("Option 2");

        BrowserUtils.wait(1);
        selectDropdown.selectByVisibleText("Option 1");

        //
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectDay.selectByVisibleText("1");
        selectMonth.selectByVisibleText("April");
        selectYear.selectByVisibleText("2019");

        //select all months one by one - Loop
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachMonth: months){
            //get the month name and select based on that
            selectMonth.selectByVisibleText(eachMonth.getText()); // selecting each month 1by1
            System.out.println(eachMonth.getText()); // printing
        }

        Select selectByState = new Select(driver.findElement(By.id("state")));
        selectByState.selectByVisibleText("Virginia");
        BrowserUtils.wait(1);

        String selected = selectByState.getFirstSelectedOption().getText();
        if (selected.equals("Virginia")){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
        }

        //Let's loop
        List<WebElement> states = selectByState.getOptions();
        for (WebElement eachState: states){
            selectByState.selectByVisibleText(eachState.getText()); // selecting each text 1by1
            System.out.println(eachState.getText()); // printing each state 1 by 1
        }



        BrowserUtils.wait(1);
        driver.quit();


    }
}
