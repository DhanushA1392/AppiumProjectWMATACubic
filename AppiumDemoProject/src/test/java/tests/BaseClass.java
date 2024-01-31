package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() {

		try {
			
			
			DesiredCapabilities dc = new DesiredCapabilities();
			
			String platform = "Android";
			
			if(platform.equalsIgnoreCase("Android")) {
			
			// dc.setCapability("platformName", "ANDROID");
			dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
			dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
			dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7 Pro");
			dc.setCapability(MobileCapabilityType.UDID, "2B071FDH300LXS");
			// dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
			dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\215595\\Desktop\\Automation\\app.apk");
			// dc.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new AppiumDriver<MobileElement>(url, dc);
			// driver = new AndroidDriver<MobileElement>(url,dc);
			
			}
			
			else if(platform.equalsIgnoreCase("iOS"))
			{
				dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
				dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "16.7.2");
				dc.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone");
				//dc.setCapability(MobileCapabilityType.UDID, "");
				// dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
				dc.setCapability(MobileCapabilityType.APP, "C:\\Users\\215595\\Desktop\\Automation\\app.ipa");
				
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
	public void SampleTest() throws Exception {
		
	
		int numberOfIterations = 6;   //Number of times Next button appears
		
        for (int i = 0; i < numberOfIterations; i++) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Next\"]")));
			element.click();
		}
        
		driver.findElementByXPath("//android.widget.TextView[@text=\"Done\"]").click();
		
		int numberOfStars = 100;  // You can change this to the desired number of stars

        // Print a line of stars
        for (int i = 0; i < numberOfStars; i++) {
            System.out.print("*");
        }
		
        System.out.println("\n");
		System.out.println("Onboarding screens clicked!!");
		System.out.println("\n");
		
		
	}

	@AfterTest
	public void TearDown() {
		
		System.out.println("!!!!Completed!!!!");
		System.out.println("\n");

	}

}
