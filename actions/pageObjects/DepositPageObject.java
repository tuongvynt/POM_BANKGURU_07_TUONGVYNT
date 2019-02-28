package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.DepositPageUI;
import pageUIs.NewAccountPageUI;

public class DepositPageObject extends AbstractPage{
	WebDriver driver;
	
	public DepositPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public boolean isDepositPageDisplayed() {
		waitToElementVisible(driver, DepositPageUI.DEPOSIT_TEXT);
		return isControlDisplayed(driver, DepositPageUI.DEPOSIT_TEXT);
	}
	
	public void inputToAccountNoTextbox(String accountNo) {
		waitToElementVisible(driver, DepositPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeysToElement(driver, DepositPageUI.ACCOUNT_NO_TEXTBOX, accountNo);	
	}
	
	public void inputToAmountTextbox(String amount) {
		waitToElementVisible(driver, DepositPageUI.AMOUNT_TEXTBOX);
		sendKeysToElement(driver, DepositPageUI.AMOUNT_TEXTBOX, amount);	
	}
	
	public void inputToDescriptionTextbox(String description) {
		waitToElementVisible(driver, DepositPageUI.DESCRIPTION_TEXTBOX);
		sendKeysToElement(driver, DepositPageUI.DESCRIPTION_TEXTBOX, description);	
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver,NewAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewAccountPageUI.SUBMIT_BUTTON);
	}
	
	public void clickToResetButton() {
		waitToElementVisible(driver,NewAccountPageUI.RESET_BUTTON);
		clickToElement(driver, NewAccountPageUI.RESET_BUTTON);
	}
	
	public HomePageObject clickToHomeLink() {
		waitToElementVisible(driver,NewAccountPageUI.HOME_LINK);
		clickToElement(driver, NewAccountPageUI.HOME_LINK);
		return PageFactoryManager.getHomePage(driver);
	}
		
	public boolean isTransactionCreatedSuccessfully(String accountNo) {
		waitToElementVisible(driver, DepositPageUI.TRANSACTION_CREATED_SUCCESSFULLY_MESSAGE, accountNo);
		return isControlDisplayed(driver, DepositPageUI.TRANSACTION_CREATED_SUCCESSFULLY_MESSAGE, accountNo);
	}

	public String getCurrentBalanceText() {
		waitToElementVisible(driver, DepositPageUI.CURRENT_BALANCE_TEXT);
		return getTextInElement(driver, DepositPageUI.CURRENT_BALANCE_TEXT);
	}

	public String getTransactionIDText() {
		waitToElementVisible(driver, DepositPageUI.TRANSACTION_ID_TEXT);
		return getTextInElement(driver, DepositPageUI.TRANSACTION_ID_TEXT);
	}

	public String calculateBalance(String initialDeposit, String amountTransfer) {
		String calculatedBalance = Integer.toString(Integer.parseInt(initialDeposit) + Integer.parseInt(amountTransfer));
		return calculatedBalance;
	}
}
