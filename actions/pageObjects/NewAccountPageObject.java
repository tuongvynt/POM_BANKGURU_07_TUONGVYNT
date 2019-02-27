package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.NewAccountPageUI;
import pageUIs.NewCustomerPageUI;

public class NewAccountPageObject extends AbstractPage{
	WebDriver driver;
	
	public NewAccountPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public boolean isNewAccountPageDisplayed() {
		waitToElementVisible(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
		return isControlDisplayed(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
	}

	public void inputToCustomerIDTextbox(String customerID) {
		waitToElementVisible(driver, NewAccountPageUI.ACCOUNT_ID_TEXTBOX);
		sendKeysToElement(driver, NewAccountPageUI.ACCOUNT_ID_TEXTBOX, customerID);	
	}
	
	public void inputToInitialDepositTextbox(String initialDeposit) {
		waitToElementVisible(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX);
		sendKeysToElement(driver, NewAccountPageUI.INITIAL_DEPOSIT_TEXTBOX, initialDeposit);	
	}
	
	public void selectAccountType(String accountType) {
		waitToElementVisible(driver, NewAccountPageUI.ACCOUNT_TYPE_DROPDOWNLIST);
		selectItemInHTMLDropDown(driver,NewAccountPageUI.ACCOUNT_TYPE_DROPDOWNLIST, accountType);	
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
	
	public boolean isAccountGeneratedSuccessfully() {
		waitToElementVisible(driver, NewAccountPageUI.ACCOUNT_GENERATED_SUCCESSFULLY_MESSAGE);
		return isControlDisplayed(driver, NewAccountPageUI.ACCOUNT_GENERATED_SUCCESSFULLY_MESSAGE);
	}
	
	public String getCurrentAmountText() {
		waitToElementVisible(driver, NewAccountPageUI.CURRENT_AMOUNT_TEXT);
		return getTextInElement(driver, NewAccountPageUI.CURRENT_AMOUNT_TEXT);
	}
}
