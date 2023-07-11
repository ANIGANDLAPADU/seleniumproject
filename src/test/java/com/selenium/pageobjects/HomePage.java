package com.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements

	@FindBy(xpath = ("//input[@name='txtuId']"))
	WebElement email;
	@FindBy(xpath = ("//input[@name='txtPword']"))
	WebElement password;
	@FindBy(xpath = ("//input[@name='login']"))
	WebElement login;
	@FindBy(xpath = ("//td[@class='headings style12']//font[@face='Arial']//font"))
	WebElement check;
	// Action Methods

	public void EnterEmail(String name) {
		email.sendKeys(name);
	}

	public void EnterPassword(String name) {
		password.sendKeys(name);
	}

	public void ClickOnLogin() {
		login.click();
	}

	public String GetText() {
		String act = check.getText();
		return act;
	}
}
