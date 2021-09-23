package pageFactory.nopCommerce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory{
	WebDriver driver;
	
	@FindBy(id = "gender-male")
	WebElement genderMaleRadio;
	@FindBy(id = "FirstName")
	WebElement firstNameTextbox;
	@FindBy(id = "LastName")
	WebElement lastNameTextbox;
	@FindBy(id = "Email")
	WebElement emailTextbox;
	@FindBy(id = "Password")
	WebElement passwordTextbox;
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextbox;
	@FindBy(id = "register-button")
	WebElement registerButton;
	@FindBy(xpath  = "//div[@class='result' and text()='Your registration completed']")
	WebElement successMessage;
	@FindBy(xpath  = "//a[@class='ico-logout']")
	WebElement logoutLink;
    public RegisterPageObject(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver,genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	
	}

	public void clickToFirstnameTextbox(String firstname) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeysToElement(driver, firstNameTextbox, firstname);
		
	}

	public void clickToLastnameTextbox(String lastname) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeysToElement(driver, lastNameTextbox, lastname);
		
		
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeysToElement(driver, emailTextbox, emailAddress);
		
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeysToElement(driver, passwordTextbox, password);
		
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, firstNameTextbox);
		sendKeysToElement(driver, confirmPasswordTextbox, confirmPassword);
		
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, successMessage);
		return isElementDisplayed(driver, successMessage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
		
	}

}
