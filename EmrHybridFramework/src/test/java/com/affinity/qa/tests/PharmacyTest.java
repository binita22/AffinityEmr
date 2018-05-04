package com.affinity.qa.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.affinity.qa.base.TestBase;
import com.affinity.qa.pages.AdminPage;
import com.affinity.qa.pages.LoginPage;
import com.affinity.qa.pages.PharmacyPage;
import com.affinity.qa.pages.PracticePage;
import com.affinity.qa.util.TestUtil;

public class PharmacyTest extends TestBase {
	LoginPage loginPage;
	AdminPage adminPage;
	PracticePage practicePage;
	PharmacyPage pharmacyPage;

	String sheetName = "pharmacy";

	public PharmacyTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		adminPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		adminPage.adminMouseHover();
		practicePage = new PracticePage();
		practicePage.clickPracticeTab();
		pharmacyPage = new PharmacyPage();
	}

	@DataProvider
	public Object[][] getAffinityTestData() {
		Object addPharmacyData[][] = TestUtil.getTestData(sheetName);
		return addPharmacyData;
	}

	@Test(priority = 1,dataProvider="getAffinityTestData")
	public void validateCreateNewPharmacy(String pharmacyName, String pharmacyAdd, String zipCode) {
		pharmacyPage.clickPharmacy();
		pharmacyPage.addNewPharmacy(pharmacyName, pharmacyAdd, zipCode);
	}
	

	/*
	 * //without using external testData
	 * 
	 * @Test(priority=1) public void validatCreateNewPharmacy(){
	 * pharmacyPage.clickPharmacy(); pharmacyPage.addNewPharmacy(
	 * "Binita Pharmacy", "Corona", "11345"); }
	 */
	@AfterMethod()
	public void tearDown() {
		driver.close();
	}
}