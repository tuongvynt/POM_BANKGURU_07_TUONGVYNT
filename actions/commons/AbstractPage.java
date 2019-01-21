package commons;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium_api.Commons;

public class AbstractPage {

	/*
	 * Chuẩn chung: Tất cả những hàm có tiền tố là get thì thường sẽ trả lại kiểu dữ
	 * liệu (cần return) Tham số WebDriver trong hàm là bắt buộc Hàm này có cần thêm
	 * tham số gì ko? Hàm này có trả về gì ko/ trả về kiểu dữ liệu gì Nếu ko trả về:
	 * void Nếu trả về: kiểu dữ liệu trả về là gì thì hàm đó có cùng kiểu dữ liệu
	 */

	// WEB BROWSER
	// openURL
	public void openURL(WebDriver driver, String url) {
		driver.get(url);
	}

	// getCurrentURL
	public String getCurrentURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	// getPageTitle
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	// getPageSourceCode
	public String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}

	// back
	public void back(WebDriver driver) {
		driver.navigate().back();
	}

	// forward
	public void forward(WebDriver driver) {
		driver.navigate().forward();
	}

	// refresh
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}

	// Alert - acceptAlert
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// Alert - cancelAlert
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// Alert - sendKeysAlert
	public void sendKeysAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	// Alert - getTextAlert
	public void getTextAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	// Alert - waitToAlertPresent
	public void waitToAlertPresent(WebDriver driver) {
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

	// Windows - switchToWindowByID
	public void switchToWindowByID(WebDriver driver, String parentID) {
		// Get ra tat ca cac cua so dang co
		Set<String> allWindows = driver.getWindowHandles();
		// dung vong lap de kiem tra. Vong lap for x duyet qua tat ca cua so
		for (String runWindow : allWindows) {
			System.out.println(runWindow);
			// Moi lan duyet kiem tra dieu kien neu ID khac vs parentID thi no switch qua
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				// break khoi vong lap for khong kiem tra nua
				break;
			}
		}
	}

	// Windows - switchToWindowByTitle
	// Dung trong truong hop co tu 2 cua so tro len
	public void switchToWindowByTitle(WebDriver driver, String expectedTitle) {
		// Get ra tat ca cac cua so dang co
		Set<String> allWindows = driver.getWindowHandles();
		// Dung vong lap duyet qua tat ca cac ID
		for (String runWindows : allWindows) {

			// Switch qua tung cua so truoc sau do ms kiem tra
			driver.switchTo().window(runWindows);
			// Get ra title cua page moi switch
			String actualTitle = driver.getTitle();
			// Kiem tra neu title cua page = title truyen vao
			if (actualTitle.equals(expectedTitle)) {
				// Thoat khoi vong lap- ko kiem tra nhung thang khac nua
				break;
			}
		}
	}

	// Windows - closeAllWindowsWithoutParentWindows
	public void closeAllWindowsWithoutParentWindows(WebDriver driver, String parentWindowID) {
		// Get ra tat ca cac ID cua cac cua so
		Set<String> allWindows = driver.getWindowHandles();
		// Dung vong lap for de duyet qua tung ID
		for (String runWindows : allWindows) {
			// Neu ID khong bang parentID
			if (!runWindows.equals(parentWindowID)) {
				// No se switch qua
				driver.switchTo().window(runWindows);
				// Dong tab hien tai
				driver.close();
			}
		}
		// Chi con lai 1 cua so duy nhat (parent)
		driver.switchTo().window(parentWindowID);
	}

	// Windows - switchToIframe
	public void switchToIframe(WebDriver driver, String locator) {
		// Switch to lookingforiframe
		WebElement iFrame = driver.findElement(By.xpath(locator));
		driver.switchTo().frame(iFrame);
	}

	// Windows - switchToDefaultContent
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	// WEB ELEMENTS
	// clickToElement
	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	// sendKeys
	public void sendKeys(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(value);
	}

	// selectItemInHTMLDropDown
	public void selectItemInHTMLDropDown(WebDriver driver, String locator, String valueInDropdown) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		select.deselectByVisibleText(valueInDropdown);
	}

	// getSelectedItemInHTMLDropDown
	public String getSelectedItemInHTMLDropDown(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	// selectItemInCustomDropdown
	public void selectItemInCustomDropdown(WebDriver driver, String scrolltoXpath, String parentXpath,
			String childXpath, String expectedItem) {
		JavascriptExecutor javaExecutor = (JavascriptExecutor) driver;
		WebDriverWait waitExplicit = new WebDriverWait(driver, 10);

		// Scroll to Xpath
		WebElement elementToScroll = driver.findElement(By.xpath(scrolltoXpath));
		javaExecutor.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);

		// Click vào dropdown
		WebElement element = driver.findElement(By.xpath(parentXpath));
		element.click();

		// Get tất cả item trong dropdown vào 1 list element (List <WebElement>)
		List<WebElement> childList = driver.findElements(By.xpath(childXpath));

		// Wait để tất cả phần tử trong dropdown được hiển thị
		waitExplicit.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(childXpath))));

		// Dùng vòng lặp for duyệt qua từng phần tử sau đó getText
		for (WebElement child : childList) {
			String textItem = child.getText().trim();
			System.out.println("Item in dropdown - " + textItem);

			// Nếu actual text = expected text thì click vào phần tử đó và break khỏi vòng
			// lặp
			if (textItem.equals(expectedItem)) {
				javaExecutor.executeScript("arguments[0].scrollIntoView(true);", child);
				child.click();
				break;
			}
		}

	}

	// getAttributeValueInElement
	public String getAttributeValueInElement(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	// getTextInElement
	public String getTextInElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	// countElementNumber
	public int countElementNumber(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	// checkTheCheckbox
	public void checkTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	// uncheckTheCheckbox
	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	// isControlDisplayed
	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	// isControlSelected
	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	// isControlEnabled
	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	// User Actions - doubleClickToElement
	public void doubleClickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}

	// User Actions - hoverToElement
	public void hoverToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}

	// User Actions - rightclick
	public void rightclickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	// User Actions - dragAndDrop
	public void dragAndDrop(WebDriver driver, String locatorSource, String locatorDes) {
		WebElement elementSource = driver.findElement(By.xpath(locatorSource));
		WebElement elementDes = driver.findElement(By.xpath(locatorDes));
		Actions action = new Actions(driver);
		// Drag and drop
		action.dragAndDrop(elementSource, elementDes).perform();
	}

	// ---------------------------------------------------- User Actions - keyPress
	// UPDATED
	public void keyPress(WebDriver driver, String key) {
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		action.keyUp(Keys.CONTROL).build().perform();

	}

	// uploadSingleFile
	public void uploadSingleFile(WebDriver driver, String locator, String filename) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.sendKeys(filename);
	}

	// uploadMultipleFile
	public void uploadMultipleFile(WebDriver driver, List<String> listOfFilePath, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));

		String listString = "";

		for (String filePath : listOfFilePath) {
			listString += filePath + "\n";
		}
		element.sendKeys(listString);
	}

	// Auto IT
	public void uploadAutoIT(WebDriver driver, String filePath, String locator) throws Exception {

		// Click to Add file button -> open file dialog
		executeJavascriptToElement(driver, locator);

		Thread.sleep(3000);

		if (driver.toString().toLowerCase().contains("chrome")) {
			Runtime.getRuntime().exec(new String[] { ".\\uploadFile\\chrome.exe", filePath });
		} else if (driver.toString().toLowerCase().contains("firefox")) {
			Runtime.getRuntime().exec(new String[] { ".\\uploadFile\\firefox.exe", filePath });
		} else {
			Runtime.getRuntime().exec(new String[] { ".\\uploadFile\\ie.exe", filePath });
		}
		Thread.sleep(5000);

	}

	// uploadRobot
	public void uploadRobot(WebDriver driver, String filePath, String locator) throws Exception {

		// Specify the file location with extension
		StringSelection select = new StringSelection(filePath);

		// Copy to Clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		// Click to Add file button -> open file dialog
		executeJavascriptToElement(driver, locator);

		Thread.sleep(3000);

		Robot robot = new Robot();
		Thread.sleep(1000);
		// ENTER
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		// PRESS CTRL+ V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		// RELEASE CTRL+ V
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		// ENTER
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

	}

	// executeJavascriptToBrowser
	public Object executeJavascriptToBrowser(WebDriver driver, String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// executeJavascriptToElement
	public Object executeJavascriptToElement(WebDriver driver, String locator) {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// scrollToBottomPage
	public Object scrollToBottomPage(WebDriver driver) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// scrollToElement
	public void scrollToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

	// highlightElement
	public void highlightElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	// sendkeyToElementByJS
	public Object sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// removeAttributeInDOM
	public Object removeAttributeInDOM(WebDriver driver, String locator, String attribute) {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	

	// isImageDisplayed
	public boolean isImageDisplayed(WebDriver driver, String locator) {
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return (boolean) js.executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					element);
		} catch (Exception e) {
			e.getMessage();
			return false;
		}
	}

	// navigateToUrlByJS
	public Object navigateToUrlByJS(WebDriver driver, String url) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("window.location = '" + url + "'");
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// waitToElementPresence
	public void waitToElementPresence(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(byLocator));
	}

	// waitToElementVisible
	public void waitToElementVisible(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
	}

	// waitToElementClickable
	public void waitToElementClickable(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(byLocator));
	}

	// waitToElementInvisible
	public void waitToElementInvisible(WebDriver driver, String locator) {
		By byLocator = By.xpath(locator);
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
	}

	// waitForAlertPresence
	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait waitExplicit = new WebDriverWait(driver, 30);
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}

}
