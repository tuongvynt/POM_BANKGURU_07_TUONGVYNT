package com.bankguru.account;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;

public class RegisterLogin_Level8_Assert_Verify_Log_Report extends AbstractTest {

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
	public void TC01_Assert_Verify_Log_Report(Method testMethod) {
		log.info("=========== START: " + testMethod.getName() + " ===========");

		log.info("TC03_Assert_Verify_Log_Report - Step 1: Open New Customer Page");
		newCustomerPage = homePage.openNewCustomerPage(driver);

		log.info("TC03_Assert_Verify_Log_Report - Step 2: Verfi New Customer Page displayed");
		verifyTrue(newCustomerPage.isNewCustomerPageDisplayed());

		log.info("TC03_Assert_Verify_Log_Report - Step 3: Verfi Add New Customer Page not displayed");
		verifyTrue(newCustomerPage.isAddCustomerFormUndisplayed());

		log.info("TC03_Assert_Verify_Log_Report - Step 4: Verfi Home Page not displayed");
		verifyTrue(newCustomerPage.isHomePageUndisplayed());
		log.info("=========== END: " + testMethod.getName() + " ===========");
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
