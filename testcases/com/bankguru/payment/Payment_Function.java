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
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.WithdrawalPageObject;

public class Payment_Function extends AbstractTest {

	
	
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
		
		log.info("TC04_DynamicPageObjectPageElementPageUI - Step 03: Select gender");
		newCustomerPage.clickToDynamicRadioButotn(driver, newGender);
		
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
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 14: Verify created data");
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
		
		log.info("Payment_TC01_CreateNewCustomerAccount_CheckCreatedSuccessfully - Step 13: Verify edited data");
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Customer Name"), newCustomerName);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Gender"), expectedGender);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Birthdate"), expectedDOB);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Address"), editAdress);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "City"), editCity);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "State"), editState);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Pin"), editPin);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Mobile No."), editTelephoneNumber);
		verifyEquals(newCustomerPage.getDynamicTextInTable(driver, "Email"), editEmail);
		
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
		
		log.info("Payment_TC03_CreateNewAccount_CheckCreatedSuccessfully - Step 09: Verify created data");
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Account ID"), createdAccountID);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Customer ID"), createdCustomerID);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Customer Name"), newCustomerName);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Email"), editEmail);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Account Type"), accountType);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Date of Opening"), currentDate);
		verifyEquals(newAccountPage.getDynamicTextInTable(driver, "Current Amount"), currentBalance);
		
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
		depositPage.inputToDescriptionTextbox(descriptionDeposit);
		
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
		
		log.info("Payment_TC04_TransferMoneyToCurrentAccount - Step 11: Verify created data");
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Transaction ID"), transactionID);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Account No"), createdAccountID);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Amount Credited"), amountTransfer);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Type of Transaction"), typeOfTransactionDeposit);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Description"), descriptionDeposit);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Current Balance"), currentBalance);
				
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
		
		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 11: Verify created data");
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Transaction ID"), transactionID);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Account No"), createdAccountID);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Amount Debited"), amountWithdraw);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Type of Transaction"), typeOfTransactionWithdrawal);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Description"), descriptionWithdraw);
		verifyEquals(depositPage.getDynamicTextInTable(driver, "Current Balance"), currentBalance);
				
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
		fundTransferPage.inputToDescriptionTextbox(descriptionTransfer);
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 05: Click on Submit button");
		fundTransferPage.clickToSubmitButton();
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 06: Verify message transfer displays");
		verifyTrue(fundTransferPage.isTransferSuccessfully());
		
		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 07: Get Amount text");
		String actualAmountText = fundTransferPage.getAmountText();

		log.info("Payment_TC06_TransferMoneyIntoAnotherAccount - Step 09: Verify Amount displays properly");
		verifyEquals(actualAmountText, amountTransferIntoOtherAccount);
		
		log.info("Payment_TC05_WithdrawMoneyFromCurrentAccount - Step 10: Verify created data");
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "From Account Number"), createdAccountID);
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "To Account Number"), accountPayeesNo);
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "Amount"), amountTransferIntoOtherAccount);
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "Description"), descriptionTransfer);
				
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
		
		log.info("Payment_TC07_CheckCurrentAccountBalance - Step 10: Verify created data");
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "Account No"), createdAccountID);
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "Type of Account"), accountType);
		verifyEquals(fundTransferPage.getDynamicTextInTable(driver, "Balance"), currentBalance);
				
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}
	
	@Test
	public void Payment_TC08_DeleteAccount_CheckDeleteSuccessfully(Method testMethod) {

		log.info("=========== START: " + testMethod.getName() + " ===========");
		
		log.info("Payment_TC08_DeleteAccount_CheckDeleteSuccessfully - Step 01: Open Delete Account Form");
		deleteAccountPage = (DeleteAccountPageObject) fundTransferPage.openDynamicPage(driver, "Delete Account");
		Assert.assertTrue(deleteAccountPage.isDeleteAccountFormDisplayed());
		
		log.info("Payment_TC08_DeleteAccount_CheckDeleteSuccessfully - Step 02: Input Customer ID");
		deleteAccountPage.inputToAccountNoTextbox(createdAccountID);
		
		log.info("Payment_TC08_DeleteAccount_CheckDeleteSuccessfully - Step 03: Click on Submit button");
		deleteAccountPage.clickToSubmitButton();
		
		log.info(
				"Payment_TC08_DeleteAccount_CheckDeleteSuccessfully - Step 04: Verify Message Delete This Account Displaye");
		verifyTrue(deleteAccountPage.isMessageDeleteThisAccountDisplayed());
		
		log.info("Payment_TC08_DeleteAccount_CheckDeleteSuccessfully - Step 05: Click on Submit button");
		deleteAccountPage.clickToOKButton();
		
		log.info(
				"Payment_TC08_DeleteAccount_CheckDeleteSuccessfully - Step 06: Verify message Account Deleted Successfully");
		verifyTrue(deleteAccountPage.isAccountDeletedSuccessfully());
		
		log.info("Payment_TC08_DeleteAccount_CheckDeleteSuccessfully - Step 07: Click on Submit button");
		deleteAccountPage.clickToOKButton();
		
		log.info("Payment_TC08_DeleteAccount_CheckDeleteSuccessfully - Step 08: Verify deleted account does not exist");
		deleteAccountPage = (DeleteAccountPageObject)deleteAccountPage.openDynamicPage(driver, "Delete Account");
		Assert.assertTrue(deleteAccountPage.isDeleteAccountFormDisplayed());
		deleteAccountPage.inputToAccountNoTextbox(createdAccountID);
		deleteAccountPage.clickToSubmitButton();
		verifyTrue(deleteAccountPage.isMessageDeleteThisAccountDisplayed());
		deleteAccountPage.clickToOKButton();
		verifyTrue(deleteAccountPage.isAccountNotExist());
		deleteAccountPage.clickToOKButton();
		
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}
	
	@Test
	public void Payment_TC09_DeleteCustomer_CheckDeleteSuccessfully(Method testMethod) {

		log.info("=========== START: " + testMethod.getName() + " ===========");
		
		log.info("Payment_TC09_DeleteCustomer_CheckDeleteSuccessfully - Step 01: Open Delete Account Form");
		deleteCustomerPage = (DeleteCustomerPageObject) deleteAccountPage.openDynamicPage(driver, "Delete Customer");
		Assert.assertTrue(deleteCustomerPage.isDeleteCustomerFormDisplayed());
		
		log.info("Payment_TC09_DeleteCustomer_CheckDeleteSuccessfully - Step 02: Input Customer ID");
		deleteCustomerPage.inputToCustomerIDTextbox(createdCustomerID);
		
		log.info("Payment_TC09_DeleteCustomer_CheckDeleteSuccessfully - Step 03: Click on Submit button");
		deleteCustomerPage.clickToSubmitButton();
		
		log.info(
				"Payment_TC09_DeleteCustomer_CheckDeleteSuccessfully - Step 04: Verify Message Delete This Customer Displaye");
		verifyTrue(deleteCustomerPage.isMessageDeleteThisCustomerDisplayed());
		
		log.info("Payment_TC09_DeleteCustomer_CheckDeleteSuccessfully - Step 05: Click on Submit button");
		deleteCustomerPage.clickToOKButton();
		
		log.info(
				"Payment_TC09_DeleteCustomer_CheckDeleteSuccessfully - Step 06: Verify message Account Deleted Successfully");
		verifyTrue(deleteCustomerPage.isCustomerDeletedSuccessfully());
		
		log.info("Payment_TC09_DeleteCustomer_CheckDeleteSuccessfully - Step 07: Click on Submit button");
		deleteCustomerPage.clickToOKButton();
		
		log.info("Payment_TC09_DeleteCustomer_CheckDeleteSuccessfully - Step 08: Verify deleted account does not exist");
		deleteCustomerPage = (DeleteCustomerPageObject) deleteCustomerPage.openDynamicPage(driver, "Delete Customer");
		Assert.assertTrue(deleteCustomerPage.isDeleteCustomerFormDisplayed());
		deleteCustomerPage.inputToCustomerIDTextbox(createdAccountID);
		deleteCustomerPage.clickToSubmitButton();
		verifyTrue(deleteCustomerPage.isMessageDeleteThisCustomerDisplayed());
		deleteCustomerPage.clickToOKButton();
		verifyTrue(deleteCustomerPage.isCustomerNotExist());
		deleteCustomerPage.clickToOKButton();
		
		log.info("=========== END: " + testMethod.getName() + " ===========");
	}
	@AfterClass
	public void afterClass() {
		closeBrowserAndDriver(driver);
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
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;
	
	private	String newCustomerName = "AUTOMATION TESTING";
	private	String newDob = "01-01-1989";
	private String newGender = "f";
	private String expectedGender = "female";
	private String expectedDOB = "1989-01-01";
	private	String newAdress = "PO Boc 911 8331 Duis Avenue";
	private	String newCity = "Tampa";
	private	String newState = "FL";
	private	String newPin = "466250";
	private	String newTelephoneNumber = "4555442476";
	private	String newEmail = "v_" + getCurrentDateTime() + "@mailinator.com";
	private	String newPassword = "automation";
	private	String createdCustomerID;

	private	String editAdress = "1883 Cursus Avenue";
	private	String editCity = "Houston";
	private	String editState = "Texas";
	private	String editPin = "166455";
	private	String editTelephoneNumber = "4779728081";
	private	String editEmail = "e_v_" + getCurrentDateTime() + "@gmail.com";
		
		
		// Account
	private	String accountType = "Savings";
	private	String initialDeposit = "50000";
	private	String createdAccountID;
		
		// Transfer
	private	String amountTransfer = "5000";
	private	String descriptionDeposit = "Deposit";
	private	String transactionID;
	private	String currentBalance;
		
		// Withdraw
	private	String amountWithdraw = "15000";
	private	String descriptionWithdraw = "Withdraw";
	private	String transactionIDWithdraw;

		// Fund transfer
	private	String accountPayeesNo = "57202";
	private	String amountTransferIntoOtherAccount = "10000";
	private	String descriptionTransfer = "Transfer";
	private String currentDate = "" + getCurrentDate();
	private String typeOfTransactionDeposit = "Deposit";
	private String typeOfTransactionWithdrawal = "Withdrawal";
	

}
