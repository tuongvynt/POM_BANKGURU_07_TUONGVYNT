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
		newGender = "f";
		expectedGender = "female";
		newDob = "01/01/1989";
		expectedDOB = "1989-01-01";
		newAdress = "PO Boc 911 8331 Duis Avenue";
		newCity = "Tampa";
		newState = "FL";
		newPin = "466250";
		newTelephoneNumber = "4555442476";
		newEmail = "v_" + getCurrentDateTime() + "@mailinator.com";
		newPassword = "automation";

	}

	@Test
	public void TC01_RegisterToSystem(Method testMethod) throws Exception {
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
	public void TC02_LoginWithAboveInformation(Method testMethod) throws Exception {
		log.info("=========== START: " + testMethod.getName() + " ===========");

		log.info("TC02_LoginWithAboveInformation - Step 1: Open Login page url");
		loginPage = registerPage.openLoginPage(loginUrl);

		log.info("TC02_LoginWithAboveInformation - Step 2: Input data on Username textbox");
		loginPage.inputToUserIDTextbox(userID);

		log.info("TC02_LoginWithAboveInformation - Step 3: Input data on Password textbox");
		loginPage.inputToUserIDPasswordTextbox(password);

		log.info("TC02_LoginWithAboveInformation - Step 4: Click on Submit button");
		homePage = loginPage.clickToLoginButton();

		log.info("TC02_LoginWithAboveInformation - Step 5: Verfi Home Page displayed");
		verifyTrue(homePage.isHomePageDisplayed());
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}

	@Test
	public void TC03_OpenDynamicPageAndCheckPageDisplayed(Method testMethod) {
		log.info("=========== START: " + testMethod.getName() + " ===========");

		// Homepage > New Customer - So luong Pages it
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		verifyTrue(newCustomerPage.isDynamicPageDisplayed(driver, "Add New Customer"));

		// New Customer > New Account
		newAccountPage = (NewAccountPageObject) newCustomerPage.openDynamicPage(driver, "New Account");
		verifyTrue(newAccountPage.isDynamicPageDisplayed(driver, "Add new account form"));

		// New Account > Deposit
		depositPage = (DepositPageObject) newAccountPage.openDynamicPage(driver, "Deposit");
		verifyTrue(depositPage.isDynamicPageDisplayed(driver, "Amount Deposit Form"));

		// Deposit > Homepage
		homePage = (HomePageObject) depositPage.openDynamicPage(driver, "Manager");
		verifyTrue(homePage.isHomePageDisplayed());

		// Homepage > New Account
		newAccountPage = (NewAccountPageObject) homePage.openDynamicPage(driver, "New Account");
		verifyTrue(newAccountPage.isDynamicPageDisplayed(driver, "Add new account form"));

		// New Account > New Customer
		newCustomerPage = (NewCustomerPageObject) newAccountPage.openDynamicPage(driver, "New Customer");
		verifyTrue(newCustomerPage.isDynamicPageDisplayed(driver, "Add New Customer"));

		log.info("=========== END: " + testMethod.getName() + " ===========");
	}

	@Test
	public void TC04_DynamicPageObjectPageElementPageUI(Method testMethod) {
		log.info("=========== START: " + testMethod.getName() + " ===========");

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 01: Open New Customer Page");
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 02: Input Customer name");
		newCustomerPage.inputToDynamicTextbox(driver, "name", newCustomerName);

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 03: Select gender");
		newCustomerPage.clickToDynamicRadioButotn(driver, newGender);

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 04: Input Customer date of birth");
		newCustomerPage.inputToDynamicTextbox(driver, "dob", newDob);

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 05: Input Customer address");
		newCustomerPage.inputToDynamicTextarea(driver, "addr", newAdress);

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 06: Input Customer city");
		newCustomerPage.inputToDynamicTextbox(driver, "city", newCity);

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 07: Input Customer state");
		newCustomerPage.inputToDynamicTextbox(driver, "state", newState);

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 08: Input Customer pin");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", newPin);

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 09: Input Customer telephone number");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", newTelephoneNumber);

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 10: Input Customer email");
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", newEmail);

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 11: Input Customer password");
		newCustomerPage.inputToDynamicTextbox(driver, "password", newPassword);

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 12: Click on Submit button");
		newCustomerPage.clickToDynamicButton(driver, "sub");

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 13: Verify message customer registered displays");
		verifyTrue(newCustomerPage.isCustomerRegisteredSuccessfully());

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 14: Get Customer Registerd ID");
		createdCustomerID = newCustomerPage.getCustomerIDText();

		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 14: Verify created data");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Customer Name"), newCustomerName);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Gender"), expectedGender);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Birthdate"), expectedDOB);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Address"), newAdress);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "City"), newCity);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "State"), newState);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Pin"), newPin);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Mobile No."), newTelephoneNumber);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Email"), newEmail);

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
	private String newCustomerName, newGender, newDob, newAdress, newCity, newState, newPin, newTelephoneNumber,
			newEmail, newPassword, createdCustomerID, expectedGender, expectedDOB;
}
