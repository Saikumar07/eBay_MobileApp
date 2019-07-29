package com.eBay.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;





import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	public static AppiumDriver driver;
	public static WebDriverWait wait;
	protected static Properties properties = null;
	protected static InputStream inputstream = null;
	String taskfilepath= "\\resource";
	Process process;

	//before Test Annotation makes a java function to run every time before a TestNG test case
	@BeforeTest
	public void launchApplication() throws MalformedURLException, InterruptedException {

		//relative path to apk file
		//final File classpathRoot = new File(System.getProperty("user.dir"));
		//final File appDir = new File(classpathRoot, "src/test/resources/apps/");
		//File app = new File(appDir, "eBay.apk");

		//setting up desired capability
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platform", "ANDROID");
		caps.setCapability("platformVersion", "9");
		caps.setCapability("deviceName", "be1bccdc");
		//caps.setCapability("app", app.getAbsolutePath());
		caps.setCapability("appPackage", "com.ebay.mobile");
		caps.setCapability("appActivity", "com.ebay.mobile.activities.MainActivity");
		//caps.setCapability("autoLaunch","false");

		//initializing driver object
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	static {
		try {

			String propFile = System.getProperty("testprop");
			if (propFile == null)
				propFile = "datafile.properties";

			properties = new Properties();
			inputstream = BaseTest.class.getClassLoader().getResourceAsStream(propFile);
			System.out.println(inputstream);
			properties.load(inputstream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//get the data from the property file
	public static String propertyName(String name) {
		return (String) properties.get(name);
	}

	//wait for element to be clickable
	public static void waitForElementTobeClickable(WebElement element){
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	//wait for element to be visible
	public static void waitForElementIsVisible(WebElement element){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//wait for element to be visible
	public static void waitForElementNotVisible(WebElement element){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	//verify element is displayed in the page
	public static boolean verifyElementIsDisplayed(WebElement element){
		boolean elements;
		if(element.isDisplayed()){
			elements=true;
		}else{
			elements=false;
		}
		return elements;
	}

	//click the elemnets
	public static void click(WebElement element){
		waitForElementTobeClickable(element);
		element.click();
	}
	
	//Touch Actions
	public static void touchActions(WebElement element){
		TouchAction t=new TouchAction(driver);
		t.tap(element).perform();
	}

	//wait for invisible
	public static void invisiblityOfElement(){
		try {
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.ProgressBar[contains(@resource-id,'progress_bar')]")));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	//After Test Annotation makes a java function to run every time after a TestNG test case
	@AfterTest
	public void afterTest(){
		driver.quit();
	}

}