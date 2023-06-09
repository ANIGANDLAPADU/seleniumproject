package com.selenium.testcases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.pageobjects.AccountRegistrationPage;
import com.selenium.pageobjects.HomePage;
import com.selenium.testbase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	@Test
	public void test_account_Registration() throws InterruptedException
	{
		try
		{
		HomePage hp=new HomePage(driver);
		/*hp.clickMyAccount();*/
		/*hp.clickRegister();
		*/
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");// randomly generated the email
		
		regpage.setTelephone(randomeNumber());
		
		//String password=randomAlphaNumeric();
		regpage.setPassword("seshu");
		/*regpage.setConfirmPassword("seshu");*/
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		String confmsg=regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
	
}
