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

public class RegisterLogin_Level7_CheckUndisplayed_OverrideTimeOut extends AbstractTest {
	

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
