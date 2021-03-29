package com.bigfish.pom.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.bigfish.utilities.PropertiesOperation;

import io.cucumber.java.Before;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ContextSteps {

	   public static boolean initialized = false;

	   private WebDriver driver;
	   public static HashMap<String, String> contextValuesMap = new HashMap<>();

	   //@Before
	public void setUp() throws Exception {
		if (!initialized) {
			// initialize the driver
			if (PropertiesOperation.getRadicalValueBykey("browser").equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				// options.setExperimentalOption("prefs", chromePrefs);
				options.addArguments("--test-type");
				options.addArguments("--disable-extensions"); // to disable	browser extension  popup
				DesiredCapabilities cap = DesiredCapabilities.chrome();
				cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				cap.setCapability(ChromeOptions.CAPABILITY, options);

				// DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome
				// () ;
				// handlSSLErr.setCapability (CapabilityType.ACCEPT_SSL_CERTS,
				// true);
				System.setProperty("webdriver.chrome.driver",
						"src/test/resources/lib/chromedriver_win32_B89/chromedriver.exe");
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
			initialized = true;
		}
	}

	   public WebDriver getDriver() {
	      return driver;
	   }

	   public static String getContextValue(String key){
			return contextValuesMap.get(key);
	   }
	}