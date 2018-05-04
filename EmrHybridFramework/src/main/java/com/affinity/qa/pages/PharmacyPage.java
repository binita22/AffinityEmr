package com.affinity.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.affinity.qa.base.TestBase;

public class PharmacyPage extends TestBase  {
@FindBy(xpath="//span[contains(text(),'Add a Pharmacy')]")
WebElement addPharmacyButton;

@FindBy(name="name")
WebElement pharmacyName;

@FindBy(name="address_line1")
WebElement pharmacyAdd;

@FindBy(name="zip")
WebElement zip;

@FindBy(xpath="bodtd > a:nth-child(1) > span")
WebElement savePharmacy;

public PharmacyPage(){
	PageFactory.initElements(driver, this);
}

public void clickPharmacy(){	
	addPharmacyButton.click();
}

public void addNewPharmacy(String pn,String pa, String pz){
	pharmacyName.sendKeys(pa);
	pharmacyAdd.sendKeys(pa);
	zip.sendKeys(pz);
	savePharmacy.click();

}

}
