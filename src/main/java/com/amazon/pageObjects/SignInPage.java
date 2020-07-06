package com.amazon.pageObjects;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.amazon.general.Utilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInPage extends Utilities {

	public SignInPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/skip_sign_in_button")
	@CacheLookup
	private MobileElement skipSignInButton;

	public void clickOnskipSignInButton() {
		clickOnElement(skipSignInButton);
		logger.info("Skip button is clicked");
	}
}
