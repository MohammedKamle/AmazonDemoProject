package com.amazon.pageObjects;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.amazon.general.Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductPage extends Utilities {

	public ProductPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='In stock.']")
	@CacheLookup
	private MobileElement stockAvailability;

	public String checkStockAvailibility() {
		logger.info("Validating whether top listed item available in stock");
		scrollToText("In stock.");
		return stockAvailability.getText();
	}
}
