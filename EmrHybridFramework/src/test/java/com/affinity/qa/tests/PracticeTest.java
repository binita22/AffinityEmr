package com.affinity.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.affinity.qa.base.TestBase;
import com.affinity.qa.pages.AdminPage;
import com.affinity.qa.pages.LoginPage;
import com.affinity.qa.pages.PharmacyPage;
import com.affinity.qa.pages.PracticePage;


public class PracticeTest extends TestBase {
	LoginPage loginPage;
	AdminPage adminPage;
	PracticePage practicePage;
	PharmacyPage pharmacyPage;
	public PracticeTest(){
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		adminPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		practicePage = new PracticePage();
		adminPage.adminMouseHover();
		pharmacyPage = new PharmacyPage();
	}
	
	@Test(priority=1)
	public void verifyPracticePageTest(){
		practicePage.clickPracticeTab();
		pharmacyPage=practicePage.landToPharmacyPage();

	}
	@Test(priority=2)
	public void verifyPracticePage(){
		Assert.assertEquals(practicePage.verifyPracticePage(),"http://demo.openemr.io/openemr/interface/main/tabs/main.php","Unable to navigate to practice page");
	}
	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
