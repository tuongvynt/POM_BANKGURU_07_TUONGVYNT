package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.FundTransferPageUI;
import pageUIs.WithdrawalPageUI;

public class FundTransferPageObject extends AbstractPage{
	WebDriver driver;
	
	public FundTransferPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public boolean isFundTransferPageDisplayed() {
		waitToElementVisible(driver, FundTransferPageUI.FUND_TRANSFER_TEXT);
		return isControlDisplayed(driver, FundTransferPageUI.FUND_TRANSFER_TEXT);
	}

	public void inputToPayersAccountNoTextbox(String accountPayersNo) {
		waitToElementVisible(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX);
		sendKeysToElement(driver, FundTransferPageUI.PAYERS_ACCOUNT_NO_TEXTBOX, accountPayersNo);	
	}
	
	public void inputToPayeesAccountNoTextbox(String accountPayeesNo) {
		waitToElementVisible(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX);
		sendKeysToElement(driver, FundTransferPageUI.PAYEES_ACCOUNT_NO_TEXTBOX, accountPayeesNo);	
	}
	
	public void inputToAmountTextbox(String amount) {
		waitToElementVisible(driver, FundTransferPageUI.AMOUNT_TEXTBOX);
		sendKeysToElement(driver, FundTransferPageUI.AMOUNT_TEXTBOX, amount);	
	}
	
	public void inputToDescriptionTextbox(String description) {
		waitToElementVisible(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX);
		sendKeysToElement(driver, FundTransferPageUI.DESCRIPTION_TEXTBOX, description);	
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver,FundTransferPageUI.SUBMIT_BUTTON);
		clickToElement(driver, FundTransferPageUI.SUBMIT_BUTTON);
	}
	
	public void clickToResetButton() {
		waitToElementVisible(driver,FundTransferPageUI.RESET_BUTTON);
		clickToElement(driver, FundTransferPageUI.RESET_BUTTON);
	}
	
	public HomePageObject clickToHomeLink() {
		waitToElementVisible(driver,FundTransferPageUI.HOME_LINK);
		clickToElement(driver, FundTransferPageUI.HOME_LINK);
		return PageFactoryManager.getHomePage(driver);
	}
		
	public boolean isTransferSuccessfully() {
		waitToElementVisible(driver, FundTransferPageUI.TRANSACTION_CREATED_SUCCESSFULLY_MESSAGE);
		return isControlDisplayed(driver, FundTransferPageUI.TRANSACTION_CREATED_SUCCESSFULLY_MESSAGE);
	}

	public String getAmountText() {
		waitToElementVisible(driver, FundTransferPageUI.AMOUNT_TEXT);
		return getTextInElement(driver, FundTransferPageUI.AMOUNT_TEXT);
	}
	
	public String transferMoney(String currentBalance, String amountTransfer) {
		currentBalance = Integer.toString(Integer.parseInt(currentBalance) - Integer.parseInt(amountTransfer));
		return currentBalance;
	}
}
