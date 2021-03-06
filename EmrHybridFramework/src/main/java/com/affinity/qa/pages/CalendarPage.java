package com.affinity.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.affinity.qa.base.TestBase;

public class CalendarPage extends TestBase {
@FindBy(css="#datePicker")
WebElement calendarLabel;
@FindBy(css="#theform > a:nth-child(3)")
WebElement newAppointment;

public CalendarPage(){
	PageFactory.initElements(driver, this);
}
public boolean verifyCalendarLabel(){
	return calendarLabel.isDisplayed();
}
public boolean appointmentLabel(){
	return newAppointment.isDisplayed();
}
}
