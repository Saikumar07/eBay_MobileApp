package com.eBay.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.AppiumDriver;

import com.eBay.Utilities.BaseTest;
import com.eBay.Utilities.PageObject;

public class LinkAccountsPage extends PageObject {

	public LinkAccountsPage(AppiumDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@text='NO THANKS']")
	private WebElement NoThanks;
	
	//Methods
	//click on no thanks
	public void clickOnNoThanks(){
		BaseTest.click(NoThanks);
	}

}
