package com.bankguru.payment;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.bankguru.account.RegisterLogin_Global_Register;

import commons.AbstractTest;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.WithdrawalPageObject;

public class Payment_Function_Dynamic extends AbstractTest {

	// Test Data Preparation
	String newCustomerName = "AUTOMATION TESTING";
	String newDob = "01-01-1989";
	String newAdress = "PO Boc 911 8331 Duis Avenue";
	String newCity = "Tampa";
	String newState = "FL";
	String newPin = "466250";
	String newTelephoneNumber = "4555442476";
	String newEmail = "v_" + getCurrentDateTime() + "@mailinator.com";
	String newPassword = "automation";
	String createdCustomerID;
	// Test Edited Data Preparation
	String editAdress = "1883 Cursus Avenue";
	String editCity = "Houston";
	String editState = "Texas";
	String editPin = "166455";
	String editTelephoneNumber = "4779728081";
	String editEmail = "e_v_" + getCurrentDateTime() + "@gmail.com";
	
	
	// Account
	String accountType = "Savings";
	String initialDeposit = "50000";
	String createdAccountID;
	
	// Transfer
	String amountTransfer = "5000";
	String description = "Deposit";
	String transactionID;
	String currentBalance;
	
	// Withdraw
	String amountWithdraw = "15000";
	String descriptionWithdraw = "Deposit";
	String transactionIDWithdraw;

