package com.pype.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public final WebDriver driver;
	public static final By INVALID_EMAIL_ERROR = By
			.xpath("//span[contains(@class, 'help-block') and contains(text(),'Email is not valid')]");

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForPageHeader(String header) {
		WebDriverWait wait = new WebDriverWait(driver, 15, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(headerWithText(header)));
	}

	protected String getPlaceHolderValue(WebElement element) {
		return element.getAttribute("placeholder");
	}

	private By headerWithText(String header) {
		return By.xpath("//h2[contains(@class, 'pypeLoginHeader') and contains(text(),'" + header + "')]");
	}

	public WebDriverWait getWebDriverWait() {
		return new WebDriverWait(driver, 15, 100);
	}

	public void waitUtilElementIsVisible(By element) {
		getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(element));
	}

}
