package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.DeleteCustomerPageUI;


public class DeleteCustomerPageObject extends AbstractPage{
	WebDriver driver;
	
	public DeleteCustomerPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isDeleteCustomerFormDisplayed() {
		waitToElementVisible(driver, DeleteCustomerPageUI.DELETE_CUSTOMER_FORM_TEXT);
		return isControlDisplayed(driver, DeleteCustomerPageUI.DELETE_CUSTOMER_FORM_TEXT);
	}

	public void inputToCustomerIDTextbox(String customerID) {
		waitToElementVisible(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeysToElement(driver, DeleteCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);	
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver,DeleteCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, DeleteCustomerPageUI.SUBMIT_BUTTON);
	}
	
	public void clickToResetButton() {
		waitToElementVisible(driver,DeleteCustomerPageUI.RESET_BUTTON);
		clickToElement(driver, DeleteCustomerPageUI.RESET_BUTTON);
	}
	
	public boolean isMessageDeleteThisCustomerDisplayed() {
		waitToAlertPresent(driver);
		if (getTextAlert(driver).equals(DeleteCustomerPageUI.MESSAGE_DELETE_CUSTOMER_TEXT)) return true;
		else return false;
	}
	
	public boolean isCustomerDeletedSuccessfully() {
		waitToAlertPresent(driver);
		if (getTextAlert(driver).equals(DeleteCustomerPageUI.CUSTOMER_DELETED_SUCCESSFULLY_MESSAGE)) return true;
		else return false;
	}

	public boolean isCustomerNotExist() {
		waitToAlertPresent(driver);
		if (getTextAlert(driver).equals(DeleteCustomerPageUI.CUSTOMER_NOT_EXIST)) return true;
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
		waitToElementVisible(driver,DeleteCustomerPageUI.HOME_LINK);
		clickToElement(driver, DeleteCustomerPageUI.HOME_LINK);
		return PageFactoryManager.getHomePage(driver);
	}
}
