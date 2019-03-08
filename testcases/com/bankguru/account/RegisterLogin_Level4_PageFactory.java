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
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterLogin_Level4_PageFactory extends AbstractTest {
	
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
	public void TC01_RegisterToSystem() throws Exception {
	  loginUrl = loginPage.getLoginPageURL();
		
		// Click on Here link
	    registerPage = loginPage.clickToHereLink();
		
		registerPage.inputToUserEmailTextbox(email);
		registerPage.clickToSubmitButton();
		
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();	
	}

	@Test
	public void TC02_LoginWithAboveInformation() throws Exception {
		
		// Open Login Page
		loginPage = registerPage.openLoginPage(loginUrl);
		
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToUserIDPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		// Click on Login, navigate to HomePage
		Assert.assertTrue(homePage.isHomePageDisplayed());
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
}
