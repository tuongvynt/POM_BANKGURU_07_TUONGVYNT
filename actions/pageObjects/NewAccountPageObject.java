package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.HomePageUI;
import bankguru.NewAccountPageUI;
import commons.AbstractPage;

public class NewAccountPageObject extends AbstractPage{
	WebDriver driver;
	
	public NewAccountPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public boolean isNewAccountPageDisplayed() {
		waitToElementVisible(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
		return isControlDisplayed(driver, NewAccountPageUI.NEW_ACCOUNT_TEXT);
	}

}
