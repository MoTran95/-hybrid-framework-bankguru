package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;

import PageUIs.liveGuru.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{
    WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountFooterLink() {
		waitForElementClickable(driver, HomePageUI.My_ACCOUNT_FOOTER );
		clickToElement(driver, HomePageUI.My_ACCOUNT_FOOTER);
		
	}
	

}
