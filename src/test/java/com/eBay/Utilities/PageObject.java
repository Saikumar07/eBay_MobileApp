package com.eBay.Utilities;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class PageObject {
	
	public static AppiumDriver driver;
	
	public PageObject(AppiumDriver driver){
		
		PageObject.driver = driver; 
		PageFactory.initElements(driver, this);
		}

}
