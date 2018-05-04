package com.affinity.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.affinity.qa.base.TestBase;

public class AdminPage extends TestBase {
@FindBy(css="#username > span:nth-child(1)")
WebElement userNameLabel;

@FindBy(xpath="//div[contains(text(),'Calendar')]")
WebElement calendar;

@FindBy(xpath="//div[contains(text(),'Message')]")
WebElement message;

//Initializing the Page Objects:
public AdminPage(){
	PageFactory.initElements(driver, this);
}

public boolean verifyCorrectUser(){
	return userNameLabel.isDisplayed();
}
public String verifyHomePageTitle(){
	return driver.getTitle();
	
}
public CalendarPage clickOnCalendar(){
	calendar.click();
	return new CalendarPage();
}
public MessagePage clickOnMessage(){
	message.click();
	return new MessagePage();
}
public void adminMouseHover(){
	Actions action = new Actions(driver);
	WebElement administration = driver.findElement(By.xpath("//div[contains(text(),'Administration')]"));
	action.moveToElement(administration).build().perform();	
}


}