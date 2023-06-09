package com.selenium.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.Test;

import com.selenium.pageobjects.HomePage;
import com.selenium.testbase.BaseClass;

public class TC_001_Login extends BaseClass {

	FileInputStream file;
	Properties pro;

	@Test()
	public void login() throws IOException {
		logger.info("***TC_001_Login ******");
		file = new FileInputStream("D:\\seleniumproject\\src\\test\\resources\\dynamic.properties");
		pro = new Properties();
		pro.load(file);

		HomePage homepage = new HomePage(driver);
		logger.info("***created homepageobject ******");
		homepage.EnterEmail(pro.getProperty("email"));
		logger.info("***EnterEmailAddress ******");
		homepage.EnterPassword(pro.getProperty("password"));
		logger.info("***EnterPassword ***");
		homepage.ClickOnLogin();
		logger.info("***ClickedOnLoginButton ***");

	}
}