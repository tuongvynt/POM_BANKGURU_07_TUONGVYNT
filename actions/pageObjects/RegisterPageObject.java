package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;
	
	public RegisterPageObject(WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public void inputToUserEmailTextbox(String email) {
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}
	
	public void clickToSubmitButton() {
		waitToElementVisible(driver,RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);

	}
	
	public String getUserIDText() {
		waitToElementVisible(driver, RegisterPageUI.USERID_TEXTBOX);
		return getTextInElement(driver, RegisterPageUI.USERID_TEXTBOX);
		 
	}
	
	public String getPasswordText() {
		waitToElementVisible(driver,RegisterPageUI.PASSWORD_TEXTBOX);
		return getTextInElement(driver, RegisterPageUI.PASSWORD_TEXTBOX);

	}
	
	public LoginPageObject openLoginPage(String loginPageURL) {
		openURL(driver, loginPageURL);
		return PageFactoryManager.getLoginPage(driver);

	}
	
}
