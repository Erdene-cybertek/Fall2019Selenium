package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CalendarEventsPage extends AbstractPageBase {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy (css = "[id^='date_selector_oro_calendar_event_form_end']")
    private WebElement endDate;

    @FindBy (css = "[id^='time_selector_oro_calendar_event_form_start-uid']")
    private WebElement startTime;

    @FindBy (css = "[id^='time_selector_oro_calendar_event_form_end-uid']")
    private WebElement endTime;

    @FindBy (className = "grid-header-cell__label")
    private List<WebElement> columnName;





    public void clickToCreateCalendarEvent() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
    }

    public String getOwnerName() {
        BrowserUtilities.waitForPageToLoad(10);
        // wait for element to be present in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("select2-chosen")));
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public String getStartDate() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        return startDate.getAttribute("value");
    }

    public String getEndDate() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endDate));
        return endDate.getAttribute("value");
    }

    public String getStartTime() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }

    public String getEndTime() {
        BrowserUtilities.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return endTime.getAttribute("value");
    }

    public List<String> getColumnNames(){
        BrowserUtilities.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("grid-header-cell__label")));
        return BrowserUtilities.getTextFromWebElements(columnName);
    }
}
