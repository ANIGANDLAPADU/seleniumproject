package com.selenium.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.selenium.pageobjects.HomePage;
import com.selenium.testbase.BaseClass;

public class TC_001_Login extends BaseClass {

	@Test()
	public void login() throws IOException {
		logger.info("***TC_001_Login ***");
		Reporter.log("***TC_001_Login ***");
		file = new FileInputStream("D:/seleniumproject/src/test/resources/dynamic.properties");
		pro = new Properties();
		pro.load(file);

		HomePage homepage = new HomePage(driver);
		logger.info("***created homepageobject ***");
		Reporter.log("***created homepageobject ***");
		homepage.EnterEmail(pro.getProperty("email"));
		logger.info("***EnterEmailAddress ***");
		Reporter.log("***EnterEmailAddress ***");
		homepage.EnterPassword(pro.getProperty("password"));
		logger.info("***EnterPassword ***");
		Reporter.log("**EnterPassword ***");
		homepage.ClickOnLogin();
		logger.info("*** ClickedOnLoginButton ***");
		Reporter.log("*** ClickedOnLoginButton ***");
		String act = homepage.GetText();
		String exp = "Welcome to Admin";
		Assert.assertEquals(exp, act);
		/*
		 * SoftAssert softassert = new SoftAssert(); softassert.assertEquals(exp, act);
		 */

	}
}