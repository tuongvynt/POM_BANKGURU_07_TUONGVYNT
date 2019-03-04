package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.BalanceEnquiryPageUI;
import pageUIs.EditCustomerPageUI;
import pageUIs.NewCustomerPageUI;

public class BalanceEnquiryPageObject extends AbstractPage{
	WebDriver driver;
	
	public BalanceEnquiryPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isBalanceEnquiryFormDisplayed() {
		waitToElementVisible(driver, BalanceEnquiryPageUI.BALANCE_ENQUIRY_FORM_TEXT);
		return isControlDisplayed(driver, BalanceEnquiryPageUI.BALANCE_ENQUIRY_FORM_TEXT);
	}
	
	public void inputToAccountNoTextbox(String accountNo) {
		waitToElementVisible(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeysToElement(driver, BalanceEnquiryPageUI.ACCOUNT_NO_TEXTBOX, accountNo);	
	}
		
	public void clickToSubmitButton() {
		waitToElementVisible(driver,BalanceEnquiryPageUI.SUBMIT_BUTTON);
		clickToElement(driver, BalanceEnquiryPageUI.SUBMIT_BUTTON);
	}
	
	public void clickToResetButton() {
		waitToElementVisible(driver,BalanceEnquiryPageUI.RESET_BUTTON);
		clickToElement(driver, BalanceEnquiryPageUI.RESET_BUTTON);
	}
	
	public HomePageObject clickToHomeLink() {
		waitToElementVisible(driver,BalanceEnquiryPageUI.HOME_LINK);
		clickToElement(driver, BalanceEnquiryPageUI.HOME_LINK);
		return PageFactoryManager.getHomePage(driver);
	}

	public boolean isGetBalanceDetailsSuccessfully(String accountNo) {
		waitToElementVisible(driver, BalanceEnquiryPageUI.BALANCE_DETAILS_MESSAGE, accountNo);
		return isControlDisplayed(driver, BalanceEnquiryPageUI.BALANCE_DETAILS_MESSAGE, accountNo);
	}
	
	public String getBalanceText() {
		waitToElementVisible(driver, BalanceEnquiryPageUI.BALANCE_TEXT);
		return getTextInElement(driver, BalanceEnquiryPageUI.BALANCE_TEXT);	 
	}
	
	public String transferMoney(String currentBalance, String amountTransfer) {
		currentBalance = Integer.toString(Integer.parseInt(currentBalance) - Integer.parseInt(amountTransfer));
		return currentBalance;
	}

}
