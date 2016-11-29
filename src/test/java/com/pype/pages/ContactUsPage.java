package com.pype.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ContactUsPage extends BasePage {

	@FindBy(how = How.ID, using = "name")
	private WebElement nameLocator;

	@FindBy(how = How.ID, using = "email")
	private WebElement emailLocator;

	@FindBy(how = How.ID, using = "phoneNumber")
	private WebElement phoneNumberLocator;

	@FindBy(how = How.ID, using = "company")
	private WebElement companyNameLocator;

	@FindBy(how = How.ID, using = "content")
	private WebElement contentLocator;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement submitLocator;

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	public ContactUsPage enterEmail(String email) {
		emailLocator.clear();
		emailLocator.sendKeys(email);

		return this;
	}

	public ContactUsPage enterPhoneNumber(String phoneNumber) {
		phoneNumberLocator.clear();
		phoneNumberLocator.sendKeys(phoneNumber);

		return this;
	}

	public ContactUsPage enterCompany(String companyName) {
		companyNameLocator.clear();
		companyNameLocator.sendKeys(companyName);

		return this;
	}

	public ContactUsPage enterName(String name) {
		nameLocator.clear();
		nameLocator.sendKeys(name);

		return this;
	}

	public boolean isSubmitEnabled() {
		return submitLocator.isEnabled();
	}
}