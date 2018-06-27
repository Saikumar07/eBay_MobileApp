package com.eBay.Testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eBay.Pages.HomePage;
import com.eBay.Pages.LinkAccountsPage;
import com.eBay.Pages.SignInPage;
import com.eBay.Utilities.BaseTest;

public class PurchaseProduct extends BaseTest{
	SignInPage signinPage;
	HomePage homePage;
	LinkAccountsPage linkAccountPage;
	SoftAssert assertion;

	//property values
	private static String siginUserName = propertyName("ebayUserName");
	private static String siginPassword = propertyName("ebayPassword");
	
	//1st Testcase
	//1.Login to ebay
	//2.verify login successfully or not
	@Test(priority = 1)
	public void signInToeBay() throws Exception{
		System.out.println("Testcase 1");
		assertion=new SoftAssert();
		homePage=new HomePage(driver);
		signinPage=new SignInPage(driver);
		linkAccountPage=new LinkAccountsPage(driver);
		homePage.clickOnHamburgerMenu();
		homePage.clickOnSiginButton();
		signinPage.signinToEbay(siginUserName, siginPassword);
		linkAccountPage.clickOnNoThanks();
		homePage.clickOnHamburgerMenu();
		boolean userProfileImage=homePage.verifyUserProfileImage();
		assertion.assertEquals(userProfileImage, true, "user profile is not displaying");
		assertion.assertAll();
	}

	@Test(priority = 2, dependsOnMethods = "signInToeBay")
	public void purchaseTheProduct() throws Exception{
		System.out.println("Testcase 2");
		assertion=new SoftAssert();
		homePage.clickOnHomeButton();
		homePage.selectProduct();
		homePage.clickBuyItNow();
		homePage.reviewButton();
		homePage.proceedToPayButton();
		homePage.clickOnCreditCard();
		boolean payNowButton=homePage.verifyPayNowIsDisplayed();
		assertion.assertEquals(payNowButton, true, "pay now button is not displaying");
		assertion.assertAll();
		//Info: To purchase we have to give valid cc details so I can't move to further
	}

}