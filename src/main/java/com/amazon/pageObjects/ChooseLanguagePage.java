package com.amazon.pageObjects;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.amazon.general.Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ChooseLanguagePage extends Utilities {
	public ChooseLanguagePage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Select Your Language\"]/following-sibling::android.widget.GridLayout/android.widget.ImageView[2]")
	@CacheLookup
	private MobileElement englishLanguage;

	public void chooseEnglishLanguage() {
		clickOnElement(englishLanguage);
		logger.info("English language is selected");
	}
}