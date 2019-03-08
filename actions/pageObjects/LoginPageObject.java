package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

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
	  
	public HomePageObject clickToLoginButton() throws Exception {
		waitToElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
		
		if (driver.toString().toLowerCase().contains("internetexplorer")){
			clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
			Thread.sleep(5000);
		} else {
			clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		}
		
		return PageFactoryManager.getHomePage(driver);
	}
	
	public RegisterPageObject clickToHereLink() throws Exception {
		waitToElementVisible(driver,LoginPageUI.HERE_LINK);
		if (driver.toString().toLowerCase().contains("internetexplorer")){
			clickToElementByJS(driver, LoginPageUI.HERE_LINK);
			Thread.sleep(5000);
		} else {
			clickToElement(driver, LoginPageUI.HERE_LINK);
		}
		return PageFactoryManager.getRegisterPage(driver);

	}
}
