package com.pype.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage extends BasePage {

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "email")
	private WebElement emailLocator;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement resetPasswordLocator;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Cancel')]")
	private WebElement cancelLocator;

	@FindBy(how = How.LINK_TEXT, using = "Log In")
	private WebElement loginLocator;

	private By emailErrorLocator = By
			.xpath("//span[contains(@class, 'help-block') and contains(text(),'Email is not valid')]");

	public ForgotPasswordPage enterEmail(String email) {
		emailLocator.clear();
		emailLocator.sendKeys(email);

		return this;
	}

	public LoginPage clickLoginLink() {
		loginLocator.click();

		return new LoginPage(driver);
	}

	public LoginPage cancelForm() {
		cancelLocator.click();

		return new LoginPage(driver);
	}

	public void waitForEmailError() {
		waitUtilElementIsVisible(emailErrorLocator);
	}

	public boolean isResetPasswordEnabled() {
		return resetPasswordLocator.isEnabled();
	}
}
