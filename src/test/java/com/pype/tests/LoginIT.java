package com.pype.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pype.core.PypeBase;
import com.pype.pages.LoginPage;

import junit.framework.Assert;

@Test
public class LoginIT extends PypeBase {
	@Test(description = "Verify on login page elements")
	public void testLoginElements() throws Exception {
		LoginPage loginPage = gotoLoginPage();

		Assert.assertEquals(loginPage.getEmailPlaceHodlerValue(), "Email");
		Assert.assertEquals(loginPage.getPasswordPlaceHodlerValue(), "Password");
	}

	@Test(dataProvider = "getValidAuthenitcation", description = "Verify authentication")
	public void testValidAuth(String userName, String password) throws Exception {
		LoginPage loginPage = gotoLoginPage();
		loginPage.login(userName, password);
	}

	@Test(dataProvider = "getInvalidEmail", description = "Invalid email error")
	public void emailNotValidError(String email) throws Exception {
		LoginPage loginPage = gotoLoginPage();
		loginPage.enterUserName(email).waitForEmailError();
		Assert.assertFalse(loginPage.isSubmitEnabled());
	}

	@DataProvider
	public Object[][] getValidAuthenitcation() {
		return new Object[][] { { "waitforvisible@gmail.com", "welcome123" } };
	}
}
