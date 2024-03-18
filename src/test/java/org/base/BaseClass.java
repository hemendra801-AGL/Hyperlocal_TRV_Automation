package org.base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.trvConfigs.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public String bName;

	public ConfigReader config;

 @BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		bName = "chrome";
		config= new ConfigReader();
		// get the driver setup and type and the browser
		if (bName.equalsIgnoreCase(config.getDataFromConfig("browserName"))) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (bName.equalsIgnoreCase(config.getDataFromConfig("browserName"))) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (bName.equalsIgnoreCase(config.getDataFromConfig("browserName"))) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.get(config.getDataFromConfig("URL"));

	}


	public void tearDown() {
		driver.quit();
	}

}