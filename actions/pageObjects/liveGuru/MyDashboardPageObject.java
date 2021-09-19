package pageObjects.liveGuru;

import org.openqa.selenium.WebDriver;


import PageUIs.liveGuru.MyDashboardPageUI;
import commons.BasePage;

public class MyDashboardPageObject extends BasePage {
	WebDriver driver;
	public MyDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public boolean isMyDashboardHeaderDisplayed() {
		waitForElementVisible(driver, MyDashboardPageUI.MY_DASHBOARD_TEXT);
		return isElementDisplayed(driver, MyDashboardPageUI.MY_DASHBOARD_TEXT);
	}
	

}
