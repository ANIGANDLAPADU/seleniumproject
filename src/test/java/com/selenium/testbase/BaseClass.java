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
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners(com.selenium.utilites.ExtentReportManager.class)

public class BaseClass {

	public static WebDriver driver;
	public Logger logger;
	ResourceBundle rb;
	public FileInputStream file;
	public Properties pro;
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws IOException {
		/*
		 * ChromeOptions options = new ChromeOptions();
		 * 
		 * options.setExperimentalOption("excludeSwitches", new String[] {
		 * "enable-automation" });
		 */
		logger = LogManager.getLogger(this.getClass());
		file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/dynamic.properties");
		pro = new Properties();
		pro.load(file);
		if (browser.equalsIgnoreCase(pro.getProperty("browser"))) {
			driver = new ChromeDriver();
			logger.info("**open the browser**");
		}else {
			driver = new EdgeDriver();
			logger.info("**open the browser**");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		rb = ResourceBundle.getBundle("dynamic");
		driver.get(rb.getString("url"));
		logger.info("***Enter the URL***");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

		driver.manage().window().maximize();
		logger.info("**maximize the browser**");
	}

	@AfterTest
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
