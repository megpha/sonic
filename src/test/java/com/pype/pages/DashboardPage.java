package com.pype.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends BasePage {
	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-link pull-right minimize']")
	public WebElement expandPath;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-link pull-right minimize collapsed']")
	public WebElement collapsedPath;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-link pull-right minimize collapsed']/../..")
	public WebElement collapsedPathParent;
}
