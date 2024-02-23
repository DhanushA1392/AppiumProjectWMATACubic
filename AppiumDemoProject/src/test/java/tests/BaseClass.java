package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class BaseClass {

	AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() {

		try {

			DesiredCapabilities dc = new DesiredCapabilities();

			String platform = "Android";

			if (platform.equalsIgnoreCase("Android")) {

//				dc.setCapability("platformName", "ANDROID");
//				dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
//				dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
//				dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7 Pro");
//				dc.setCapability(MobileCapabilityType.UDID, "2B071FDH300LXS");
//				// dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//				dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\215595\\Desktop\\Automation\\app.apk");
//				// dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
//				URL url = new URL("http://127.0.0.1:4723/wd/hub");
//				driver = new AppiumDriver<MobileElement>(url, dc);
//				// driver = new AndroidDriver<MobileElement>(url,dc);

				///////// S23//////////
				dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
				dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
				dc.setCapability(MobileCapabilityType.DEVICE_NAME, "S23");
				dc.setCapability(MobileCapabilityType.UDID, "RZCW12KJZ9T");
				dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\215595\\Desktop\\Automation\\app.apk");
				URL url = new URL("http://127.0.0.1:4723/wd/hub");
				driver = new AppiumDriver<MobileElement>(url, dc);

			}

			else if (platform.equalsIgnoreCase("iOS")) {
				dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
				dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.7.2");
				dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
				dc.setCapability(MobileCapabilityType.UDID, "00008110-00041CA90A79401E");
				// dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
				dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\215595\\Desktop\\Automation\\app.ipa");
				dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

			}
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, dc);

			System.out.println("!!!!......Setup complete......!!!!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
			e.printStackTrace();

		}
	}

	@Test
	public void OnboardingScreens() throws Exception {

		int numberOfIterations = 6; // Number of times Next button appears

		for (int i = 0; i < numberOfIterations; i++) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Next\"]")));
			element.click();
		}

		driver.findElementByXPath("//android.widget.TextView[@text=\"Done\"]").click();

		int numberOfStars = 100; // You can change this to the desired number of stars

		// Print a line of stars
		for (int i = 0; i < numberOfStars; i++) {
			System.out.print("*");
		}

		System.out.println("\n");
		System.out.println("Onboarding screens clicked!!");
		System.out.println("\n");

	}

	@Test
	public void Swipe() throws Exception {

		int numberOfScrolls = 12;

		for (int scrollAttempt = 0; scrollAttempt < numberOfScrolls; scrollAttempt++) {

			Dimension size = driver.manage().window().getSize();

			// Define start and end points
			int startX = size.getWidth() / 2;
			int startY = (int) (size.getHeight() * 0.9);
			int endY = (int) (size.getHeight() * 0.2);
			TouchAction touchAction = new TouchAction(driver).press(PointOption.point(startX, startY))
					.waitAction(waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(startX, endY)).release()
					.perform();

		}

		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Accept\"]")).click();

		System.out.println("Accepted!!");

		/*
		 * // * ################working code for single scroll################## // * //
		 * * // * Dimension size = driver.manage().window().getSize(); // *
		 * System.out.println(size); // * // * // Define start and end points int startX
		 * = size.getWidth() / 2; int startY = // * (int) (size.getHeight() * 0.8); int
		 * endY = (int) (size.getHeight() * 0.2); // * TouchAction touchAction = new //
		 * * TouchAction(driver).press(PointOption.point(startX, startY)) // *
		 * .waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(
		 * // * startX, endY)).release() .perform(); // * // * // *
		 * ############################### //
		 */
