package com.eBay.Testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.eBay.Pages.HomePage;
import com.eBay.Pages.LinkAccountsPage;
import com.eBay.Pages.SignInPage;
import com.eBay.Utilities.BaseTest;

public class AddItemToCart extends BaseTest{
	SignInPage signinPage;
	HomePage homePage;
	LinkAccountsPage linkAccountPage;

	//property values
	private static String siginUserName = propertyName("ebayUserName");
	private static String siginPassword = propertyName("ebayPassword");

	@Test
	public void addProductToCartPage() throws Exception{
		homePage=new HomePage(driver);
		signinPage=new SignInPage(driver);
		linkAccountPage=new LinkAccountsPage(driver);
		homePage.clickOnHamburgerMenu();
		homePage.clickOnSiginButton();
		signinPage.signinToEbay(siginUserName, siginPassword);
		linkAccountPage.clickOnNoThanks();
	}

}