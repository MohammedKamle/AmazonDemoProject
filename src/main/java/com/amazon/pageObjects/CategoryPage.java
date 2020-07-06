package com.amazon.pageObjects;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.amazon.general.Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CategoryPage extends Utilities {

	public CategoryPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.view.View[@text='TV, Appliances, Electronics']/following-sibling::android.view.View/android.widget.Image")
	@CacheLookup
	private MobileElement electronics;
	@AndroidFindBy(xpath = "//android.view.View[@text='Cameras']")
	@CacheLookup
	private MobileElement cameras;

	public void clickOnElectronicsCategory() {
		clickOnElement(electronics);
		logger.info("Electronics category is selected");
	}

	public void clickOnCameras() {
		logger.info("Scrolling until cameras option is viewed on page");
		scrollToText("Cameras");
		clickOnElement(cameras);
		logger.info("Cameras option is clicked");
	}
}
