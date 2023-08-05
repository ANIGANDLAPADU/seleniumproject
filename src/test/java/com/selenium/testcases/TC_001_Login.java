package com.selenium.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.selenium.pageobjects.LoginPageObject;
import com.selenium.testbase.BaseClass;

public class TC_001_Login extends BaseClass {

	@Test()
	public void login() throws IOException {
		logger.info("***TC_001_Login ***");
		Reporter.log("***TC_001_Login ***");
		file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/dynamic.properties");
		pro = new Properties();
		pro.load(file);

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