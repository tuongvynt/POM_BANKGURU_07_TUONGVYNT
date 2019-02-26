package com.bankguru.account;

import org.openqa.selenium.WebDriver;
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

public class RegisterLogin_Level8_Assert_Verify_Log_Report2 extends AbstractTest {

  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  // Open Browser
	  driver = openMultiBrowser(browserName);
	  email  = "nttvy_" +randomNumber() +"@mailinator.com";
	  // Navigate to Login Page
	  loginPage = PageFactoryManager.getLoginPage(driver);	
	  	
  }

    @Test
	public void TC01_RegisterToSystem(Method testMethod) {
    	log.info("=========== START: " + testMethod.getName()+ " ===========");
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
		log.info("=========== END: " + testMethod.getName()+ " ===========");
	}

	@Test
	public void TC02_LoginWithAboveInformation(Method testMethod) {
		log.info("=========== START: " + testMethod.getName()+ " ===========");
		
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
		
		log.info("TC02_LoginWithAboveInformation - Step 6: Verify New Customer Page not displayed");
		verifyTrue(homePage.isNewCustomerPageUnDisplayed());
		
		log.info("TC02_LoginWithAboveInformation - Step 7: Verfi Home Page displayed");
		verifyTrue(homePage.isHomePageDisplayed());
		log.info("=========== END: " + testMethod.getName()+ " ===========");
	}
	
	// 02182019
	@Test
	public void TC03_Assert_Verify_Log_Report(Method testMethod) {
		log.info("=========== START: " + testMethod.getName()+ " ===========");
		
		log.info("TC03_Assert_Verify_Log_Report - Step 1: Open New Customer Page");
		newCustomerPage = homePage.openNewCustomerPage(driver);
		
		log.info("TC03_Assert_Verify_Log_Report - Step 2: Verfi New Customer Page displayed");
		verifyTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		log.info("TC03_Assert_Verify_Log_Report - Step 3: Verfi Add New Customer Page not displayed");
		verifyTrue(newCustomerPage.isAddNewCustomerFormDisplayed());
		
		log.info("TC03_Assert_Verify_Log_Report - Step 4: Verfi Home Page not displayed");
		verifyTrue(newCustomerPage.isHomePageUndisplayed());
		log.info("=========== END: " + testMethod.getName()+ " ===========");
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
}
