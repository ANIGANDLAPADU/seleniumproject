package com.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePage {

	public LoginPageObject(WebDriver driver) {
		super(driver);

	}

	// Elements

	@FindBy(xpath = ("//input[@name='txtuId']"))
	private WebElement email;
	@FindBy(xpath = ("//input[@name='txtPword']"))
	private WebElement password;
	@FindBy(xpath = ("//input[@name='login']"))
	private WebElement login;
	@FindBy(xpath = ("//td[@class='headings style12']//font[@face='Arial']//font"))
	private WebElement check;
	@FindBy(xpath = ("//input[@type='text']"))
	private WebElement Clear;
	@FindBy(xpath = ("//input[@type='password']"))
	private WebElement clear;
	@FindBy(xpath = ("//*[@id=\"Table_02\"]/tbody/tr/td[3]/a/img"))
	private WebElement LogOut;
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

	public void ClearEmailInput() {
		Clear.clear();
	}

	public void ClearPasswordInput() {
		Clear.clear();
	}

	public void LogOutButton() {
		LogOut.click();
	}
}
