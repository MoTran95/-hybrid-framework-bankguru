package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.accept();

	}

	public void cancletAlert(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		alert.dismiss();

	}

	public void sendKeyAlert(WebDriver driver, String value) {
		alert = waitForAlertPresence(driver);
		alert.sendKeys(value);

	}

	public String getAlertText(WebDriver driver) {
		alert = waitForAlertPresence(driver);
		return alert.getText();

	}
	
	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String windowID : allWindowsID) {
			if (!windowID.equals(parentID)) {
				driver.switchTo().window(windowID);
				break;
			}
		}

	}

	public void switchToWindowByTitle(WebDriver driver, String expectedWindowTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("so luong window/tab dang co " + allWindows.size());
		for (String windowID : allWindows) {

			driver.switchTo().window(windowID);

			String actualwindowTitle = driver.getTitle();

			if (actualwindowTitle.equals(expectedWindowTitle)) {

				break;
			}
		}

	}

	public void closeAllWindowExceptParent(WebDriver driver, String ParantID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String windowID : allWindowsID) {
			if (!windowID.equals(ParantID)) {
				driver.switchTo().window(windowID);
				sleepInSecond(1);
				driver.close();
			}
			if (driver.getWindowHandles().size() == 1) {
				driver.switchTo().window(ParantID);
				break;
			}
		}
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();;
	}
	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();;
	}
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	public WebElement getElement(WebDriver driver,String locator) {
		return driver.findElement(getByXpath(locator));
	}
	public List<WebElement> getElements(WebDriver driver,String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getElement(driver,locator).click();;
	}
	public void sendKeysToElement(WebDriver driver, String locator, String value) {
		getElement(driver,locator).clear();
		getElement(driver,locator).sendKeys(value);
	}
	public int getElementSize(WebDriver driver, String locator) {
		return  getElements(driver, locator).size();
	}
	public void selectDropdownByText(WebDriver driver, String locator, String ItemText) {
		select = new Select(getElement(driver, locator));
		select.selectByVisibleText(ItemText);
	}
	public String getSelectedDropdownByText(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.getFirstSelectedOption().getText();
	}
	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(getElement(driver, locator));
		return select.isMultiple();
	}

	public void selectMultiItemInDropdown(WebDriver driver, String parentLocator, String childItemLocator, String[] expectedItem) {
		getElement(driver,parentLocator).click();
		sleepInSecond(1);
		
		explicitWait = new WebDriverWait(driver, timeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));
		
		for (WebElement item : allItems) {
             if(item.getText().trim().equals(expectedItem)) {
            	 jsExecutor = (JavascriptExecutor)driver;
            	 jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
            	 sleepInSecond(1);
            	 
            	 item.click();
            	 sleepInSecond(1);
            	 break;
             }
		}
	}
	
	public String getElementAttribute(WebDriver driver, String locator, String attibuteName) {
		return getElement(driver,locator).getAttribute(attibuteName);
		
	}
	public String getElementText(WebDriver driver, String locator) {
		return getElement(driver,locator).getText();
		
	}
	public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
		if(!getElement(driver,locator).isSelected()) {
			getElement(driver,locator).click();
		}
	}
	public void unCheckToCheckbo(WebDriver driver, String locator) {
		if(getElement(driver,locator).isSelected()) {
			getElement(driver,locator).click();
		}
	}
	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver,locator).isDisplayed();
	}
	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver,locator).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver,locator).isSelected();
	}
	public WebDriver switchToIframeByElement(WebDriver driver, String locator) {
		return  driver.switchTo().frame(getElement(driver,locator));
	}
	public WebDriver switchToDefaultContent(WebDriver driver) {
		 return driver.switchTo().defaultContent();
	}
	public void hoverToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver,locator)).perform();
	}
	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver,locator)).perform();
	}
	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver,locator)).perform();
	}
	public void dragAndDropClickToElement(WebDriver driver, String sourceLocator, String TargetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver,sourceLocator),getElement(driver,TargetLocator)).perform();
	}
	public void pressKeysToElement(WebDriver driver, String Locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver,Locator)).perform();
	}
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver,String locator) {
		WebElement element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver,String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver,String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver,String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')",getElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver,String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",getElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver,String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver,String locator) {
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisible(WebDriver driver,String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}
	public void waitForAllElementVisible(WebDriver driver,String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(locator)));
	}
	public void waitForElementClickable(WebDriver driver,String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}
	public void waitForElementInvisible(WebDriver driver,String locator) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
	}
	
	private Alert alert;
	private Select select;
	private long timeout =30;
	private Actions action;
	private JavascriptExecutor jsExecutor;
	private WebDriverWait explicitWait;
	
}
