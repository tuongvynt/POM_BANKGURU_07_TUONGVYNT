package pageUIs;

public class FundTransferPageUI {
	public static final String HOMEPAGE_WELCOME_MESSAGE = "//marquee[text()= \"Welcome To Manager's Page of Guru99 Bank\"]";
	public static final String FUND_TRANSFER_TEXT = "//p[text()='Fund transfer']";
	public static final String TRANSACTION_CREATED_SUCCESSFULLY_MESSAGE = "//p[text()='Fund Transfer Details']";
	public static final String PAYERS_ACCOUNT_NO_TEXTBOX = "//input[@name='payersaccount']";
	public static final String PAYEES_ACCOUNT_NO_TEXTBOX = "//input[@name='payeeaccount']";
	public static final String AMOUNT_TEXTBOX = "//input[@name='ammount']";
	public static final String DESCRIPTION_TEXTBOX = "//input[@name='desc']";
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	public static final String RESET_BUTTON = "//input[@name='res']";
	public static final String HOME_LINK = "//a[text()='Home']";
	public static final String AMOUNT_TEXT = "//td[text()='Amount']/following-sibling::td[1]";
	public static final String FROM_ACCOUNT_NO_TEXT = "//td[text()='From Account Number']/following-sibling::td[1]";
	public static final String TO_ACCOUNT_NO_TEXT = "//td[text()='To Account Number']/following-sibling::td[1]";
	public static final String DESCRIPTION_TEXT = "//td[text()='Description']/following-sibling::td[1]";	
}
