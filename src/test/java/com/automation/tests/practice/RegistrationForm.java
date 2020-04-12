package com.automation.tests.practice;

import com.automation.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String URL = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneBy = By.name("phone");

    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");

    private By birthdayBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobtitleBy = By.name("job_title");

    private By cplusplusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javaScriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");

    private By signUpBy = By.id("wooden_spoon");

    /////////////////////////////////////////////////////////////////////////////

    @Test
    public void test1(){
    driver.findElement(firstNameBy).sendKeys("Patrick");
    driver.findElement(lastNameBy).sendKeys("White");
    driver.findElement(userNameBy).sendKeys("testuser");
    driver.findElement(emailBy).sendKeys("testuser@gmail.com");
    driver.findElement(passwordBy).sendKeys("123456789");
    driver.findElement(phoneBy).sendKeys("571-000-0000");

    driver.findElement(maleBy).click();

    driver.findElement(birthdayBy).sendKeys("01/01/1990");

    Select departmentSelect = new Select(driver.findElement(departmentBy));
    departmentSelect.selectByVisibleText("Department of Agriculture");

    Select jobTitleSelect = new Select(driver.findElement(jobtitleBy));
    jobTitleSelect.selectByVisibleText("SDET");

    driver.findElement(javaBy).click();
    driver.findElement(signUpBy).click();

    BrowserUtilities.wait(2);

    String expected = "You've successfully completed registration!";
    String actual = driver .findElement(By.tagName("p")).getText();
    Assert.assertEquals(actual,expected);



    }




    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79.").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

}

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}