package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

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
	
	public boolean isAddNewCustomerFormDisplayed() {
		waitToElementInvisible(driver, NewCustomerPageUI.NEW_CUSTOMER_FORM);
		return isControlUndisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_FORM);
	}

	public boolean isHomePageUndisplayed() {
		waitToElementInvisible(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		return isControlUndisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
	}
	
	public boolean isHomePageUnDisplayed() {
		waitToElementInvisible(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		return isControlUndisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
	}

	public boolean isAddCustomerFormUnDisplay() {
		waitToElementInvisible(driver, NewCustomerPageUI.NEW_CUSTOMER_FORM);
		return isControlUndisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_FORM);
	}

}
