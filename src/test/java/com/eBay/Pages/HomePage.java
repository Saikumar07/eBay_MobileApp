package com.eBay.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.appium.java_client.AppiumDriver;

import com.eBay.Utilities.BaseTest;
import com.eBay.Utilities.PageObject;

public class HomePage extends PageObject {

	public HomePage(AppiumDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//android.widget.ImageButton[contains(@resource-id,'home')]")
	private WebElement HamburgerMenu;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'logo')]")
	private WebElement SignIn;

	//Methods
	//click on hamburger menu in homepage
	public void clickOnHamburgerMenu() throws Exception{
		BaseTest.click(HamburgerMenu);
	}

	//click on sigin button
	public void clickOnSiginButton(){
		BaseTest.click(SignIn);
	}

}
