package com.eBay.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import com.eBay.Utilities.BaseTest;
import com.eBay.Utilities.PageObject;


public class SignInPage extends PageObject {

	public SignInPage(AppiumDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//*[@id='edit_text_username']")
	private WebElement UserName;
	
	@FindBy(how = How.XPATH, using = "//*[@id='edit_text_password']")
	private WebElement Password;
	
	@FindBy(how = How.XPATH, using = "//*[@text='SIGN IN']")
	private WebElement SignIn;
	
	@FindBy(how = How.XPATH, using = "//*[@text='NO THANKS']")
	private WebElement NoThanks;
	
	//Metthods
	//Login to ebay
	public void signinToEbay(String userName,String password){
		UserName.sendKeys(userName);
		Password.sendKeys(password);
		BaseTest.click(SignIn);
	}
}