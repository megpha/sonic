package com.pype.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignUpPage extends BasePage {
	public SignUpPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.ID, using = "name")
	public WebElement name;

	@FindBy(how = How.ID, using = "email")
	public WebElement email;

	@FindBy(how = How.ID, using = "companyName")
	public WebElement company_name;

	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Terms of Use')]")
	public WebElement termsof_uses;

	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	public WebElement signup;
}