	// Fund transfer
	String accountPayeesNo = "57202";
	String amountTransferIntoOtherAccount = "10000";
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) throws Exception {
		driver = openMultiBrowser(browserName);
		loginPage = PageFactoryManager.getLoginPage(driver);
		loginPage.inputToUserIDTextbox(RegisterLogin_Global_Register.userID);
		loginPage.inputToUserIDPasswordTextbox(RegisterLogin_Global_Register.password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isHomePageDisplayed());
	}

	@Test
	public void Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully(Method testMethod) {

		log.info("=========== START: " + testMethod.getName() + " ===========");
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 01: Open New Customer Page");
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
		Assert.assertTrue(newCustomerPage.isNewCustomerPageDisplayed());
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 02: Input Customer name");
		newCustomerPage.inputToCustomerNameTextbox(newCustomerName);
		
		log.info(
				"Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 03: Input Customer date of birth");
		newCustomerPage.inputToDateOfBirthTextbox(newDob);
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 04: Input Customer address");
		newCustomerPage.inputToAddressTextbox(newAdress);
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 05: Input Customer pin");
		newCustomerPage.inputToCityTextbox(newCity);
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 06: Input Customer state");
		newCustomerPage.inputToStateTextbox(newState);
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 07: Input Customer pin");
		newCustomerPage.inputToPinTextbox(newPin);
		
		log.info(
				"Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 08: Input Customer telephone number");
		newCustomerPage.inputToTelephoneNumberTextbox(newTelephoneNumber);
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 09: Input Customer email");
		newCustomerPage.inputToEmailTextbox(newEmail);
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 10: Input Customer password");
		newCustomerPage.inputToPasswordTextbox(newPassword);
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 11: Click on Submit button");
		newCustomerPage.clickToSubmitButton();
		
		log.info(
				"Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 12: Verify message customer registered displays");
		verifyTrue(newCustomerPage.isCustomerRegisteredSuccessfully());
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 13: Get Customer Registerd ID");
		createdCustomerID = newCustomerPage.getCustomerIDText();
		
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}

	@Test
	public void Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully(Method testMethod) {

		log.info("=========== START: " + testMethod.getName() + " ===========");
		
		log.info("Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 01: Open Edit Customer Form");
		editCustomerPage = (EditCustomerPageObject) newCustomerPage.openDynamicPage(driver, "Edit Customer");
		Assert.assertTrue(editCustomerPage.isEditCustomerFormDisplayed());
		
		log.info("Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 02: Input Customer ID");
		editCustomerPage.inputToCustomerIDTextbox(createdCustomerID);
		
		log.info("Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 03: Click on Submit button");
		editCustomerPage.clickToSubmitButton();
		
		log.info(
				"Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 04: Verify Edit customer page displays");
		verifyTrue(editCustomerPage.isEditCustomerPageDisplayed());
		
		log.info("Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 05: Input Customer address");
		editCustomerPage.inputToAddressTextbox(editAdress);
		
		log.info("Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 06: Input Customer pin");
		editCustomerPage.inputToCityTextbox(editCity);
		
		log.info("Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 07: Input Customer state");
		editCustomerPage.inputToStateTextbox(editState);
		
		log.info("Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 08: Input Customer pin");
		editCustomerPage.inputToPinTextbox(editPin);
		
		log.info("Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 09: Input Customer telephone number");
		editCustomerPage.inputToTelephoneNumberTextbox(editTelephoneNumber);
		
		log.info("Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 10: Input Customer email");
		editCustomerPage.inputToEmailTextbox(editEmail);
		
		log.info("Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 11: Click on Submit button");
		editCustomerPage.clickToSubmitButton();
		
		log.info(
				"Payment_TC02_EditCustomerAccount_CheckEditedSuccessfully - Step 12: Verify message customer edited displays");
		verifyTrue(editCustomerPage.isCustomerEditedSuccessfully());
		
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}

	
	@Test
	public void Payment_TC03_CreateNewAccount_CheckCreatedSuccessfully(Method testMethod) {

		log.info("=========== START: " + testMethod.getName() + " ===========");
		
		log.info("Payment_TC03_CreateNewAccount_CheckCreatedSuccessfully - Step 01: Open New Account Page");
		newAccountPage = (NewAccountPageObject) homePage.openDynamicPage(driver, "New Account");
		Assert.assertTrue(newAccountPage.isNewAccountPageDisplayed());
		
		log.info("Payment_TC03_CreateNewAccount_CheckCreatedSuccessfully - Step 02: Input Customer ID");
		newAccountPage.inputToCustomerIDTextbox(createdCustomerID);
		
		log.info("Payment_TC03_CreateNewAccount_CheckCreatedSuccessfully - Step 03: Select account type is Savings");
		newAccountPage.selectAccountType(accountType);
		
		log.info("Payment_TC03_CreateNewAccount_CheckCreatedSuccessfully - Step 04: Input Initial Deposit");
		newAccountPage.inputToInitialDepositTextbox(initialDeposit);
		
		log.info("Payment_TC03_CreateNewAccount_CheckCreatedSuccessfully - Step 05: Click on Submit button");
		newAccountPage.clickToSubmitButton();
		
		log.info("Payment_TC03_CreateNewAccount_CheckCreatedSuccessfully - Step 06: Verify message account generated displays");
		verifyTrue(newAccountPage.isAccountGeneratedSuccessfully());
		
		log.info("Payment_TC03_CreateNewAccount_CheckCreatedSuccessfully - Step 07: Verify Current Amount is equal to Initial Deposit");
		String currentAmountText = newAccountPage.getCurrentAmountText();
		verifyEquals(currentAmountText, initialDeposit);
		currentBalance = initialDeposit;
		
		log.info("Payment_TC03_CreateNewAccount_CheckCreatedSuccessfully - Step 08: Get Account generated ID");
		createdAccountID = newAccountPage.getAccountIDText();
		
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}
	
	@Test
	public void Payment_TC04_TransferMoneyToCurrentAccount(Method testMethod) {

		log.info("=========== START: " + testMethod.getName() + " ===========");
		
		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 01: Open Deposit Page");
		depositPage = (DepositPageObject) homePage.openDynamicPage(driver, "Deposit");
		Assert.assertTrue(depositPage.isDepositPageDisplayed());
		
		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 02: Input Account number");
		depositPage.inputToAccountNoTextbox(createdAccountID);
		
		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 03: Input Amount");
		depositPage.inputToAmountTextbox(amountTransfer);
		
		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 04: Input Description");
		depositPage.inputToDescriptionTextbox(description);
		
		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 05: Click on Submit button");
		depositPage.clickToSubmitButton();
		
		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 06: Verify message transaction created displays");
		verifyTrue(depositPage.isTransactionCreatedSuccessfully(createdAccountID));
		
		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 07: Verify Current Balance");
		String currentBalanceText = depositPage.getCurrentBalanceText();

		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 08: Calculate Current Balance");
		currentBalance = depositPage.depositMoney(currentBalance, amountTransfer);

		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 09: Verify Current Balance displays properly");
		verifyEquals(currentBalanceText, currentBalance);
		
		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 10: Get transaction ID");
		transactionID = depositPage.getTransactionIDText();
				
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}
	
	@Test
	public void Payment_TC05_WithdrawMoneyFromCurrentAccount(Method testMethod) {

		log.info("=========== START: " + testMethod.getName() + " ===========");
		
		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 01: Open Withdrawal Page");
		withdrawPage = (WithdrawalPageObject) depositPage.openDynamicPage(driver, "Withdrawal");
		Assert.assertTrue(withdrawPage.isWithdrawalPageDisplayed());
		
		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 02: Input Account number");
		withdrawPage.inputToAccountNoTextbox(createdAccountID);
		
		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 03: Input Amount");
		withdrawPage.inputToAmountTextbox(amountWithdraw);
		
		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 04: Input Description");
		withdrawPage.inputToDescriptionTextbox(descriptionWithdraw);
		
		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 05: Click on Submit button");
		withdrawPage.clickToSubmitButton();
		
		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 06: Verify message withdraw transaction  created displays");
		verifyTrue(withdrawPage.isTransactionCreatedSuccessfully(createdAccountID));
		
		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 07: Verify Current Balance");
		String currentBalanceText = withdrawPage.getCurrentBalanceText();

		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 08: Calculate Current Balance");
		currentBalance = withdrawPage.withdrawMoney(currentBalance, amountWithdraw);

		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 09: Verify Current Balance displays properly");
		verifyEquals(currentBalanceText, currentBalance);
		
		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 10: Get transaction ID");
		transactionID = withdrawPage.getTransactionIDText();
				
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}
	
	@Test
	public void Payment_TC06_TransferMoneyIntoAnotherAccount(Method testMethod) {

		log.info("=========== START: " + testMethod.getName() + " ===========");
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 01: Open Fund Transfer Page");
		fundTransferPage = (FundTransferPageObject) withdrawPage.openDynamicPage(driver, "Fund Transfer");
		Assert.assertTrue(fundTransferPage.isFundTransferPageDisplayed());
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 02: Input Payers Account number");
		fundTransferPage.inputToPayersAccountNoTextbox(createdAccountID);
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 03: Input Payees Account number");
		fundTransferPage.inputToPayeesAccountNoTextbox(accountPayeesNo);
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 04: Input Amount");
		fundTransferPage.inputToAmountTextbox(amountTransferIntoOtherAccount);
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 04: Input Description");
		fundTransferPage.inputToDescriptionTextbox(descriptionWithdraw);
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 05: Click on Submit button");
		fundTransferPage.clickToSubmitButton();
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 06: Verify message transfer displays");
		verifyTrue(fundTransferPage.isTransferSuccessfully());
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 07: Get Amount text");
		String actualAmountText = fundTransferPage.getAmountText();

		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 09: Verify Amount displays properly");
		verifyEquals(actualAmountText, amountTransferIntoOtherAccount);
				
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}
	
	@Test
	public void Payment_TC07_CheckCurrentAccountBalance(Method testMethod) {

		log.info("=========== START: " + testMethod.getName() + " ===========");
		
		log.info("Payment_TC07_CheckCurrentAccountBalance - Step 01: Open Balance Enquiry Page");
		balanceEnquiryPage = (BalanceEnquiryPageObject) fundTransferPage.openDynamicPage(driver, "Balance Enquiry");
		Assert.assertTrue(balanceEnquiryPage.isBalanceEnquiryFormDisplayed());
		
		log.info("Payment_TC07_CheckCurrentAccountBalance - Step 02: Input Account number");
		balanceEnquiryPage.inputToAccountNoTextbox(createdAccountID);
		
		log.info("Payment_TC07_CheckCurrentAccountBalance - Step 05: Click on Submit button");
		balanceEnquiryPage.clickToSubmitButton();
		
		log.info("Payment_TC07_CheckCurrentAccountBalance - Step 06: Verify Balance Details page displays");
		verifyTrue(balanceEnquiryPage.isGetBalanceDetailsSuccessfully(createdAccountID));
		
		log.info("Payment_TC07_CheckCurrentAccountBalance - Step 07: Get Current Balance");
		String actualBalanceText = balanceEnquiryPage.getBalanceText();
		
		log.info("Payment_TC07_CheckCurrentAccountBalance - Step 08: Calculate Current Balance");
		currentBalance = balanceEnquiryPage.transferMoney(currentBalance, amountTransferIntoOtherAccount);

		log.info("Payment_TC07_CheckCurrentAccountBalance - Step 09: Verify Current Balance displays properly");
		verifyEquals(actualBalanceText, currentBalance);
				
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}
	
	@AfterClass
	public void afterClass() {
		// closeBrowserAndDriver(driver);
	}

	private WebDriver driver;
	private LoginPageObject loginPage;
	private EditCustomerPageObject editCustomerPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private WithdrawalPageObject withdrawPage;
	private FundTransferPageObject fundTransferPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	

}
