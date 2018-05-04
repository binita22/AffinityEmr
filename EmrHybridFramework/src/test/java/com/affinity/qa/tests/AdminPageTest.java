package com.affinity.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.affinity.qa.base.TestBase;
import com.affinity.qa.pages.AdminPage;
import com.affinity.qa.pages.CalendarPage;
import com.affinity.qa.pages.LoginPage;
import com.affinity.qa.pages.MessagePage;


public class AdminPageTest extends TestBase {
	LoginPage loginPage;
	AdminPage adminPage;
	CalendarPage calendarPage;
	MessagePage messagePage;

	public AdminPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		adminPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		calendarPage = new CalendarPage();
		messagePage = new MessagePage();
	}
	
	@Test(priority=1,enabled=false)
	public void verifyHomePageTitleTest(){
		String adminPageTitle = adminPage.verifyHomePageTitle();
		Assert.assertEquals(adminPageTitle, "OpenEMR", "Admin page title not match");
		
	}
	@Test(priority=2,enabled=false)
	public void verifyUserNameTest(){
	Assert.assertTrue(adminPage.verifyCorrectUser());			
	}
	@Test(priority=3)
	public void verifyCalendarLinkTest(){
		calendarPage=adminPage.clickOnCalendar();
	}
	
	@Test(priority=4)
	public void verifyMessageLinkTest(){
		messagePage=adminPage.clickOnMessage();
	}
	
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}

}
