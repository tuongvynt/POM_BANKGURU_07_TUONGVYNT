package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DepositPageUI;
import pageUIs.NewAccountPageUI;
import pageUIs.WithdrawalPageUI;

public class WithdrawalPageObject extends AbstractPage{
	WebDriver driver;
	
	public WithdrawalPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public boolean isWithdrawalPageDisplayed() {
		waitToElementVisible(driver, WithdrawalPageUI.WITHDRAWAL_TEXT);
		return isControlDisplayed(driver, WithdrawalPageUI.WITHDRAWAL_TEXT);
	}

	public void inputToAccountNoTextbox(String accountNo) {
		waitToElementVisible(driver, WithdrawalPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeysToElement(driver, WithdrawalPageUI.ACCOUNT_NO_TEXTBOX, accountNo);	
	}
	
	public void inputToAmountTextbox(String amount) {
		waitToElementVisible(driver, WithdrawalPageUI.AMOUNT_TEXTBOX);
		sendKeysToElement(driver, WithdrawalPageUI.AMOUNT_TEXTBOX, amount);	
	}
	
	public void inputToDescriptionTextbox(String description) {
		waitToElementVisible(driver, WithdrawalPageUI.DESCRIPTION_TEXTBOX);
		sendKeysToElement(driver, WithdrawalPageUI.DESCRIPTION_TEXTBOX, description);	
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver,WithdrawalPageUI.SUBMIT_BUTTON);
		clickToElement(driver, WithdrawalPageUI.SUBMIT_BUTTON);
	}
	
	public void clickToResetButton() {
		waitToElementVisible(driver,WithdrawalPageUI.RESET_BUTTON);
		clickToElement(driver, WithdrawalPageUI.RESET_BUTTON);
	}
	
	public HomePageObject clickToHomeLink() {
		waitToElementVisible(driver,WithdrawalPageUI.HOME_LINK);
		clickToElement(driver, WithdrawalPageUI.HOME_LINK);
		return PageFactoryManager.getHomePage(driver);
	}
		
	public boolean isTransactionCreatedSuccessfully(String accountNo) {
		waitToElementVisible(driver, WithdrawalPageUI.TRANSACTION_CREATED_SUCCESSFULLY_MESSAGE, accountNo);
		return isControlDisplayed(driver, WithdrawalPageUI.TRANSACTION_CREATED_SUCCESSFULLY_MESSAGE, accountNo);
	}

	public String getCurrentBalanceText() {
		waitToElementVisible(driver, WithdrawalPageUI.CURRENT_BALANCE_TEXT);
		return getTextInElement(driver, WithdrawalPageUI.CURRENT_BALANCE_TEXT);
	}

	public String getTransactionIDText() {
		waitToElementVisible(driver, WithdrawalPageUI.TRANSACTION_ID_TEXT);
		return getTextInElement(driver, WithdrawalPageUI.TRANSACTION_ID_TEXT);
	}

	public String withdrawMoney(String currentBalance, String amountWithdraw) {
		String calculatedBalance = Integer.toString(Integer.parseInt(currentBalance) - Integer.parseInt(amountWithdraw));
		return calculatedBalance;
	}
}
