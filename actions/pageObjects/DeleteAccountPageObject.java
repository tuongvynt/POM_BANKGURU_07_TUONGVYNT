package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DeleteAccountPageUI;
import pageUIs.EditCustomerPageUI;
import pageUIs.NewCustomerPageUI;

public class DeleteAccountPageObject extends AbstractPage{
	WebDriver driver;
	
	public DeleteAccountPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isDeleteAccountFormDisplayed() {
		waitToElementVisible(driver, DeleteAccountPageUI.DELETE_ACCOUNT_FORM_TEXT);
		return isControlDisplayed(driver, DeleteAccountPageUI.DELETE_ACCOUNT_FORM_TEXT);
	}

	public void inputToAccountNoTextbox(String accountNo) {
		waitToElementVisible(driver, DeleteAccountPageUI.ACCOUNT_NO_TEXTBOX);
		sendKeysToElement(driver, DeleteAccountPageUI.ACCOUNT_NO_TEXTBOX, accountNo);	
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver,DeleteAccountPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DeleteAccountPageUI.SUBMIT_BUTTON);
	}
	
	public void clickToResetButton() {
		waitToElementVisible(driver,DeleteAccountPageUI.RESET_BUTTON);
		clickToElement(driver, DeleteAccountPageUI.RESET_BUTTON);
	}
	
	public boolean isMessageDeleteThisAccountDisplayed() {
		waitToAlertPresent(driver);
		if (getTextAlert(driver).equals(DeleteAccountPageUI.MESSAGE_DELETE_ACCOUNT_TEXT)) return true;
		else return false;
	}
	
	public boolean isAccountDeletedSuccessfully() {
		waitToAlertPresent(driver);
		if (getTextAlert(driver).equals(DeleteAccountPageUI.ACCOUNT_DELETED_SUCCESSFULLY_MESSAGE)) return true;
		else return false;
	}

	public boolean isAccountNotExist() {
		waitToAlertPresent(driver);
		if (getTextAlert(driver).equals(DeleteAccountPageUI.ACCOUNT_NOT_EXIST)) return true;
		else return false;
	}
	
	public void clickToOKButton() {
		waitToAlertPresent(driver);
		acceptAlert(driver);
	}
	
	public void clickToCancelButton() {
		waitToAlertPresent(driver);
		cancelAlert(driver);
	}
	
	public HomePageObject clickToHomeLink() {
		waitToElementVisible(driver,EditCustomerPageUI.HOME_LINK);
		clickToElement(driver, EditCustomerPageUI.HOME_LINK);
		return PageFactoryManager.getHomePage(driver);
	}

	public boolean isCustomerEditedSuccessfully() {
		waitToElementVisible(driver, EditCustomerPageUI.CUSTOMER_EDITED_SUCCESSFULLY_MESSAGE);
		return isControlDisplayed(driver, EditCustomerPageUI.CUSTOMER_EDITED_SUCCESSFULLY_MESSAGE);
	}
	
	public String getCustomerIDText() {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMERID_TEXT);
		return getTextInElement(driver, NewCustomerPageUI.CUSTOMERID_TEXT);	 
	}

	
}
