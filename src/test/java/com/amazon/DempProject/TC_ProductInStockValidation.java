package com.amazon.DempProject;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.general.Base;
import com.amazon.pageObjects.CamerasAndPhotographyPage;
import com.amazon.pageObjects.CategoryPage;
import com.amazon.pageObjects.ChooseLanguagePage;
import com.amazon.pageObjects.LandingPage;
import com.amazon.pageObjects.ProductPage;
import com.amazon.pageObjects.SignInPage;

public class TC_ProductInStockValidation extends Base {

	private ChooseLanguagePage chooseLanguagePage;
	private SignInPage signUpPage;
	private LandingPage landingPage;
	private CategoryPage categoryPage;
	private CamerasAndPhotographyPage camerasAndPhotographyPage;
	private ProductPage productPage;

	@BeforeMethod()
	public void initialization() {
		chooseLanguagePage = new ChooseLanguagePage(driver);
		signUpPage = new SignInPage(driver);
		landingPage = new LandingPage(driver);
		categoryPage = new CategoryPage(driver);
		camerasAndPhotographyPage = new CamerasAndPhotographyPage(driver);
		productPage = new ProductPage(driver);
	}

	@Test
	public void productInStockValidation() {
		chooseLanguagePage.chooseEnglishLanguage();
		signUpPage.clickOnskipSignInButton();
		landingPage.clickHamburgerMenu();
		landingPage.selectHanburgerMenuOption("categor");
		categoryPage.clickOnElectronicsCategory();
		categoryPage.clickOnCameras();
		camerasAndPhotographyPage.clickOnTopListedProduct();
		// ASSERTION
		Assert.assertEquals(productPage.checkStockAvailibility(), "In stock.");
	}
}
