package com.ctdcn.fsss.admin.common;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import com.ctdcn.fsss.utils.StringUtil;

public class ConfigReader {
	private static String filename = "config.properties";
	private static Configuration config;

	public static String getPropertyString(String key) {
		try {
			config = new PropertiesConfiguration(filename);

			return StringUtil.nullToStr("" + config.getProperty(key));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static Object getProperty(String key) {
		try {
			config = new PropertiesConfiguration(filename);

			return config.getProperty(key);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return new Object();
	}
}
