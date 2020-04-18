package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy (className = "select2-chosen")
    private WebElement owner;

    public String getOwnerName(){
        BrowserUtilities.waitForPageToLoad(10);
        // wait for element to be present in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreateCalendarEvent(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();

    }



}
