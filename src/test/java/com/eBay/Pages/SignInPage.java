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
	
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'edit_text_username')]")
	private WebElement UserName;
	
	@FindBy(how = How.XPATH, using = "//android.widget.EditText[contains(@resource-id,'edit_text_password')]")
	private WebElement Password;
	
	@FindBy(how = How.XPATH, using = "//android.widget.Button[contains(@resource-id,'button_sign_in')]")
	private WebElement SignIn;
	
	//Metthods
	//Login to ebay
	public void signinToEbay(String userName,String password){
		BaseTest.waitForElementIsVisible(UserName);
		UserName.sendKeys(userName);
		Password.sendKeys(password);
		BaseTest.click(SignIn);
		BaseTest.invisiblityOfElement();
	}
}