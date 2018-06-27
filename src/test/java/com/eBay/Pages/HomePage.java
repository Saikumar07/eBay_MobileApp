package com.eBay.Pages;

import java.util.List;

import org.openqa.selenium.By;
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

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'image_user_profile')]")
	private WebElement userProfileImage;

	@FindBy(how = How.XPATH, using = "//android.widget.CheckedTextView[@text='Home']")
	private WebElement Home;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'search_box')]")
	private WebElement search;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'search_complete_icon')]")
	private WebElement searchIcon;

	@FindBy(how = How.XPATH, using = "//android.widget.ImageView[contains(@resource-id,'watching_image')]")
	private WebElement selectFirstProduct;

	@FindBy(how = How.XPATH, using = "//android.widget.TextView[contains(@resource-id,'text')]")
	private WebElement selectDropDownText;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@content-desc='Buy It Now']")
	private WebElement buyItNow;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@text='Review']")
	private WebElement review;

	@FindBy(how = How.XPATH, using = "//android.widget.Button[@resource-id='proceedToPay']")
	private WebElement proceedToPay;

	@FindBy(how = How.XPATH, using = "//android.view.View[@text='Credit Card']")
	private WebElement creditCard;
	
	@FindBy(how = How.XPATH, using = "//android.widget.Button[@text='Pay Now']")
	private WebElement payNow;


	//Methods
	//click on hamburger menu in homepage
	public  void clickOnHamburgerMenu() throws Exception{
		BaseTest.click(HamburgerMenu);
	}

	//click on sigin button
	public void clickOnSiginButton(){
		BaseTest.click(SignIn);
	}

	//verify user profile Image is displaying after successful login
	public boolean verifyUserProfileImage(){
		return BaseTest.verifyElementIsDisplayed(userProfileImage);
	}

	//click on Home button
	public void clickOnHomeButton(){
		BaseTest.click(Home);
	}

	//search for product
	public void searchForProduct(String productName) throws Exception{
		BaseTest.waitForElementIsVisible(search);
		search.sendKeys(productName);
		Thread.sleep(3000);
		BaseTest.click(selectDropDownText);
		Thread.sleep(2000);
		BaseTest.invisiblityOfElement();
	}

	//select product
	@SuppressWarnings("unchecked")
	public void selectProduct(){
		BaseTest.click(selectFirstProduct);
		BaseTest.invisiblityOfElement();
	}

	//click on buy it now
	public void clickBuyItNow(){
		BaseTest.click(buyItNow);
	}

	//click on review
	public void reviewButton(){
		BaseTest.click(review);
		BaseTest.invisiblityOfElement();
	}

	//click on proceed To Pay
	public void proceedToPayButton(){
		BaseTest.click(proceedToPay);
	}

	//click on credit card
	public void clickOnCreditCard() throws Exception{
		Thread.sleep(7000);
		BaseTest.click(creditCard);
	}

	//click on credit card
	public boolean verifyPayNowIsDisplayed(){
		return BaseTest.verifyElementIsDisplayed(payNow);
	}

}
