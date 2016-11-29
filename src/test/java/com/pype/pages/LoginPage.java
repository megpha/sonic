package com.pype.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "email")
	private WebElement emailLocator;

	@FindBy(how = How.ID, using = "password")
	public WebElement passwordLocator;

	@FindBy(how = How.CLASS_NAME, using = "btn-success")
	private WebElement submitLocator;

	@FindBy(how = How.LINK_TEXT, using = "Sign Up")
	public WebElement signUpLocator;

	@FindBy(how = How.LINK_TEXT, using = "Forgot Password")
	private WebElement forgotPasswordLocator;

	@FindBy(how = How.LINK_TEXT, using = "Contact Us")
	private WebElement contactUsLocator;

	@FindBy(how = How.CLASS_NAME, using = "pypeLoginHeader")
	private WebElement contactUsHeaderLocator;

	private By emailErrorLocator = By
			.xpath("//span[contains(@class, 'help-block') and contains(text(),'Email is not valid')]");

	public void login(String userName, String passWord) {
		enterUserName(userName).enterPassword(passWord).andSubmit();
	}

	public LoginPage andSubmit() {
		submitLocator.click();

		return this;
	}

	public LoginPage enterUserName(String userName) {
		emailLocator.clear();
		emailLocator.sendKeys(userName);

		return this;
	}

	public LoginPage enterPassword(String passwordValue) {
		passwordLocator.clear();
		passwordLocator.sendKeys(passwordValue);

		return this;
	}

	public String getEmailPlaceHodlerValue() {
		return getPlaceHolderValue(emailLocator);
	}

	public boolean isSubmitEnabled() {
		return submitLocator.isEnabled();
	}

	public ContactUsPage gotoContactUsPage() {
		contactUsLocator.click();
		this.waitForPageHeader("Contact Us");

		return new ContactUsPage(driver);
	}

	public ForgotPasswordPage gotoForgotPasswordPage() {
		forgotPasswordLocator.click();
		waitForPageHeader("Forgot Password?");

		return new ForgotPasswordPage(driver);
	}

	public DashboardPage gotoDashBoard(String userName, String passWord) {
		login(userName, passWord);

		return new DashboardPage(driver);
	}

	public String getPasswordPlaceHodlerValue() {
		return getPlaceHolderValue(passwordLocator);
	}

	public void waitForEmailError() {
		waitUtilElementIsVisible(emailErrorLocator);
	}
}
