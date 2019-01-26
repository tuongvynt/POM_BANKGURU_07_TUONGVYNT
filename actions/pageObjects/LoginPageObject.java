package pageObjects;

import org.openqa.selenium.WebDriver;

import bankguru.LoginPageUI;
import commons.AbstractPage;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;
	
	public LoginPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public String getLoginPageURL() {
		return getCurrentURL(driver);
	}
	
	public void inputToUserIDTextbox(String userID) {
		waitToElementVisible(driver, LoginPageUI.USERID_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.USERID_TEXTBOX, userID);
		
	}

	public void inputToUserIDPasswordTextbox(String password) {
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}
	
	public void clickToLoginButton() {
		waitToElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
	public void clickToHereLink() {
		waitToElementVisible(driver,LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);

	}
}
