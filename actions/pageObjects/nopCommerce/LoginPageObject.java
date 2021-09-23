package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage{

	private WebDriver driver;
	PageGeneratorManager pageGenerator;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public LoginPageObject enterToEmailTextbox(String emailAddress) {
		waitForElementClickable(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
		return PageGeneratorManager.getLoginPage(driver); 
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
