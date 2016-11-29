package com.pype.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pype.core.PypeBase;
import com.pype.pages.BasePage;
import com.pype.pages.ContactUsPage;

import comp.pype.helpers.FluentialWaitHelper;

@Test
public class ContactUsIT extends PypeBase {

	@Test(dataProvider = "getValidSubmit", description = "Submit sample contactus contact")
	public void submitContactUs(String name, String company, String email, String phoneNumber) throws Exception {
		ContactUsPage contactUsPage = gotoContactUsPage();

		contactUsPage.enterCompany(company).enterEmail(email).enterPhoneNumber(phoneNumber).enterName(name);
		Assert.assertTrue(contactUsPage.isSubmitEnabled(), "It should be submittable");
	}
	
	@Test(dataProvider = "getInvalidEmail", description = "Verify invalid email error")
	public void emailNotValidError(String email) throws Exception {
		ContactUsPage contactUsPage = gotoContactUsPage();

		contactUsPage.enterEmail(email);
		FluentialWaitHelper.waitForElementVisible(getDriver(), BasePage.INVALID_EMAIL_ERROR);
	}
	@Test(dataProvider = "getInvalidEmail", description = "Verify invalid email error")
	public void emailNotValidError3(String email) throws Exception {
		ContactUsPage contactUsPage = gotoContactUsPage();

		contactUsPage.enterEmail(email);
		FluentialWaitHelper.waitForElementVisible(getDriver(), BasePage.INVALID_EMAIL_ERROR);
	}
	@Test(dataProvider = "getInvalidEmail", description = "Verify invalid email error")
	public void emailNotValidError2(String email) throws Exception {
		ContactUsPage contactUsPage = gotoContactUsPage();

		contactUsPage.enterEmail(email);
		FluentialWaitHelper.waitForElementVisible(getDriver(), BasePage.INVALID_EMAIL_ERROR);
	}
	@Test(dataProvider = "getInvalidEmail", description = "Verify invalid email error")
	public void emailNotValidErro2r(String email) throws Exception {
		ContactUsPage contactUsPage = gotoContactUsPage();

		contactUsPage.enterEmail(email);
		FluentialWaitHelper.waitForElementVisible(getDriver(), BasePage.INVALID_EMAIL_ERROR);
	}

	@Test(dataProvider = "getValidEmail", description = "Verify valid email")
	public void testValidAuth(String email) throws Exception {
		ContactUsPage contactUsPage = gotoContactUsPage();

		contactUsPage.enterCompany("Random LLC").enterPhoneNumber("1234567890").enterName("John Doe");
		Assert.assertFalse(contactUsPage.isSubmitEnabled());

		contactUsPage.enterEmail(email);
		Assert.assertTrue(contactUsPage.isSubmitEnabled());
	}

	@DataProvider(parallel=true)
	public Object[][] getValidSubmit() {
		return new Object[][] { { "Curious User", "Pype Inc", "curiouse@gmail.com", "0123456789" } };
	}
}
