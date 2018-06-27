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
	
	@Test(priority = 1)
	public void signInToeBay() throws Exception{
		System.out.println("Testcase 1");
		assertion=new SoftAssert();
		homePage=new HomePage(driver);
		signinPage=new SignInPage(driver);
		linkAccountPage=new LinkAccountsPage(driver);
		//After launch the application click on Hamburger menu
		homePage.clickOnHamburgerMenu();
		//Click on sigin button
		homePage.clickOnSiginButton();
		//Enter valid credentials in sigin page then click on sigin button
		signinPage.signinToEbay(siginUserName, siginPassword);
		//click on No Thanks button in Link accounts page
		linkAccountPage.clickOnNoThanks();
		//Click on Hamburger Menu after signin
		homePage.clickOnHamburgerMenu();
		//Verify profile  image is displaying after signin using assertion
		boolean userProfileImage=homePage.verifyUserProfileImage();
		assertion.assertEquals(userProfileImage, true, "user profile is not displaying");
		assertion.assertAll();
	}

	@Test(priority = 2, dependsOnMethods = "signInToeBay")
	public void purchaseTheProduct() throws Exception{
		System.out.println("Testcase 2");
		assertion=new SoftAssert();
		//click on HomeButton
		homePage.clickOnHomeButton();
		//select product to purchase in homepage
		homePage.selectProduct();
		//click buy it now button
		homePage.clickBuyItNow();
		//cliick on review button in quantity page
		homePage.reviewButton();
		//click on proceed to pay button
		homePage.proceedToPayButton();
		//select payment option like cc/dc
		homePage.clickOnCreditCard();
		//verify paynow button is displaying or not using assertion
		boolean payNowButton=homePage.verifyPayNowIsDisplayed();
		assertion.assertEquals(payNowButton, true, "pay now button is not displaying");
		assertion.assertAll();
		//Info: To purchase we have to give valid cc details so I can't move to further
	}

}