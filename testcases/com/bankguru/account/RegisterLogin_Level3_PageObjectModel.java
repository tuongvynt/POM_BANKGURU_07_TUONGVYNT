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
import pageObjects.RegisterPageObject;

public class RegisterLogin_Level3_PageObjectModel extends AbstractTest {
	private WebDriver driver;
	private String loginUrl, email, userID, password;

	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  	
	  	// Open Browser
		driver = openMultiBrowser(browserName);
		email  = "nttvy_" +randomNumber() +"@mailinator.com";
		// Navigate to Login Page
		loginPage = new LoginPageObject(driver);	
  }

    @Test
	public void TC01_RegisterToSystem() {
	  loginUrl = loginPage.getLoginPageURL();
		
		// Click on Here link
		loginPage.clickToHereLink();
		
		// Navigate to Register Page
		registerPage = new RegisterPageObject(driver);
		registerPage.inputToUserEmailTextbox(email);
		registerPage.clickToSubmitButton();
		
		userID = registerPage.getUserIDText();
		password = registerPage.getPasswordText();	
	}

	@Test
	public void TC02_LoginWithAboveInformation() {
		
		// Open Login Page
		registerPage.openLoginPage(loginUrl);
		
		loginPage = new LoginPageObject(driver);
		loginPage.inputToUserIDTextbox(userID);
		loginPage.inputToUserIDPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		
		// Click on Login, navigate to HomePage
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isHomePageDislayed());
	}


	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(999999999);
		return number;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
