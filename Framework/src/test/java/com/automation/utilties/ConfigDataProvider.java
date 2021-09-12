package com.automation.utilties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;

	public ConfigDataProvider() throws FileNotFoundException {
		File f = new File("./Configurations/Config.properties");
		FileInputStream fstream = new FileInputStream(f);
		pro = new Properties();
		try {
			pro.load(fstream);
		} catch (IOException e) {
			System.out.println("not able to throw error message" + e.getMessage());
		}
	}

	public String getDataConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}

	public String getBrowser() {
		return pro.getProperty("Browser");

	}

	public String getStagingURL() {
		return pro.getProperty("qaURL");
	}
}
