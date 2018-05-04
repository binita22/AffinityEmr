package com.affinity.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.affinity.qa.base.TestBase;

public class LoginPage extends TestBase  {
//Page Factory - Object Repository
	@FindBy(id="authUser")
	WebElement userName;
	
	@FindBy(id="clearPass")
	WebElement password;
	
	@FindBy(css="#login_form > div:nth-child(2) > div:nth-child(1) > div:nth-child(5) > button")
	WebElement submitButton;
	
	@FindBy(css="#login_form > div:nth-child(1) > div > div > div > img")
	WebElement openEmrLogo;
	//Initializing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions - different features available on login page
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean validateLoginPageLogo(){
		return openEmrLogo.isDisplayed();
	}
	public AdminPage login(String un, String pw){
		userName.sendKeys(un);
		password.sendKeys(pw);
		submitButton.click();
		return new AdminPage();
	}
}