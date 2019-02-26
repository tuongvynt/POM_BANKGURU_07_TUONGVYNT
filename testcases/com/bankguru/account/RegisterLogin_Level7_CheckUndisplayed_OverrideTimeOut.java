package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;

public class RegisterLogin_Level7_CheckUndisplayed_OverrideTimeOut extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToUserIDTextbox(RegisterLogin_Global_Register.userID);
		loginPage.inputToUserIDPasswordTextbox(RegisterLogin_Global_Register.password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageDisplayed());

	}

	@Test
	public void TC03_checkUndisplayed_OverrideTimeOut() {

		// Homepage > New Customer - So luong Pages it
		newCustomerPage = homePage.openNewCustomerPage(driver);

		// Verify is NewCustomerPage displayed
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());

		// Verify AddNewCustomerForm is not displayed
		Assert.assertTrue(newCustomerPage.isAddNewCustomerFormDisplayed());

		// Verify Homepage is not displayed
		Assert.assertTrue(newCustomerPage.isHomePageUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	private WebDriver driver;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
}
