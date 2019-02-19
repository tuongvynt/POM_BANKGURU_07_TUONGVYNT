package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.HomePageUI;
import bankguru.NewCustomerPageUI;
import commons.AbstractPage;

public class NewCustomerPageObject extends AbstractPage{
	WebDriver driver;
	
	public NewCustomerPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}

	public boolean isNewCustomerPageDisplayed() {
		waitToElementVisible(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlDisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}

}
