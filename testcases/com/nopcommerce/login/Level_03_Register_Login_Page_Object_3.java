package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_03_Register_Login_Page_Object_3 {

	WebDriver driver;
	BasePage basePage;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", "./browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		emailAddress = getRandomEmail();
		password = "123456";

	}

	@Test
	public void Login_01_Register_To_System() {
		
		// Step 1: Open URL -> HomePage
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
        
		// Step 2: Verify Home Page Slider displayed:
				Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
		// Step 3: Click to Register link-> Register Page
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		// Step 4: Click to Gender male radio
		registerPage.clickToGenderMaleRadioButton();

		// Step 5: Input to First Name textbox
		registerPage.clickToFirstnameTextbox("John");

		// Step 6: Input to Last name textbox
		registerPage.clickToLastnameTextbox("Terry");

		// Step 7: Input to Email textbox
		registerPage.enterToEmailTextbox(emailAddress);

		// Step 8: Input to Password textbox
		registerPage.enterToPasswordTextbox(password);

		// Step 9: Input to Confirm Password textbox
		registerPage.enterToConfirmPasswordTextbox(password);

		// Step 10: Click to Register button
		registerPage.clickToRegisterButton();

		// Step 11: Verify success message displayed
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		// Step 12: Click to logout link-> Home Page
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);

		// Step 13: Verify Home Page Slider displayed:
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void Login_02_Login_To_System() {
		// Step 1: Click to Login Link
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		// Step 2: Input to Email textbox
		loginPage.enterToEmailTextbox(emailAddress);

		// Step 3: Input to Password textbox
		loginPage.enterToPasswordTextbox(password);

		// Step 4: Click to Login button => Home Page
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);

		// Step 5: Verify Home Page Logo displayed:
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@AfterClass
	public void cleabBrowser() {
		driver.quit();
	}

	public String getRandomEmail() {
		Random rand = new Random();
		return "dreamtesting" + rand.nextInt(9999) + "@hotmail.com";
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;

}
