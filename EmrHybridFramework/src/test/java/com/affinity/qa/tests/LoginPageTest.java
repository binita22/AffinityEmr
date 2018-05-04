package com.affinity.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.affinity.qa.base.TestBase;
import com.affinity.qa.pages.AdminPage;
import com.affinity.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	AdminPage adminPage;
	
	public LoginPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OpenEMR Login");
	}
	
	@Test(priority=2)
	public void affinityImageLogoTest(){
		boolean flag = loginPage.validateLoginPageLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest(){
		adminPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