//
////		String buttonText = "//android.widget.TextView[@text=\"Accept\"]";    
////		WebDriverWait wait = new WebDriverWait(driver,1000);
////		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0))"
////				+ ".scrollIntoView(new UiSelector().text(\"" + buttonText + "\"))"));
////		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath(buttonText)));
////		driver.findElementByXPath(buttonText).click();
//
//		///////////////////////////////////////////////////////
//
////		String targetText = "Accept";
////
////		// Maximum number of scroll attempts
////		int maxScrollAttempts = 20;
////		int scrollAttempt = 0;
////
////		// Define a threshold for considering the end of the page
////		double scrollEndThreshold = 0.9; 
////
////		WebDriverWait wait = new WebDriverWait(driver, 10);
////
////		while (scrollAttempt < maxScrollAttempts) {
////		    // Get the screen size
////		    Dimension size = driver.manage().window().getSize();
////
////		    // Calculate the start and end points for the scroll
////		    int startY = (int) (size.getHeight() * 0.8);
////		    int endY = (int) (size.getHeight() * scrollEndThreshold);
////
////		    // Perform the scroll
////		    driver.findElement(MobileBy.AndroidUIAutomator(
////		            "new UiScrollable(new UiSelector().scrollable(true).instance(0))"
////		                    + ".scrollIntoView(new UiSelector().text(\"" + targetText + "\"))"));
//
		// UserLoginOptions();
		CreateAccount();
	}

	@Test
	public void UserLoginOptions() {

		try {

			driver.findElementByXPath("//android.widget.TextView[@text=\"Login\"]").click();
			WebDriverWait wait = new WebDriverWait(driver, 30);

			wait.until(ExpectedConditions
					.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='Username']")));
			driver.findElementByXPath("//android.widget.EditText[@text=\"Username\"]").sendKeys("qahercules180");

			wait.until(ExpectedConditions
					.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text=\"Password\"]")));
			driver.findElement(By.xpath("//android.widget.EditText[@text=\"Password\"]")).sendKeys("123456Aa!");

			driver.findElement(By.xpath("(//android.widget.TextView[@text=\"Login\"])[2]")).click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void SingleSwipe() {

		try {
			Dimension size = driver.manage().window().getSize();

			// Define start and end points
			int startX = size.getWidth() / 2;
			int startY = (int) (size.getHeight() * 0.9);
			int endY = (int) (size.getHeight() * 0.2);
			TouchAction touchAction = new TouchAction(driver).press(PointOption.point(startX, startY))
					.waitAction(waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(startX, endY)).release()
					.perform();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void CreateAccount() {

		try {

			driver.findElementByXPath("//android.widget.TextView[@text=\"Create an Account\"]").click();
			WebDriverWait wait = new WebDriverWait(driver, 20);

			wait.until(ExpectedConditions
					.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text=\"First Name\"]")))
					.sendKeys("Test101");

			driver.findElementByXPath("//android.widget.EditText[@text=\"Middle Initial (Optional)\"]").sendKeys("A");
			driver.findElementByXPath("//android.widget.EditText[@text=\"Last Name\"]").sendKeys("Last");

			driver.findElementByXPath("//android.widget.TextView[@text=\"Suffix (optional)\"]").click();

			wait.until(
					ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@text=\"Jr\"]")))
					.click();

			Thread.sleep(3000);

			wait.until(ExpectedConditions
					.elementToBeClickable(MobileBy.xpath("//android.widget.TextView[@text=\"Date of Birth\"]")))
					.click();

			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("06 February 2024"))).click();

			driver.findElementById("android:id/button1").click();

			driver.findElementByXPath("//android.widget.EditText[@text=\"Email\"]").sendKeys("test123@gmail.com");

			////// swipe/////////
			SingleSwipe();

			driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Mobile Phone Number\"]")
					.sendKeys("9900112233");

			driver.findElementByXPath("//android.widget.EditText[@text=\"Street Address 1\"]").sendKeys("Church St.");

			driver.findElementByXPath("//android.widget.EditText[@text=\"Street Address 2 (Optional)\"]")
					.sendKeys("Old Road");

			driver.findElementByXPath("	\r\n" + "//android.widget.EditText[@text=\"City\"]").sendKeys("San Deigo");

			driver.findElementByXPath("//android.widget.TextView[@text=\"State\"]").click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"AL – Alabama\"]"))).click();

			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("	\r\n" + "//android.widget.EditText[@text=\"Zip Code\"]")))
					.sendKeys("92123");

			SingleSwipe();

			driver.findElementByXPath("//android.widget.TextView[@text=\"Next\"]").click();
			System.out.println("Account created");

		}

		catch (Exception e) {

			e.printStackTrace();
			e.getMessage();

		}

	}

	@AfterTest
	public void TearDown() {

		System.out.println("!!!!Completed!!!!");
		System.out.println("\n");

	}

}
