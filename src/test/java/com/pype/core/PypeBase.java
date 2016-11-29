package com.pype.core;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.pype.pages.ContactUsPage;
import com.pype.pages.ForgotPasswordPage;
import com.pype.pages.LoginPage;

import comp.pype.helpers.AngularTestHelper;
import comp.pype.helpers.DriverFactory;

abstract public class PypeBase extends DriverFactory {
	public final Logger logger = Logger.getLogger(PypeBase.class);
	 
	public static final Object[][] VALID_EMAILS = new Object[][] { { "waitforvisible@gmail.com" },
			{ "wait+3@gmail.com" } };
	public static final Object[][] INVALID_EMAILS = new Object[][] { { "1" }, { "1@" }, { "az" }, { "@#" },
			{ "alsdfkj@" }, { "akdl@." } };

	@DataProvider(parallel=true)
	public Object[][] getInvalidEmail() {
		return INVALID_EMAILS;
	}

	@DataProvider(parallel=true)
	public Object[][] getValidEmail() {
		return VALID_EMAILS;
	}

	@BeforeMethod
	public void waitUntilPageLoads() throws Exception {
		AngularTestHelper.waitUntilPageLoads(getDriver());
	}

	public WebDriverWait getWebDriverWait(WebDriver driver) {
		return new WebDriverWait(driver, 15, 100);
	}

	public void waitUtilElementIsVisible(WebDriver driver, By element)  {
		getWebDriverWait(driver).until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public ForgotPasswordPage gotoForgotPasswordPage() throws Exception {
		return gotoLoginPage().gotoForgotPasswordPage();
	}

	public ContactUsPage gotoContactUsPage() throws Exception {
		return gotoLoginPage().gotoContactUsPage();
	}

	public LoginPage gotoLoginPage() throws Exception {
		return new LoginPage(getDriver());
	}
}
