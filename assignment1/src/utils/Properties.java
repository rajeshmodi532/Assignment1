package utils;

import java.io.FileInputStream;

public class Properties {
//method to get data from .properties file
	public static String getValue(String key) throws Exception{
		java.util.Properties pro=new java.util.Properties();
		FileInputStream fi=new FileInputStream(".\\properties.properties");
		pro.load(fi);
		return pro.getProperty(key);
	}

}
