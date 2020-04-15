package com.automation.tests.day13_UserProperties;

import com.automation.utilities.BrowserUtilities;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTest {

    @Test
    public void googleTest(){
        Driver.getDriver().get("https://www.google.com/");
        BrowserUtilities.wait(2);
        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Driver.closeDriver();
    }
}
