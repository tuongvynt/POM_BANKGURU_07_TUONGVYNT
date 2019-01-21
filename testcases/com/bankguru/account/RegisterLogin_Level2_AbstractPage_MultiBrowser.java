package com.bankguru.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;

public class RegisterLogin_Level2_AbstractPage_MultiBrowser extends AbstractTest {
	private WebDriver driver;
	private AbstractPage abstractPage;
	private String loginUrl, email, userID, password;

  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
			driver = openMultiBrowser(browserName);
			
			abstractPage = new AbstractPage();
			email  = "nttvy_" +randomNumber() +"@mailinator.com";
	  System.out.println("Email = " + email);
  }

  @Test
	public void TC01_RegisterToSystem() {

		abstractPage.openURL(driver, "http://demo.guru99.com/v4/index.php");

		loginUrl = abstractPage.getCurrentURL(driver);

		abstractPage.clickToElement(driver, "//a[text() ='here']");
		Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//input[@name='emailid']"));

		abstractPage.sendKeysToElement(driver, "//input[@name='emailid']", email);
		abstractPage.clickToElement(driver, "//input[@name= 'btnLogin']");
		userID = abstractPage.getTextInElement(driver, "//td[text() ='User ID :']/following-sibling::td");
		password = abstractPage.getTextInElement(driver, "//td[text() ='Password :']/following-sibling::td");

		System.out.println("UserID =" + userID);
		System.out.println("Password =" + password);
	}

	@Test
	public void TC02_LoginWithAboveInformation() {
		abstractPage.openURL(driver, loginUrl);
		abstractPage.sendKeysToElement(driver, "//input[@name='uid']", userID);
		abstractPage.sendKeysToElement(driver, "//input[@name='password']", password);
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");
		Assert.assertTrue(abstractPage.isControlDisplayed(driver,
				"//marquee[text()= \"Welcome To Manager's Page of Guru99 Bank\"]"));
		Assert.assertTrue(abstractPage.isControlDisplayed(driver, "//td[text() ='Manger Id : " + userID + "']"));
	}


	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(999999);
		return number;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
