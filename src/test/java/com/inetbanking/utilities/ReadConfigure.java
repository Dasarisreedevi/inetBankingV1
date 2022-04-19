package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfigure {
	Properties prop;

	public ReadConfigure() {

		File src = new File("C:\\Users\\marth\\eclipse-workspace\\inetBankingV1\\Configurations\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is" + e.getMessage());

		}

	}

	public String getApplicationURL() {
		String url = prop.getProperty("url");
		return url;
	}

	public String getUsername() {
		String username = prop.getProperty("username1");
		return username;
	}

	public String getpassword() {
		String password = prop.getProperty("password1");
		return password;
	}

	public String getBrowser() {
		String browser = prop.getProperty("browser");
		return browser;
	}

}
