package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText_MultipleOption {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

        Select selectByLanguages = new Select(driver.findElement(By.name("Languages")));
        boolean isMultiple = selectByLanguages.isMultiple();
        System.out.println(isMultiple);
        selectByLanguages.selectByVisibleText("Java");
        selectByLanguages.selectByVisibleText("JavaScript");
        selectByLanguages.selectByVisibleText("C#");

        // let's get all selected options
        List<WebElement> selectedLanguages = selectByLanguages.getAllSelectedOptions();

        for (WebElement eachSelectedLanguage: selectedLanguages){
            System.out.println(eachSelectedLanguage.getText());
        }

        BrowserUtils.wait(2);

        // How to De-select?
        selectByLanguages.deselectByVisibleText("C#");
        BrowserUtils.wait(1);
        selectByLanguages.deselectAll();


        BrowserUtils.wait(1);
        driver.quit();


    }
}



