package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.LoginPageUI;
import pageUIs.NewCustomerPageUI;
import pageUIs.RegisterPageUI;

public class NewCustomerPageObject extends AbstractPage{
	WebDriver driver;
	
	public NewCustomerPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isNewCustomerPageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}

	public boolean isHomePageDisplayed() {
		waitToElementVisible(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		return isControlDisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
	}
	

	public boolean isHomePageUndisplayed() {
		waitToElementInvisible(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE_2);
		return isControlUndisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE_2);
	}
	

	public boolean isAddCustomerFormUndisplayed() {
		waitToElementInvisible(driver, NewCustomerPageUI.NEW_CUSTOMER_FORM);
		return isControlUndisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_FORM);
	}
	
	public void inputToCustomerNameTextbox(String customerName) {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.CUSTOMER_NAME_TEXTBOX, customerName);	
	}
	
	public void clickToGenderRadioButton() {
		waitToElementVisible(driver,NewCustomerPageUI.GENDER_RADIO_BUTTON);
		clickToElement(driver, NewCustomerPageUI.GENDER_RADIO_BUTTON);
	}
	
	public void inputToAddressTextbox(String customerAddress) {
		waitToElementVisible(driver, NewCustomerPageUI.ADDRESS_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.ADDRESS_TEXTBOX, customerAddress);	
	}
	
	public void inputToDateOfBirthTextbox(String customerDateOfBirth) {
		waitToElementVisible(driver, NewCustomerPageUI.DATEOFBIRTH_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.DATEOFBIRTH_TEXTBOX, customerDateOfBirth);	
	}
	
	public void inputToCityTextbox(String customerCity) {
		waitToElementVisible(driver, NewCustomerPageUI.CITY_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.CITY_TEXTBOX, customerCity);	
	}
	
	public void inputToStateTextbox(String customerState) {
		waitToElementVisible(driver, NewCustomerPageUI.STATE_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.STATE_TEXTBOX, customerState);	
	}
	
	public void inputToPinTextbox(String customerPin) {
		waitToElementVisible(driver, NewCustomerPageUI.PIN_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.PIN_TEXTBOX, customerPin);	
	}
	
	public void inputToTelephoneNumberTextbox(String customerTelephoneNumber) {
		waitToElementVisible(driver, NewCustomerPageUI.TELEPHONENO_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.TELEPHONENO_TEXTBOX, customerTelephoneNumber);	
	}
	
	public void inputToEmailTextbox(String customerEmail) {
		waitToElementVisible(driver, NewCustomerPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.EMAIL_TEXTBOX, customerEmail);	
	}
	
	public void inputToPasswordTextbox(String customerPassword) {
		waitToElementVisible(driver, NewCustomerPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, NewCustomerPageUI.PASSWORD_TEXTBOX, customerPassword);	
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver,NewCustomerPageUI.SUBMIT_BUTTON);
		clickToElement(driver, NewCustomerPageUI.SUBMIT_BUTTON);
	}
	
	public void clickToResetButton() {
		waitToElementVisible(driver,NewCustomerPageUI.RESET_BUTTON);
		clickToElement(driver, NewCustomerPageUI.RESET_BUTTON);
	}
	
	public HomePageObject clickToHomeLink() {
		waitToElementVisible(driver,NewCustomerPageUI.HOME_LINK);
		clickToElement(driver, NewCustomerPageUI.HOME_LINK);
		return PageFactoryManager.getHomePage(driver);
	}

	public boolean isCustomerRegisteredSuccessfully() {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMER_REGISTERED_SUCCESSFULLY_MESSAGE);
		return isControlDisplayed(driver, NewCustomerPageUI.CUSTOMER_REGISTERED_SUCCESSFULLY_MESSAGE);
	}
	
	public String getCustomerIDText() {
		waitToElementVisible(driver, NewCustomerPageUI.CUSTOMERID_TEXT);
		return getTextInElement(driver, NewCustomerPageUI.CUSTOMERID_TEXT);
	}

}
