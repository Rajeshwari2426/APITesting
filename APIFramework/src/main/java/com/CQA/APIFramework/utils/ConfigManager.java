package com.CQA.APIFramework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static ConfigManager manager;
	private static final Properties prop = new Properties();
	//private String name;

	private ConfigManager() {
		 InputStream inputStream = ConfigManager.class.getResourceAsStream( "../resources/config.properties");
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ConfigManager getInstance() throws IOException {
		if (manager == null) {
			synchronized (ConfigManager.class) {
				manager = new ConfigManager();
			}

		}
		return manager;

	}

	public String getString(String key) {
		return System.getProperty(key, prop.getProperty(key));
	}

}
