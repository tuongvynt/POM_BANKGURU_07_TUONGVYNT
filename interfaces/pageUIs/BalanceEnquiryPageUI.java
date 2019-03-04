package pageUIs;


public class BalanceEnquiryPageUI {
	public static final String BALANCE_DETAILS_MESSAGE = "//p[text()= 'Balance Details for Account %s']";
	public static final String BALANCE_ENQUIRY_FORM_TEXT = "//p[text()='Balance Enquiry Form']";
	public static final String ACCOUNT_NO_TEXTBOX = "//input[@name='accountno']";
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	public static final String RESET_BUTTON = "//input[@name='res']";
	public static final String HOME_LINK = "//a[text()='Home']";
	
	public static final String CUSTOMERID_TEXT = "//td[text()='Account No']/following-sibling::td[1]";
	public static final String TYPE_OF_ACCOUNT_TEXT = "//td[text()='Type of Account']/following-sibling::td[1]";
	public static final String BALANCE_TEXT = "//td[text()='Balance']/following-sibling::td[1]";
	
}
