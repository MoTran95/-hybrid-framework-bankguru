package com.bankguru.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Register_Login_Base_Page_1 {

	WebDriver driver;
	BasePage basePage;
	String email,username, password, loginPageUrl;
	String projectLocation = System.getProperty("user.dir");
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver", "./browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		basePage = new BasePage();
	}
	
	@Test
	public void Login_01_Register_To_System() {
		loginPageUrl = basePage.getPageUrl(driver);
		basePage.clickToElement(driver, "//a[text()='here']");
		basePage.sendKeysToElement(driver, "//input[@name='emailid']", generateEmail());
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		username = basePage.getElementText(driver, "//td[text()='User ID :']/following-sibling::td");
		password = basePage.getElementText(driver, "//td[text()='Password :']/following-sibling::td");

	}
	@Test
	public void Login_02_Login_To_System() {
		basePage.openPageUrl(driver, loginPageUrl);
		basePage.sendKeysToElement(driver, "//input[@name='uid']", username);
		basePage.sendKeysToElement(driver, "//input[@name='password']", password);
        
		basePage.clickToElement(driver, "//input[@name='btnLogin']");
		String welcomeMessage = basePage.getElementText(driver, "//marquee[@class='heading3']");
		Assert.assertEquals(welcomeMessage,"Welcome To Manager's Page of Guru99 Bank");
	}
	@AfterClass
	public void cleabBrowser() {
		driver.quit();
	}
	public String generateEmail() {
		Random rand = new Random();
		return "dreamtesting" + rand.nextInt(9999) + "@hotmail.com";
	}

}
