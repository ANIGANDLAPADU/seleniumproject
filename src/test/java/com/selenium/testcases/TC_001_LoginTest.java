package com.selenium.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.selenium.pageobjects.LoginPageObject;
import com.selenium.testbase.BaseClass;

public class TC_001_LoginTest extends BaseClass {

	@Test(groups ={"sanity"} )
	public void login() throws IOException {

		LoginPageObject loginpage = new LoginPageObject(driver);
		logger.info("***created homepageobject ***");
		Reporter.log("***created homepageobject ***");
		loginpage.EnterEmail(pro.getProperty("email"));
		logger.info("***EnterEmailAddress ***");
		Reporter.log("***EnterEmailAddress ***");
		loginpage.EnterPassword(pro.getProperty("password"));
		logger.info("***EnterPassword ***");
		Reporter.log("**EnterPassword ***");
		loginpage.ClickOnLogin();
		logger.info("*** ClickedOnLoginButton ***");
		Reporter.log("*** ClickedOnLoginButton ***");
		String act = loginpage.GetText();
		String exp = "Welcome to Admin";
		Assert.assertEquals(exp, act);
		/*
		 * SoftAssert softassert = new SoftAssert(); softassert.assertEquals(exp, act);
		 */

	}
}