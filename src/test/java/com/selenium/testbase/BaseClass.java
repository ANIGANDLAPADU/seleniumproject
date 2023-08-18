package com.selenium.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.selenium.utilites.ExtentReportManager.class)
public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	ResourceBundle rb;
	public FileInputStream file;
	public Properties pro;

	@BeforeSuite
	@Parameters("browser")
	public void setup() throws IOException {
		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		logger = LogManager.getLogger(this.getClass());

		driver = new ChromeDriver(options);
		logger.info("**open the browser**");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		rb = ResourceBundle.getBundle("dynamic");
		driver.get(rb.getString("url"));
		logger.info("***Enter the URL***");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		driver.manage().window().maximize();
		logger.info("**maximize the browser**");
	}

	@AfterSuite
	public void tearDown() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
		driver.quit();
		logger.info("***closing the browser***");

	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}

	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);

		return (st + "@" + num);
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + ".\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}

}
