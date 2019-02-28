package pageUIs;

public class NewAccountPageUI {
	public static final String HOMEPAGE_WELCOME_MESSAGE = "//marquee[text()= \"Welcome To Manager's Page of Guru99 Bank\"]";
	public static final String ACCOUNT_GENERATED_SUCCESSFULLY_MESSAGE = "//p[text()= 'Account Generated Successfully!!!']";
	public static final String NEW_ACCOUNT_TEXT = "//p[text()='Add new account form']";
	public static final String ACCOUNT_ID_TEXTBOX = "//input[@name='cusid']";
	public static final String ACCOUNT_TYPE_DROPDOWNLIST = "//select[@name='selaccount']";
	public static final String INITIAL_DEPOSIT_TEXTBOX = "//input[@name='inideposit']";
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	public static final String RESET_BUTTON = "//input[@name='res']";
	public static final String HOME_LINK = "//a[text()='Home']";
	public static final String CURRENT_AMOUNT_TEXT = "//td[text()='Current Amount']/following-sibling::td[1]";
	public static final String ACCOUNT_ID_TEXT = "//td[text()='Account ID']/following-sibling::td[1]";
}
