package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;
import pageUIs.NewCustomerPageUI;

public class HomePageObject extends AbstractPage{
	WebDriver driver;
	
	public HomePageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public boolean isHomePageDisplayed() {
		waitToElementVisible(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		boolean status = isControlDisplayed(driver, HomePageUI.HOMEPAGE_WELCOME_MESSAGE);
		System.out.println("Home page displayed status =" + status);
		return status;
	}

	public boolean isNewCustomerPageUnDisplayed() {
		waitToElementInvisible(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
		return isControlUndisplayed(driver, NewCustomerPageUI.NEW_CUSTOMER_TEXT);
	}

}
