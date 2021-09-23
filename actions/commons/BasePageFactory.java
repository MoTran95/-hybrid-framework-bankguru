package commons;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	public static BasePage getBasePage() {
		return new BasePage();
	}

	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	public void sendKeysToElement(WebDriver driver,WebElement element , String value) {
		element.clear();
		element.sendKeys(value);
	}
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
		
	}
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	public void waitForElementVisible(WebDriver driver, WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForAllElementVisible(WebDriver driver,List <WebElement> elements) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	public void waitForElementClickable(WebDriver driver,WebElement element) {
		explicitWait = new WebDriverWait(driver, timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	


	
	private Alert alert;
	private long timeout = 30;
	private WebDriverWait explicitWait;
	
}
