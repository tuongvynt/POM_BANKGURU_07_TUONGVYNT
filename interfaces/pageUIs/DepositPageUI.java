package pageUIs;

public class DepositPageUI {
	public static final String HOMEPAGE_WELCOME_MESSAGE = "//marquee[text()= \"Welcome To Manager's Page of Guru99 Bank\"]";
	public static final String DEPOSIT_TEXT = "//p[text()='Amount Deposit Form']"; 
	public static final String TRANSACTION_CREATED_SUCCESSFULLY_MESSAGE = "//p[text()='Transaction details of Deposit for Account %s']";
	public static final String ACCOUNT_NO_TEXTBOX = "//input[@name='accountno']";
	public static final String AMOUNT_TEXTBOX = "//input[@name='ammount']";
	public static final String DESCRIPTION_TEXTBOX = "//input[@name='desc']";
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	public static final String RESET_BUTTON = "//input[@name='res']";
	public static final String HOME_LINK = "//a[text()='Home']";
	public static final String CURRENT_BALANCE_TEXT = "//td[text()='Current Balance']/following-sibling::td[1]";
	public static final String TRANSACTION_ID_TEXT = "//td[text()='Transaction ID']/following-sibling::td[1]";
}
