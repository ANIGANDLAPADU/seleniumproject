package com.selenium.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.selenium.pageobjects.LoginPageObject;
import com.selenium.testbase.BaseClass;
import com.selenium.utilites.DataProviders;

public class TC_001_LoginDTT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)

	public void login_DTT(String username, String password) {
		try {
			logger.info("***TC_001_LoginDTT ***");
			Reporter.log("***TC_001_LoginDTT ***");
			LoginPageObject loginpage = new LoginPageObject(driver);
			logger.info("***created homepageobject ***");
			Reporter.log("***created homepageobject ***");
			loginpage.EnterEmail(username);
			logger.info("***EnterEmailAddress ***");
			Reporter.log("***EnterEmailAddress ***");
			loginpage.EnterPassword(password);
			logger.info("***EnterPassword ***");
			Reporter.log("**EnterPassword ***");
			loginpage.ClickOnLogin();
			logger.info("*** ClickedOnLoginButton ***");
			Reporter.log("*** ClickedOnLoginButton ***");
			driver.switchTo().alert().accept();
			logger.info("***Accepting the alret message***");
			Reporter.log("***Accepting the alret message***");
			loginpage.ClearEmailInput();
			logger.info("***ClearEmailInput***");
			Reporter.log("***ClearEmailInput***");
			loginpage.ClearPasswordInput();
			logger.info("*** ClearPasswordInput ***");
			Reporter.log("*** ClearPasswordInput ***");
			/*
			 * loginpage.LogOutButton(); logger.info("***LogOutButton***");
			 * Reporter.log("***LogOutButton***");
			 */
		} catch (Exception e) {

		}

	}

}