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

public class LandingPage extends Utilities {

	public LandingPage(AndroidDriver<AndroidElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(id = "in.amazon.mShop.android.shopping:id/action_bar_burger_icon")
	@CacheLookup
	private MobileElement hamburgerMenu;

	@AndroidFindBy(className = "android.widget.TextView")
	@CacheLookup
	private List<MobileElement> hamburgerMenuOptions;

	public void clickHamburgerMenu() {
		clickOnElement(hamburgerMenu);
		logger.info("Hamburger Menu is clicked");
	}

	public void selectHanburgerMenuOption(String option) {
		for (int i = 0; i < hamburgerMenuOptions.size(); i++) {
			if (hamburgerMenuOptions.get(i).getText().toLowerCase().contains(option)) {
				clickOnElement(hamburgerMenuOptions.get(i));
				logger.info("Shop based on category is clicked");
				break;
			}
		}

	}
}
