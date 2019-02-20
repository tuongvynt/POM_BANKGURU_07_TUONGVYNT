package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.FundTransferPageUI;

public class FundTransferPageObject extends AbstractPage{
	WebDriver driver;
	
	public FundTransferPageObject (WebDriver driverMapping) {
		driver = driverMapping;
	}
	
	public boolean isFundTransferPageDisplayed() {
		waitToElementVisible(driver, FundTransferPageUI.FUND_TRANSFER_TEXT);
		return isControlDisplayed(driver, FundTransferPageUI.FUND_TRANSFER_TEXT);
	}

}
