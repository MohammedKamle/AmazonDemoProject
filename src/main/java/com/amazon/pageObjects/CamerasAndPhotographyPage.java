package com.amazon.pageObjects;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.amazon.general.Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CamerasAndPhotographyPage extends Utilities {

	public CamerasAndPhotographyPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(className = "android.widget.Image")
	@CacheLookup
	private List<MobileElement> topListedProducts;

	public void clickOnTopListedProduct() {
		clickOnElement(topListedProducts.get(0));
		logger.info("Top Listed Product Clicked");
	}
}