package com.build.qa.build.selenium.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseFramework {
	public WebDriver driver;
	public Wait<WebDriver> wait;
	public static final Logger LOG = LoggerFactory.getLogger(BaseFramework.class);
	public static final String CONFIG_FILE = "./conf/automation.properties";
	public static final String DRIVER_FIREFOX = "firefox";
	public static final String DRIVER_CHROME = "chrome";
	public static Properties configuration;

	@BeforeClass
	public static void beforeClass() throws IOException {
		configuration = new Properties();
		FileInputStream input;

		LOG.info("Loading in configuration file.");
		input = new FileInputStream(new File(CONFIG_FILE));
		configuration.loadFromXML(input);
		input.close();
	}

	@Before
	public void setUpBefore() {
		DesiredCapabilities capabilities;
		// Which driver to use?
		if (DRIVER_CHROME.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
			capabilities = DesiredCapabilities.chrome();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(capabilities);
		} else if (DRIVER_FIREFOX.equalsIgnoreCase(configuration.getProperty("BROWSER"))) {
			capabilities = DesiredCapabilities.firefox();
			driver = new FirefoxDriver(capabilities);
		}
		// Define fluent wait
		wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected String getConfiguration(String config) {
		return configuration.getProperty(config);
	}

	@After
	public void tearDownAfter() {
		LOG.info("Quitting driver.");
		if(driver!=null) {
			driver.close();
		}
	}
	}

