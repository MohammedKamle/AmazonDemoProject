package com.amazon.general;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities {
	protected AndroidDriver<AndroidElement> driver;
	protected Logger logger;
	protected WebDriverWait wait;

	public Utilities(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		logger = Logger.getLogger("Amazon");
		PropertyConfigurator.configure("Log4j.properties");
		wait = new WebDriverWait(driver, 20);
	}

	public void scrollToText(String text) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));");
	}

	public void clickOnElement(MobileElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}
}
