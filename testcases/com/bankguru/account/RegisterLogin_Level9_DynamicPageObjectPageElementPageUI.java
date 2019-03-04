package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import commons.AbstractTest;
import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterLogin_Level9_DynamicPageObjectPageElementPageUI extends AbstractTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		// Open Browser
		driver = openMultiBrowser(browserName);
		email = "nttvy_" + randomNumber() + "@mailinator.com";
		// Navigate to Login Page
		loginPage = PageFactoryManager.getLoginPage(driver);

		// Test Data Preparation
		newCustomerName = "AUTOMATION TESTING";
		newDob = "01-01-1989";
		newAdress = "PO Boc 911 8331 Duis Avenue";
		newCity = "Tampa";
		newState = "FL";
		newPin = "466250";
		newTelephoneNumber = "4555442476";
		newEmail = "v_" + getCurrentDateTime() + "@mailinator.com";
		newPassword = "automation";

	}

	@Test
	public void TC01_RegisterToSystem(Method testMethod) {
		log.info("=========== START: " + testMethod.getName() + " ===========");
		log.info("TC01_RegisterToSystem - Step 1: Get login page url");
		loginUrl = loginPage.getLoginPageURL();

		log.info("TC01_RegisterToSystem - Step 2: Click on Here link");
		registerPage = loginPage.clickToHereLink();

		log.info("TC01_RegisterToSystem - Step 3: Input data on Email textbox");
		registerPage.inputToUserEmailTextbox(email);

		log.info("TC01_RegisterToSystem - Step 4: Click on Submit button");
		registerPage.clickToSubmitButton();

		log.info("TC01_RegisterToSystem - Step 5: Get username, password");
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}

	@Test
	public void TC02_LoginWithAboveInformation(Method testMethod) {
		log.info("=========== START: " + testMethod.getName() + " ===========");

		log.info("TC02_LoginWithAboveInformation - Step 1: Open Login page url");
		loginPage = registerPage.openLoginPage(loginUrl);

		log.info("TC02_LoginWithAboveInformation - Step 2: Input data on Username textbox");
		loginPage.inputToUserIDTextbox(userID);

		log.info("TC02_LoginWithAboveInformation - Step 3: Input data on Password textbox");
		loginPage.inputToUserIDPasswordTextbox(password);

		log.info("TC02_LoginWithAboveInformation - Step 4: Click on Submit button");
		homePage = loginPage.clickToLoginButton();

		log.info("TC02_LoginWithAboveInformation - Step 5: Verfi Home Page NOT displayed - FAILED");
		verifyTrue(homePage.isHomePageUndisplayed());

		log.info("TC02_LoginWithAboveInformation - Step 6: Verify New Customer Page not displayed");
		verifyTrue(homePage.isNewCustomerPageUnDisplayed());

		log.info("TC02_LoginWithAboveInformation - Step 7: Verfi Home Page displayed");
		verifyTrue(homePage.isHomePageDisplayed());
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}

	// 02182019
	@Test
	public void TC03_DynamicPageObjectPageElementPageUI(Method testMethod) {
		log.info("=========== START: " + testMethod.getName() + " ===========");

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 01: Open New Customer Page");
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 02: Input Customer name");
		newCustomerPage.inputToCustomerNameTextbox(newCustomerName);

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 03: Input Customer date of birth");
		newCustomerPage.inputToDateOfBirthTextbox(newDob);

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 04: Input Customer address");
		newCustomerPage.inputToAddressTextbox(newAdress);

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 05: Input Customer pin");
		newCustomerPage.inputToCityTextbox(newCity);

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 06: Input Customer state");
		newCustomerPage.inputToStateTextbox(newState);

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 07: Input Customer pin");
		newCustomerPage.inputToPinTextbox(newPin);

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 08: Input Customer telephone number");
		newCustomerPage.inputToTelephoneNumberTextbox(newTelephoneNumber);

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 09: Input Customer email");
		newCustomerPage.inputToEmailTextbox(newEmail);

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 10: Input Customer password");
		newCustomerPage.inputToPasswordTextbox(newPassword);

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 11: Click on Submit button");
		newCustomerPage.clickToSubmitButton();

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 12: Verify message customer registered displays");
		verifyTrue(newCustomerPage.isCustomerRegisteredSuccessfully());

		log.info("TC03_DynamicPageObjectPageElementPageUI - Step 13: Get Customer Registerd ID");
		createdCustomerID = newCustomerPage.getCustomerIDText();

		log.info("=========== END: " + testMethod.getName() + " ===========");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	private WebDriver driver;
	private String loginUrl, email, userID, password;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private FundTransferPageObject fundTransferPage;
	private String newCustomerName, newDob, newAdress,	newCity, newState, newPin, newTelephoneNumber, newEmail, newPassword, createdCustomerID;
}
