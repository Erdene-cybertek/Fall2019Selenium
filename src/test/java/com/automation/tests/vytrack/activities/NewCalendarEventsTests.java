package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalendarEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class NewCalendarEventsTests extends AbstractTestBase {

    LoginPage loginPage = new LoginPage();
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Test
    public void defaultOptionsTest() {

        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();
        Assert.assertEquals(calendarEventsPage.getOwnerName(), calendarEventsPage.getCurrentUserName());

        String actualStartDate = calendarEventsPage.getStartDate();
        String expectedStartDate = DateTimeUtilities.getTodaysDate("MMM dd, yyyy");
        Assert.assertEquals(actualStartDate, expectedStartDate);
    }

    @Test
    public void timeDifferenceTest(){
        loginPage.login();
        calendarEventsPage.navigateTo("Activities", "Calendar Events");
        calendarEventsPage.clickToCreateCalendarEvent();

        String startTime = calendarEventsPage.getStartTime();
        String endTime = calendarEventsPage.getEndTime();
        String format = "h:mm a"; // format 5:15 AM

        long actual = DateTimeUtilities.getTimeDifference(startTime, endTime, format);

        Assert.assertEquals(actual, 1, "Time difference is not correct!");

    }

    @Test
}