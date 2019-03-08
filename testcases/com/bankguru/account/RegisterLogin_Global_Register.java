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

public class RegisterLogin_Global_Register extends AbstractTest {

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
	public void TC01_RegisterToSystem(Method testMethod) throws Exception {
    	log.info("=========== START: " + testMethod.getName()+ " ===========");
    	
	    log.info("TC01_RegisterToSystem - Step 1: Click on Here link");
	    registerPage = loginPage.clickToHereLink();
		
	    log.info("TC01_RegisterToSystem - Step 2: Input data on Email textbox");
		registerPage.inputToUserEmailTextbox(email);
		
		log.info("TC01_RegisterToSystem - Step 3: Click on Submit button");
		registerPage.clickToSubmitButton();
		
		log.info("TC01_RegisterToSystem - Step 4: Get username, password");
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();	
		
		System.out.println("UserID:" + userID);
		System.out.println("Password:" + password);
		log.info("=========== END: " + testMethod.getName()+ " ===========");
	}

	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}

	private WebDriver driver;
	private String email;
	public static String userID, password;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
}
