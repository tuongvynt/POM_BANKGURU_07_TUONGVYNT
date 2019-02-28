package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.EditCustomerPageUI;
import pageUIs.NewCustomerPageUI;

public class EditCustomerPageObject extends AbstractPage{
	WebDriver driver;
	
	public EditCustomerPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isEditCustomerFormDisplayed() {
		waitToElementVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_FORM_TEXT);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_CUSTOMER_FORM_TEXT);
	}
	
	public boolean isEditCustomerPageDisplayed() {
		waitToElementVisible(driver, EditCustomerPageUI.EDIT_CUSTOMER_PAGE_TEXT);
		return isControlDisplayed(driver, EditCustomerPageUI.EDIT_CUSTOMER_PAGE_TEXT);
	}

	public void inputToCustomerIDTextbox(String customerID) {
		waitToElementVisible(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.CUSTOMER_ID_TEXTBOX, customerID);	
	}
	
	
	public void inputToAddressTextbox(String customerAddress) {
		waitToElementVisible(driver, EditCustomerPageUI.ADDRESS_TEXTBOX);
		clearTextInElement(driver,EditCustomerPageUI.ADDRESS_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.ADDRESS_TEXTBOX, customerAddress);	
	}
	
	
	public void inputToCityTextbox(String customerCity) {
		waitToElementVisible(driver, EditCustomerPageUI.CITY_TEXTBOX);
		clearTextInElement(driver,EditCustomerPageUI.CITY_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.CITY_TEXTBOX, customerCity);	
	}
	
	public void inputToStateTextbox(String customerState) {
		waitToElementVisible(driver, EditCustomerPageUI.STATE_TEXTBOX);
		clearTextInElement(driver,EditCustomerPageUI.STATE_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.STATE_TEXTBOX, customerState);	
	}
	
	public void inputToPinTextbox(String customerPin) {
		waitToElementVisible(driver, EditCustomerPageUI.PIN_TEXTBOX);
		clearTextInElement(driver,EditCustomerPageUI.PIN_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.PIN_TEXTBOX, customerPin);	
	}
	
	public void inputToTelephoneNumberTextbox(String customerTelephoneNumber) {
		waitToElementVisible(driver, EditCustomerPageUI.TELEPHONENO_TEXTBOX);
		clearTextInElement(driver,EditCustomerPageUI.TELEPHONENO_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.TELEPHONENO_TEXTBOX, customerTelephoneNumber);	
	}
	
	public void inputToEmailTextbox(String customerEmail) {
		waitToElementVisible(driver, EditCustomerPageUI.EMAIL_TEXTBOX);
		clearTextInElement(driver,EditCustomerPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, EditCustomerPageUI.EMAIL_TEXTBOX, customerEmail);	
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver,EditCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, EditCustomerPageUI.SUBMIT_BUTTON);
	}
	
	public void clickToResetButton() {
		waitToElementVisible(driver,EditCustomerPageUI.RESET_BUTTON);
		clickToElement(driver, EditCustomerPageUI.RESET_BUTTON);
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
