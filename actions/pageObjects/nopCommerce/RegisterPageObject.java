package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;


import PageUIs.nopCommerce.RegisterPageUI;
import commons.BasePage;

public class RegisterPageObject extends BasePage{
	private WebDriver driver;
    public RegisterPageObject(WebDriver driver) {
    	this.driver = driver;
    }
	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
		
	}

	public void clickToFirstnameTextbox(String firstname) {
		waitForElementClickable(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
		
	}

	public void clickToLastnameTextbox(String lastname) {
		waitForElementClickable(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastname);
		
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementClickable(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementClickable(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementClickable(driver, RegisterPageUI.CONFIRM_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_TEXTBOX, confirmPassword);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_TEXTBOX);
		clickToElement(driver, RegisterPageUI.REGISTER_TEXTBOX);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESSMESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESSMESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

}
