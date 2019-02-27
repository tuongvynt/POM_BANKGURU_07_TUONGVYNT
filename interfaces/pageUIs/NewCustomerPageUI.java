package pageUIs;


public class NewCustomerPageUI {
	public static final String HOMEPAGE_WELCOME_MESSAGE = "//marquee[text()= \"Welcome To Manager's Page of Guru99 Bank\"]";
	public static final String CUSTOMER_REGISTERED_SUCCESSFULLY_MESSAGE = "//p[text()= 'Customer Registered Successfully!!!']";
	public static final String NEW_CUSTOMER_TEXT = "//p[text()='Add New Customer']";
	public static final String NEW_CUSTOMER_FORM = "//form[@name='addcust']";
	public static final String CUSTOMER_NAME_TEXTBOX = "//input[@name='name']";
	public static final String GENDER_RADIO_BUTTON = "//input[@name='rad1' and @value ='f']";
	public static final String DATEOFBIRTH_TEXTBOX = "//input[@name='dob']";
	public static final String ADDRESS_TEXTBOX = "//textarea[@name='addr']";
	public static final String CITY_TEXTBOX = "//input[@name='city']";
	public static final String STATE_TEXTBOX = "//input[@name='state']";
	public static final String PIN_TEXTBOX = "//input[@name='pinno']";
	public static final String TELEPHONENO_TEXTBOX = "//input[@name='telephoneno']";
	public static final String EMAIL_TEXTBOX = "//input[@name='emailid']";
	public static final String PASSWORD_TEXTBOX = "//input[@name='password']";
	public static final String SUBMIT_BUTTON = "//input[@type='submit']";
	public static final String RESET_BUTTON = "//input[@name='res']";
	public static final String HOME_LINK = "//a[text()='Home']";
	public static final String CUSTOMERID_TEXT = "//td[text()='Customer ID']/following-sibling::td[1]";
	
}
