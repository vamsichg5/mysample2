package com.exilant.qutap.plugin;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class LoadConfiguration {

	public final static String PLUGIN_CONFIG = "seleniumPlugin.config";
	
	public Properties getProperties() {
	Properties prop = new Properties();
// String propFileName = "server.config";
	InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PLUGIN_CONFIG);
	//InputStream inputStream = Config.class.getResourceAsStream(PLUGIN_CONFIG);
	System.out.println("loader:::::::stream:::"+inputStream);
	if (inputStream != null) {
	try {
	prop.load(inputStream);
	} catch (IOException e) {
	System.out.println("Initialization ERROR: could not load "+PLUGIN_CONFIG);
	}
	} else {
	System.out.println("Initialization ERROR: could not load "+PLUGIN_CONFIG);
	}
	return prop;
	}

}