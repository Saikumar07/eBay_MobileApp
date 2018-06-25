package com.eBay.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;





import java.util.Properties;
import java.util.concurrent.TimeUnit;

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
	public void createAppiumDriver() throws MalformedURLException, InterruptedException {

		//relative path to apk file
		//  final File classpathRoot = new File(System.getProperty("user.dir"));
		//  final File appDir = new File(classpathRoot, "src/test/resources/apps/");
		// File app = new File(appDir, "ebay.apk");

		//setting up desired capability
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platform", "ANDROID");
		caps.setCapability("platformVersion", "5.1.1");
		caps.setCapability("deviceName", "50a3e295");
		// caps.setCapability("app", app.getAbsolutePath());
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
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	//wait for element to be visible
	public static void waitForElementIsVisible(WebElement element){
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	//click the elemnets
	public static void click(WebElement element){
		try{
			waitForElementTobeClickable(element);
			element.click();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	//click the elemnets
	public static void sendkeys(WebElement element,String text){
		try{
			waitForElementIsVisible(element);
			element.sendKeys(text);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

	//After Test Annotation makes a java function to run every time after a TestNG test case
	@AfterTest
	public void afterTest(){
		driver.quit();
	}

}