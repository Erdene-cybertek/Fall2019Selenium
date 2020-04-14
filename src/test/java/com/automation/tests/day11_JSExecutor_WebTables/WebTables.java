package com.automation.tests.day11_JSExecutor_WebTables;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {

    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createADrive("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }

    @Test
    public void getColumnNames(){
        List <String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        // just to print
        for (WebElement columnName : columnNames){
            System.out.println(columnName.getText());
        }

        Assert.assertEquals(BrowserUtilities.getTextFromWebElements(columnNames), expected);
    }

    @Test
    public void verifyRowCount(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        // if we will get a size of this collection, it automatically equals to number of elements
        // expected - 4 rows in the table
        Assert.assertEquals(rows.size(), 4);
    }

    /**
     * To get specific colum, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn(){
    // td[5] - column with links
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtilities.getTextFromWebElements(links));
    }

    @Test
    public void deleteRowTest(){
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();
        BrowserUtilities.wait(2);

        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();

        Assert.assertEquals(rowCount, 3);

        List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));
        Assert.assertTrue(emails.isEmpty());
    }

    /**
     * Let's write a function that will return column index based on column name
     */
    @Test
    public void getColumnIndexByName(){
        String columnName = "Email";

        List <WebElement> columnNames = driver.findElements(By.xpath("//table[2]//th"));

        int index = 0;
        for (int x = 0; x < columnNames.size(); x++) {

            String actualColumnName = columnNames.get(x).getText();

            System.out.println(String.format("Column name %s, position %s", actualColumnName, x));

            if (actualColumnName.equals(columnName)) {
                index = x + 1;
                break;
            }
        }
        Assert.assertEquals(index, 3);

    }

    @Test
    public void getSpecificCell(){


        String expected = "http://www.jsmith.com";

        int row = 1 ;
        int column = 5;

        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column + "]";

        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(), expected);



    }



    @AfterMethod
    public void teardown(){
        BrowserUtilities.wait(2);
        driver.quit();
    }
}

