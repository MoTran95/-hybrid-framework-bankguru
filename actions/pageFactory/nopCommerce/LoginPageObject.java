package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;


public class LoginPageObject extends BasePageFactory{

	WebDriver driver;
	
	@FindBy(css="input[id='Email']")
	WebElement emailTextbox;
	
	@FindBy(css="input[id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath ="//button[@class='button-1 login-button']")
	WebElement loginButton;
	
	
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendKeysToElement(driver, emailTextbox, emailAddress);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendKeysToElement(driver, passwordTextbox, password);
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}

}
