package com.bellar.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MyProperty {
public  String getProperty(String key) {
	Properties properties = new Properties();
	//相当于通过类加载器来找这个路径相当于前端的 绝对路径的形式
	InputStream inputStream = MyProperty.class.getClassLoader().getResourceAsStream("upLoadPath.properties");
	try {
		properties.load(inputStream);
	} catch (IOException e) {
		e.printStackTrace();
	}
	String property = properties.getProperty(key);
	return property;
}
}
