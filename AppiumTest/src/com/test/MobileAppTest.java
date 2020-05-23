package com.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileAppTest {

	public static void main(String[] args) throws InterruptedException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "OVIBIRAAPVDYPVCU"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "6.0");
		caps.setCapability("appPackage", "com.android.vending");
		caps.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
		caps.setCapability("noReset", "true");

		try {
			AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);

			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.findElement(By.id("com.android.vending:id/search_bar_hint")).click();
			Thread.sleep(5000); 
			driver.findElement(By.id("com.android.vending:id/search_bar_text_input")).sendKeys("whatsapp"); 
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}		

	}

}
