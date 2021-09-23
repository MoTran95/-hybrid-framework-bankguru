package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.RegisterPageObject;

public class Level_04_Register_Login_Multiple_Browser extends BaseTest {

	WebDriver driver;
	BasePage basePage;
	String emailAddress, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		emailAddress = getRandomEmail();
		password = "123456";

	}

	@Test
	public void Login_01_Register_To_System() {

		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.clickToGenderMaleRadioButton();

		registerPage.clickToFirstnameTextbox("John");

		registerPage.clickToLastnameTextbox("Terry");

		registerPage.enterToEmailTextbox(emailAddress);

		registerPage.enterToPasswordTextbox(password);

		registerPage.enterToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());

		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isHomePageSliderDisplayed());

	}

	@Test
	public void Login_02_Login_To_System() {

		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.enterToEmailTextbox(emailAddress);

		loginPage.enterToPasswordTextbox(password);

		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);

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
