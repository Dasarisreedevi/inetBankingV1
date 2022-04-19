package com.inetbanking.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfigure;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfigure readconfig = new ReadConfigure();

	public String url = readconfig.getApplicationURL();
	public String username1 = readconfig.getUsername();
	public String password1 = readconfig.getBrowser();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")

	@BeforeClass
	public void setUp(String br) {
		logger = Logger.getLogger("ebankig");
		PropertyConfigurator.configure("log4j.property");

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty(("user.dir") + "/Screenshots/" + tname + ".png"));
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken");
	}

}
