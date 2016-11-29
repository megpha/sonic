package com.pype.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pype.core.PypeBase;
import com.pype.pages.BasePage;
import com.pype.pages.ForgotPasswordPage;
import com.pype.pages.LoginPage;

import comp.pype.helpers.FluentialWaitHelper;

public class ForgotPasswordIT extends PypeBase {
	@Test(description = "Go back to login page")
	public void goToLoginPage() throws Exception {
		LoginPage loginPage = new LoginPage(getDriver());
		ForgotPasswordPage forgotPasswordPage = loginPage.gotoForgotPasswordPage();

		forgotPasswordPage.clickLoginLink().waitForPageHeader("AutoSpecs Login");
	}

	@Test(description = "Go back to login page when cancel form")
	public void clickCancelForm() throws Exception {
		ForgotPasswordPage forgotPasswordPage = gotoForgotPasswordPage();
		forgotPasswordPage.cancelForm().waitForPageHeader("AutoSpecs Login");
	}
	

	@Test(dataProvider = "getInvalidEmail", description = "Invalid email error")
	public void emailNotValidError(String email) throws Exception {
		ForgotPasswordPage forgotPasswordPage = gotoForgotPasswordPage();

		forgotPasswordPage.enterEmail(email);
		FluentialWaitHelper.waitForElementVisible(forgotPasswordPage.driver, BasePage.INVALID_EMAIL_ERROR);
		Assert.assertFalse(forgotPasswordPage.isResetPasswordEnabled());
	}

	@Test(dataProvider = "getValidEmail", description = "Verify valid email")
	public void testValidAuth(String email) throws Exception {
		ForgotPasswordPage forgotPasswordPage = this.gotoForgotPasswordPage();

		forgotPasswordPage.enterEmail(email);
		forgotPasswordPage.enterEmail(email);
		Assert.assertTrue(forgotPasswordPage.isResetPasswordEnabled());
	}
}
