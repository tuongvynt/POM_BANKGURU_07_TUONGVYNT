package com.bankguru.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.DepositPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterLogin_Level6_DynamicLocator_RestParameter extends AbstractTest {
	

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
	public void TC01_RegisterToSystem() {
	  loginUrl = loginPage.getLoginPageURL();
		
		// Click on Here link
	    registerPage = loginPage.clickToHereLink();
		
		registerPage.inputToUserEmailTextbox(email);
		registerPage.clickToSubmitButton();
		
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();	
	}

	@Test
	public void TC02_LoginWithAboveInformation() {
		
		// Open Login Page
		loginPage = registerPage.openLoginPage(loginUrl);
		
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToUserIDPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		// Click on Login, navigate to HomePage
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}
	
	// 02182019
	@Test
	public void TC03_openPages_DynamicLocator_RestParameter() {
		
		// Homepage > New Customer - So luong Pages it
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		// New Customer > New Account
		newAccountPage = (NewAccountPageObject) newCustomerPage.openDynamicPage(driver, "New Account");
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
		
		// New Account > Deposit
		depositPage = (DepositPageObject) newAccountPage.openDynamicPage(driver, "Deposit");
		Assert.assertTrue(depositPage.isDepositPageDisplayed());
		
		// Deposit > Fund Transfer
		fundTransferPage = (FundTransferPageObject) depositPage.openDynamicPage(driver, "Fund Transfer");
		Assert.assertTrue(fundTransferPage.isFundTransferPageDisplayed());
		
		//  Fund Transfer > Homepage
		homePage = (HomePageObject) fundTransferPage.openDynamicPage(driver, "Manager");
		Assert.assertTrue(homePage.isHomePageDisplayed());
		
		// Homepage > New Account
		newAccountPage = (NewAccountPageObject) homePage.openDynamicPage(driver, "New Account");
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
		
		// New Account > New Customer - So luong page nhieu
		newAccountPage.openDynamicMorePage(driver, "New Customer");
		newCustomerPage = PageFactoryManager.getNewCustomerPage(driver);
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		// New Customer > Deposit - So luong page nhieu
		newCustomerPage.openDynamicMorePage(driver, "Deposit");
		depositPage = PageFactoryManager.getDepositPage(driver);
		Assert.assertTrue(depositPage.isDepositPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
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
